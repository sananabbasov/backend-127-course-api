package az.edu.itbrains.course.dtos.instructor;

import az.edu.itbrains.course.dtos.user.UserInstructorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorListDto {
    private Long id;
    private String about;
    private UserInstructorDto user;
}
