package toyproject.techtalk.service.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.dto.userdto.PagedUserDto;
import toyproject.techtalk.dto.userdto.UserResponseDto;
import toyproject.techtalk.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public PagedUserDto getAllUsers(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        PagedUserDto pagedUserDto = PagedUserDto.toDto(userRepository.findALl(pageable));
        return pagedUserDto;
    }
}
