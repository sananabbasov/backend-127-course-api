package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.instructor.InstructorCreateDto;
import az.edu.itbrains.course.dtos.instructor.InstructorDto;
import az.edu.itbrains.course.dtos.instructor.InstructorUpdateDto;
import az.edu.itbrains.course.models.Instructor;
import az.edu.itbrains.course.models.User;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.repositories.InstructorRepository;
import az.edu.itbrains.course.services.InstructorService;
import az.edu.itbrains.course.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<InstructorDto> getInstructors() {
        List<Instructor> categories = instructorRepository.findAll();
        List<InstructorDto> instructorDtoList = categories.stream().map(instructor -> modelMapper.map(instructor, InstructorDto.class)).collect(Collectors.toList());;
        return instructorDtoList;
    }

    @Override
    public ApiResponse createInstructor(InstructorCreateDto instructorCreateDto) {
        User findUser = userService.findUser(instructorCreateDto.getUserId());
        if (findUser == null){
            return new ApiResponse("User not found.",false);
        }
        Instructor instructor = new Instructor();
        instructor.setAbout(instructorCreateDto.getAbout());
        instructor.setUser(findUser);
        instructorRepository.save(instructor);
        return new ApiResponse("Instructor created successfully.",true);
    }

    @Override
    public ApiResponse updateInstructor(Long id, InstructorUpdateDto instructorUpdateDto) {
        try {
            Instructor findInstructor = instructorRepository.findById(id).orElseThrow();
            findInstructor.setAbout(instructorUpdateDto.getAbout());
            instructorRepository.save(findInstructor);
            return new ApiResponse("Instructor update successfully", true);

        }catch (Exception e){
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public InstructorUpdateDto getUpdatedInstructor(Long id) {
        Instructor findInstructor = instructorRepository.findById(id).orElseThrow();
        InstructorUpdateDto instructorUpdateDto = modelMapper.map(findInstructor, InstructorUpdateDto.class);
        return instructorUpdateDto;
    }
}
