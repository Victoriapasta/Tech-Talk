package toyproject.techtalk;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.board.Board;
import toyproject.techtalk.domain.member.Member;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.repository.BoardRepository;
import toyproject.techtalk.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initDB() {
        initMembers();
//        initBoards();
    }

    @Transactional
    public void initMembers() {
        memberRepository.save(Member.builder()
                        .email("test@naver.com")
                        .password(passwordEncoder.encode("test123!"))
                        .interest(Tech.JAVA)
                        .nickname("히데")
                .build());
    }

    @Transactional
    public void initBoards() {
        Member member = memberRepository.findAll().get(0);

        boardRepository.save(Board.builder()
                        .title("testTitle")
                        .content("asdfasdfasdfsadf")
                        .member(member)
                .build());
    }
}
