package toyproject.techtalk.service.boardservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.board.Board;
import toyproject.techtalk.domain.user.User;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.dto.boarddto.BoardResponseDto;
import toyproject.techtalk.dto.boarddto.PagedBoardDto;
import toyproject.techtalk.repository.BoardRepository;
import toyproject.techtalk.repository.UserRepository;
import toyproject.techtalk.utils.exception.board.BoardNotFoundException;
import toyproject.techtalk.utils.exception.user.UserNotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
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

    public PagedBoardDto getAllBoards(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        PagedBoardDto pagedBoardDto = PagedBoardDto.toDto(boardRepository.findAll(pageable));
        return pagedBoardDto;
    }

    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(BoardNotFoundException::new);
        board.updateBoard(boardRequestDto);
        return BoardResponseDto.toDto(board);
    }

    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        boardRepository.delete(board);
    }
}
