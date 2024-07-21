package toyproject.techtalk.controller.membercontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.memberdto.MemberRequestDto;
import toyproject.techtalk.service.memberservice.SignService;
import toyproject.techtalk.service.memberservice.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final SignService signService;
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity signUp(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        signService.signUp(memberRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
