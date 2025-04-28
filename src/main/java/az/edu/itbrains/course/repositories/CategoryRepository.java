package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
