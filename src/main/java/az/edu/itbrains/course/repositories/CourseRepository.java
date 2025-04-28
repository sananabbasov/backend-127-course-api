package az.edu.itbrains.course.repositories;


import az.edu.itbrains.course.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
