package toyproject.techtalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.techtalk.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
