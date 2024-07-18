package toyproject.techtalk.dto.boarddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.board.Board;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime createdTime;

    public BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getUser().getId(),
                board.getCreatedTime());
    }
}
