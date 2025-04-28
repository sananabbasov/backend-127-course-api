package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
