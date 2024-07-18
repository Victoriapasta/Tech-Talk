package toyproject.techtalk.dto.userdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.domain.user.User;

@Getter
@AllArgsConstructor
public class UserRequestDto {

    private Long id;
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    private String nickName;
    private Tech interest;

    public UserRequestDto toDto(User user) {
        return new UserRequestDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getNickname(),
                user.getInterest());
    }
}
