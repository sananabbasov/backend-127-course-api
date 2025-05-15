package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.MethodPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodPermissionRepository extends JpaRepository<MethodPermission, Long> {
    MethodPermission findByName(String methodName);
}
