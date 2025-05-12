package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.dtos.user.UserInfoDto;
import az.edu.itbrains.course.models.User;
import az.edu.itbrains.course.payloads.ApiResponse;

public interface UserService {
    User findUser(Long userId);

    ApiResponse registerUser(RegisterDto registerDto);

    User findUserByEmail(String username);

    UserInfoDto findLoggedUser(String name);
}
