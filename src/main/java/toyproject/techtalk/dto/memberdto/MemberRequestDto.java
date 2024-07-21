package toyproject.techtalk.dto.memberdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.domain.member.Member;

@Getter
@AllArgsConstructor
public class MemberRequestDto {

    private Long id;
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    private String nickName;
    private Tech interest;

    public MemberRequestDto toDto(Member member) {
        return new MemberRequestDto(
                member.getId(),
                member.getEmail(),
                member.getPassword(),
                member.getNickname(),
                member.getInterest());
    }
}
