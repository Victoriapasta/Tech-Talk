package toyproject.techtalk.service.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.user.User;
import toyproject.techtalk.dto.userdto.UserRequestDto;
import toyproject.techtalk.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SignService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserRequestDto userRequestDto) {
        User user = User.builder()
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .nickname(userRequestDto.getNickName())
                .interest(userRequestDto.getInterest())
                .build();
        userRepository.save(user);
    }


}
