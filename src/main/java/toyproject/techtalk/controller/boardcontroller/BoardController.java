package toyproject.techtalk.controller.boardcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.boarddto.BoardRequestDto;
import toyproject.techtalk.service.boardservice.BoardService;
import toyproject.techtalk.service.userservice.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    public ResponseEntity post(@Valid @RequestBody BoardRequestDto boardRequestDto) {
        boardService.post(boardRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
