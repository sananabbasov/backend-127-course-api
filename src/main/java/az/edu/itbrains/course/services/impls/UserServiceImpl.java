package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.models.User;
import az.edu.itbrains.course.repositories.UserRepository;
import az.edu.itbrains.course.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
