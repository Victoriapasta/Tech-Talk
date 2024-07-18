package toyproject.techtalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.techtalk.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
