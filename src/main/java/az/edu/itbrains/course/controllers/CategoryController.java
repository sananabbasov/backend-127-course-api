package az.edu.itbrains.course.controllers;


import az.edu.itbrains.course.dtos.category.CategoryCreateDto;
import az.edu.itbrains.course.dtos.category.CategoryDto;
import az.edu.itbrains.course.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDto>> getAll(){

        List<CategoryDto> categoryDtoList = categoryService.getCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }


    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority(@securityService.privilege('create'))")
    public ResponseEntity<ApiResponse> create(@RequestBody CategoryCreateDto categoryCreateDto){
        ApiResponse response = categoryService.createCategory(categoryCreateDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody CategoryUpdateDto categoryUpdateDto){
        ApiResponse response = categoryService.updateCategory(id, categoryUpdateDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<CategoryUpdateDto> update(@PathVariable Long id){
        CategoryUpdateDto response = categoryService.getUpdatedCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
