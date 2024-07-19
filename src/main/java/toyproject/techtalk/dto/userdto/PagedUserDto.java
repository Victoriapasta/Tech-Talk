package toyproject.techtalk.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import toyproject.techtalk.domain.user.User;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedUserDto {

    private Integer totalPages;
    private List<UserResponseDto> userList;

    public static PagedUserDto toDto(Page<User> page) {
        return new PagedUserDto(
                page.getTotalPages(),
                UserResponseDto.toListDto(page.getContent())
        );
    }
}
