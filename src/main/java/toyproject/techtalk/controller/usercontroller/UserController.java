package toyproject.techtalk.controller.usercontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.techtalk.dto.userdto.PagedUserDto;
import toyproject.techtalk.dto.userdto.UserRequestDto;
import toyproject.techtalk.service.userservice.SignService;
import toyproject.techtalk.service.userservice.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SignService signService;

    @GetMapping
    public ResponseEntity<PagedUserDto> getAllUsers(@RequestParam(value = "page", defaultValue = "0"), int page) {
        PagedUserDto pagedUserDto = userService.getAllUsers(page);
        return new ResponseEntity(pagedUserDto, HttpStatus.OK);
    }
}
