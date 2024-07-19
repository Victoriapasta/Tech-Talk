package toyproject.techtalk.controller.commentcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.techtalk.service.commentservice.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity getAllCommentsByBoardId(@RequestParam(value = "boardId") @PathVariable Long boardId) {
        return new ResponseEntity(commentService.getAllComments(boardId), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
