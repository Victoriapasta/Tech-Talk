package toyproject.techtalk.service.boardservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.board.Board;
import toyproject.techtalk.domain.user.User;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.repository.BoardRepository;
import toyproject.techtalk.repository.UserRepository;
import toyproject.techtalk.utils.exception.user.UserNotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void post(BoardRequestDto boardRequestDto) {
        User user = userRepository.findById(boardRequestDto.getUserId())
                .orElseThrow(UserNotFoundException::new);
        Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .user(user)
                .build();

        boardRepository.save(board);
    }
}
