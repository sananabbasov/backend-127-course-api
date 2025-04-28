package az.edu.itbrains.course.services;

import az.edu.itbrains.course.models.User;

public interface UserService {
    User findUser(Long userId);
}
