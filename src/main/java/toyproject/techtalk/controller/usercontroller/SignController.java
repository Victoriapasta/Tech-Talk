package toyproject.techtalk.controller.usercontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.userdto.UserRequestDto;
import toyproject.techtalk.service.userservice.SignService;
import toyproject.techtalk.service.userservice.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final SignService signService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity signUp(@Valid @RequestBody UserRequestDto userRequestDto) {
        signService.signUp(userRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
