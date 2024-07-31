package toyproject.techtalk.controller.boardcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.dto.boarddto.PagedBoardDto;
import toyproject.techtalk.service.boardservice.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity postBoard(@Valid @RequestBody BoardRequestDto boardRequestDto) {
        boardService.postBoard(boardRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBoards(@RequestParam(defaultValue = "0") Integer page) {
        PagedBoardDto pagedBoardDto = boardService.getAllBoards(page);
        return new ResponseEntity(pagedBoardDto, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateBoard(@PathVariable Long id, @Valid @ModelAttribute BoardRequestDto boardRequestDto) {
        return new ResponseEntity(boardService.updateBoard(id, boardRequestDto), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
