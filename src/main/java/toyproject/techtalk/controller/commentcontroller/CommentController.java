package toyproject.techtalk.controller.commentcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.service.commentservice.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity getAllComments(@RequestParam(value = "boardId") @PathVariable Long boardId) {
        return new ResponseEntity(commentService.getAllComments(boardId), HttpStatus.OK);
    }
}
