package toyproject.techtalk.config.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.GenericFilterBean;
import toyproject.techtalk.config.jwt.provider.JwtTokenProvider;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;

    private static final String AUTO_HEADER = "Authorization";
    private static final String BEARER = "Bearer";
    private static final String REFRESH_HEADER = "Auth";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    }
}
