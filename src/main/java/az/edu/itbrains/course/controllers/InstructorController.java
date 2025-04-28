package az.edu.itbrains.course.controllers;


import az.edu.itbrains.course.dtos.instructor.InstructorCreateDto;
import az.edu.itbrains.course.dtos.instructor.InstructorDto;
import az.edu.itbrains.course.dtos.instructor.InstructorUpdateDto;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@RequiredArgsConstructor
public class InstructorController {


    private final InstructorService instructorService;

    @GetMapping("/getall")
    public ResponseEntity<List<InstructorDto>> getAll(){

        List<InstructorDto> instructorDtoList = instructorService.getInstructors();
        return new ResponseEntity<>(instructorDtoList, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody InstructorCreateDto instructorCreateDto){
        ApiResponse response = instructorService.createInstructor(instructorCreateDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody InstructorUpdateDto instructorUpdateDto){
        ApiResponse response = instructorService.updateInstructor(id, instructorUpdateDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<InstructorUpdateDto> update(@PathVariable Long id){
        InstructorUpdateDto response = instructorService.getUpdatedInstructor(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
