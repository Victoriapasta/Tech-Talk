package toyproject.techtalk.dto.boarddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import toyproject.techtalk.domain.board.Board;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedBoardDto {

    private Integer totalPages;
    private List<Board> boardList;

    public static PagedBoardDto toDto(Page<Board> page) {
        return new PagedBoardDto(
                page.getTotalPages(),
                page.getContent()
        );
    }
}
