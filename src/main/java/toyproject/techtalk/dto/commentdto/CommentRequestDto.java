package toyproject.techtalk.dto.commentdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.comment.Comment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentRequestDto {

    private Long id;
    private Long boardId;
    private Long userId;
    private String content;
    private LocalDateTime createdTime;

    public CommentRequestDto toDto(Comment comment) {
        return new CommentRequestDto(
                comment.getId(),
                comment.getBoard().getId(),
                comment.getUser().getId(),
                comment.getContent(),
                comment.getCreatedTime());
    }
}
