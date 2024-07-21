package toyproject.techtalk.dto.memberdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import toyproject.techtalk.domain.tech.Tech;
import toyproject.techtalk.domain.member.Member;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String email;
    private String password;
    private String nickName;
    private Tech interest;

    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getEmail(),
                member.getPassword(),
                member.getNickname(),
                member.getInterest());
    }

    public static List<MemberResponseDto> toListDto(List<Member> members) {
        return members.stream()
                .map(user -> MemberResponseDto.toDto(user))
                .collect(Collectors.toList());
    }
}
