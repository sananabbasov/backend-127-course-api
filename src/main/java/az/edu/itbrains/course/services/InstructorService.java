package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.instructor.InstructorCreateDto;
import az.edu.itbrains.course.dtos.instructor.InstructorDto;
import az.edu.itbrains.course.dtos.instructor.InstructorUpdateDto;
import az.edu.itbrains.course.payloads.ApiResponse;

import java.util.List;

public interface InstructorService {
    List<InstructorDto> getInstructors();

    ApiResponse createInstructor(InstructorCreateDto instructorCreateDto);

    ApiResponse updateInstructor(Long id, InstructorUpdateDto instructorUpdateDto);

    InstructorUpdateDto getUpdatedInstructor(Long id);
}
