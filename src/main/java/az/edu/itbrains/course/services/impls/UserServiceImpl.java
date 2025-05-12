package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.dtos.user.UserInfoDto;
import az.edu.itbrains.course.exceptions.ResourceNotFoundException;
import az.edu.itbrains.course.models.User;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.repositories.UserRepository;
import az.edu.itbrains.course.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public ApiResponse registerUser(RegisterDto registerDto) {
        try {
            User findUser = userRepository.findByEmail(registerDto.getEmail());

            if (findUser != null){
                return new ApiResponse("User already exist.", false);
            }

            String password = passwordEncoder.encode(registerDto.getPassword());

            User user = new User();
            user.setName(registerDto.getName());
            user.setSurname(registerDto.getSurname());
            user.setEmail(registerDto.getEmail());
            user.setPassword(password);
            userRepository.save(user);
            return new ApiResponse("User registered successfully", true);

        }catch (Exception e){
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public User findUserByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public UserInfoDto findLoggedUser(String name) {
        User findUser = userRepository.findByEmail(name);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(findUser.getId());
        userInfoDto.setSurname(findUser.getSurname());
        userInfoDto.setName(findUser.getName());
        userInfoDto.setEmail(findUser.getEmail());
        return userInfoDto;
    }
}
