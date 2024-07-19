package toyproject.techtalk.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String nickName;
    private Tech interest;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getNickname(),
                user.getInterest());
    }

    public static List<UserResponseDto> toListDto(List<User> users) {
        return users.stream()
                .map(user -> UserResponseDto.toDto(user))
                .collect(Collectors.toList());
    }
}
