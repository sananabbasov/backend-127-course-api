package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
