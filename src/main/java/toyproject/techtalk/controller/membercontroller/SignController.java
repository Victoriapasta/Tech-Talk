package toyproject.techtalk.controller.membercontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.memberdto.MemberRequestDto;
import toyproject.techtalk.dto.memberdto.signdto.SignInRequestDto;
import toyproject.techtalk.service.memberservice.SignService;
import toyproject.techtalk.token.JwtToken;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sign")
public class SignController {

    private final SignService signService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        signService.signUp(memberRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public JwtToken signIn(@Valid @RequestBody SignInRequestDto signInRequestDto) {
        String email = signInRequestDto.getEmail();
        String password = signInRequestDto.getPassword();

        JwtToken jwtToken = signService.signIn(email, password);

        return jwtToken;
    }
}
