package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
