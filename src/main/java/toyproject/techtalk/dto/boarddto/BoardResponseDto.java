package toyproject.techtalk.dto.boarddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.board.Board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime createdTime;

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getUser().getId(),
                board.getCreatedTime());
    }

    public static List<BoardResponseDto> toListDto(List<Board> boards) {
        return boards.stream()
                .map(board -> BoardResponseDto.toDto(board))
                .collect(Collectors.toList());
    }
}
