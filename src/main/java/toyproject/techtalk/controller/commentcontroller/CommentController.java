package toyproject.techtalk.controller.commentcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.techtalk.dto.commentdto.CommentRequestDto;
import toyproject.techtalk.service.commentservice.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity getAllCommentsByBoardId(@RequestParam(value = "boardId") @PathVariable Long boardId) {
        return new ResponseEntity(commentService.getAllComments(boardId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateComment(@PathVariable Long id, @Valid @ModelAttribute CommentRequestDto commentRequestDto) {
        return new ResponseEntity(commentService.updateComment(id, commentRequestDto), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    //TODO : 댓글 작성 코드 만들기
}
