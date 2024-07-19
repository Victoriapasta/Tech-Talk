package toyproject.techtalk.controller.boardcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.dto.boarddto.BoardResponseDto;
import toyproject.techtalk.dto.boarddto.PagedBoardDto;
import toyproject.techtalk.service.boardservice.BoardService;
import toyproject.techtalk.service.userservice.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody BoardRequestDto boardRequestDto) {
        boardService.post(boardRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagedBoardDto> getAllBoards(@RequestParam(value = "page", defaultValue = "0") int page) {
        PagedBoardDto pagedBoardDto = boardService.getAllBoards(page);
        return new ResponseEntity<>(pagedBoardDto, HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
