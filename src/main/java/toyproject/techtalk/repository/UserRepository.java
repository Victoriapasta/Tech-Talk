package toyproject.techtalk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.techtalk.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findALl(Pageable pageable);
}
