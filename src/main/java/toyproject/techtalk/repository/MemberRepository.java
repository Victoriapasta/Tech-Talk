package toyproject.techtalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.techtalk.domain.member.Member;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
