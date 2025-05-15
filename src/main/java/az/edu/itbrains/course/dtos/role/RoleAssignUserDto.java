package az.edu.itbrains.course.dtos.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssignUserDto {
    private String email;
    private Long roleId;
}
