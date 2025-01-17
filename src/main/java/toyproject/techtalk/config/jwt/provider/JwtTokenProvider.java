package toyproject.techtalk.config.jwt.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import toyproject.techtalk.config.details.MemberDetails;
import toyproject.techtalk.token.JwtToken;
import toyproject.techtalk.utils.exception.security.NotFoundAuthFromToken;
import toyproject.techtalk.utils.exception.security.ValidateTokenException;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private static final Long tokenValiditySecond = 86400000L;
    private static final String AUTH_KEY = "AUTH";
    private static final String BEARER = "Bearer";

    private final Key key;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtToken generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Instant issue = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant expiration = issue.plus(tokenValiditySecond, ChronoUnit.DAYS);

        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTH_KEY, authorities)
                .setExpiration(Date.from(issue))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(Date.from(expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtToken.builder()
                .grantType(BEARER)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public Authentication getAuthenticationFromToken(String accessToken) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();

        if (claims.get(AUTH_KEY) == null) {
            throw new NotFoundAuthFromToken();
        }

        List<String> authorities = Arrays.asList(claims.get(AUTH_KEY).toString().split(","));

        Collection<? extends GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth))
                .collect(Collectors.toList());

        MemberDetails principal = new MemberDetails(
                (Long) claims.get("id"),
                (String) claims.get("email"),
                null,
                grantedAuthorities
        );

        return new UsernamePasswordAuthenticationToken(principal, accessToken, grantedAuthorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException exception) {
            throw new ValidateTokenException();
        } catch (UnsupportedJwtException e) {
            throw new ValidateTokenException();
        } catch (IllegalArgumentException e) {
            throw new ValidateTokenException();
        }
    }
}
