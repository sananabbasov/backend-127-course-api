package az.edu.itbrains.course.dtos.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateDto {

    private String about;
    private Long userId;
}
