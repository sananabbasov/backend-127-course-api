package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.category.CategoryCreateDto;
import az.edu.itbrains.course.dtos.category.CategoryDto;
import az.edu.itbrains.course.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.course.payloads.ApiResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    ApiResponse createCategory(CategoryCreateDto categoryCreateDto);

    ApiResponse updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);

    CategoryUpdateDto getUpdatedCategory(Long id);
}
