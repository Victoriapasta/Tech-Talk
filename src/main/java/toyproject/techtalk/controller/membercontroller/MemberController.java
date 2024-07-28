package toyproject.techtalk.controller.membercontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.techtalk.dto.memberdto.PagedMemberDto;
import toyproject.techtalk.service.memberservice.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<PagedMemberDto> getAllMembers(@RequestParam(value = "page", defaultValue = "0") int page) {
        PagedMemberDto pagedMemberDto = memberService.getAllMembers(page);
        return new ResponseEntity(pagedMemberDto, HttpStatus.OK);
    }
}
