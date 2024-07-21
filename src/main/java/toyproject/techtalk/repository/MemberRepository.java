package toyproject.techtalk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.techtalk.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findALl(Pageable pageable);
}
