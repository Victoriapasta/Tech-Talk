package toyproject.techtalk.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.member.Member;
import toyproject.techtalk.dto.memberdto.MemberRequestDto;
import toyproject.techtalk.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;

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
}
