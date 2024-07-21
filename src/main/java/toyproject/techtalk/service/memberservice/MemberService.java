package toyproject.techtalk.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.dto.memberdto.PagedMemberDto;
import toyproject.techtalk.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public PagedMemberDto getAllMembers(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        PagedMemberDto pagedMemberDto = PagedMemberDto.toDto(memberRepository.findAll(pageable));
        return pagedMemberDto;
    }
}
