package az.edu.itbrains.course.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInstructorDto {
    private Long id;
    private String name;
    private String surname;
}
