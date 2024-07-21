package toyproject.techtalk.dto.commentdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.comment.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class CommentResponseDto {

    private Long id;
    private Long boardId;
    private Long userId;
    private String content;
    private LocalDateTime createdTime;

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getBoard().getId(),
                comment.getMember().getId(),
                comment.getContent(),
                comment.getCreatedTime());
    }

    public static List<CommentResponseDto> toListDto(List<Comment> comments) {
        return comments.stream()
                .map(comment -> CommentResponseDto.toDto(comment))
                .collect(Collectors.toList());
    }
}
