package toyproject.techtalk.dto.boarddto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.board.Board;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardRequestDto {

    private Long id;
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    private Long userId;
    private LocalDateTime createdTime;

    public BoardRequestDto toDto(Board board) {
        return new BoardRequestDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getMember().getId(),
                board.getCreatedTime());
    }
}
