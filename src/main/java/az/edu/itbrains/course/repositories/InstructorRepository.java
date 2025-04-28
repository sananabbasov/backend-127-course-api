package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
