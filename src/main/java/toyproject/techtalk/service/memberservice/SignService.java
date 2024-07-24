package toyproject.techtalk.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.config.jwt.provider.JwtTokenProvider;
import toyproject.techtalk.domain.member.Member;
import toyproject.techtalk.dto.memberdto.MemberRequestDto;
import toyproject.techtalk.repository.MemberRepository;
import toyproject.techtalk.token.JwtToken;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signUp(MemberRequestDto memberRequestDto) {
        Member member = Member.builder()
                .email(memberRequestDto.getEmail())
                .password(memberRequestDto.getPassword())
                .nickname(memberRequestDto.getNickName())
                .interest(memberRequestDto.getInterest())
                .build();
        memberRepository.save(member);
    }

    @Transactional
    public JwtToken signIn(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        Authentication authentication = authenticationManagerBuilder.getObject()
                .authenticate(authenticationToken);

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        return jwtToken;
    }
}
