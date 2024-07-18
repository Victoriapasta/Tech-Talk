package toyproject.techtalk.controller.usercontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.techtalk.dto.userdto.UserRequestDto;
import toyproject.techtalk.service.userservice.SignService;
import toyproject.techtalk.service.userservice.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SignService signService;

}
