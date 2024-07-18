package toyproject.techtalk.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.domain.user.User;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private Tech interest;

    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getInterest());
    }
}
