package toyproject.techtalk.service.boardservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.board.Board;
import toyproject.techtalk.domain.member.Member;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.dto.boarddto.BoardResponseDto;
import toyproject.techtalk.dto.boarddto.PagedBoardDto;
import toyproject.techtalk.repository.BoardRepository;
import toyproject.techtalk.repository.MemberRepository;
import toyproject.techtalk.utils.exception.board.BoardNotFoundException;
import toyproject.techtalk.utils.exception.member.MemberNotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void postBoard(BoardRequestDto boardRequestDto) {
        Member member = memberRepository.findById(boardRequestDto.getUserId())
                .orElseThrow(MemberNotFoundException::new);
        Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .member(member)
                .build();

        boardRepository.save(board);
    }

    public PagedBoardDto getAllBoards(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        PagedBoardDto pagedBoardDto = PagedBoardDto.toDto(boardRepository.findAll(pageable));
        return pagedBoardDto;
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(BoardNotFoundException::new);
        board.updateBoard(boardRequestDto);
        return BoardResponseDto.toDto(board);
    }

    @Transactional
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
        boardRepository.delete(board);
    }
}
