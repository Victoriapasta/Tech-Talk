package toyproject.techtalk.dto.memberdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import toyproject.techtalk.domain.member.Member;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedMemberDto {

    private Integer totalPages;
    private List<MemberResponseDto> userList;

    public static PagedMemberDto toDto(Page<Member> page) {
        return new PagedMemberDto(
                page.getTotalPages(),
                MemberResponseDto.toListDto(page.getContent())
        );
    }
}
