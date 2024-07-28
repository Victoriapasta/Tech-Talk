package toyproject.techtalk.config.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import toyproject.techtalk.domain.member.Member;
import toyproject.techtalk.repository.MemberRepository;
import toyproject.techtalk.utils.exception.member.MemberNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails = memberRepository.findByEmail(email)
                .map(this::createUserDetails)
                .orElseThrow(MemberNotFoundException::new);

        return userDetails;
    }

    private UserDetails createUserDetails(Member member) {
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
