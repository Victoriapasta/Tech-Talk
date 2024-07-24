package toyproject.techtalk.dto.memberdto.signdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import toyproject.techtalk.domain.member.Member;

@Getter
@Builder
@AllArgsConstructor
public class SignUpDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "비밀번호는 8자리 이상의 알파벳, 숫자, 특수문자를 포함해야 합니다.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Pattern(regexp = "^[A-Za-z가-힣0-9]", message = "한글, 알파벳, 숫자로 구성된 닉네임을 입력해주세요.")
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    public static SignUpDto toDto(Member member) {
        return SignUpDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
    }
}
