package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.category.CategoryCreateDto;
import az.edu.itbrains.course.dtos.category.CategoryDto;
import az.edu.itbrains.course.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.course.models.Category;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.repositories.CategoryRepository;
import az.edu.itbrains.course.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());;
        return categoryDtoList;
    }

    @Override
    public ApiResponse createCategory(CategoryCreateDto categoryCreateDto) {

        Category findCategory = categoryRepository.findByName(categoryCreateDto.getName());

        if (findCategory != null){
            return new ApiResponse("Category already exist.",false);
        }
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Category created successfully.",true);
    }

    @Override
    public ApiResponse updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
       try {
            Category findCategory = categoryRepository.findById(id).orElseThrow();
            findCategory.setName(categoryUpdateDto.getName());
            categoryRepository.save(findCategory);
            return new ApiResponse("Category update successfully", true);

       }catch (Exception e){
           return new ApiResponse(e.getMessage(), false);
       }
    }

    @Override
    public CategoryUpdateDto getUpdatedCategory(Long id) {
            Category findCategory = categoryRepository.findById(id).orElseThrow();
            CategoryUpdateDto categoryUpdateDto = modelMapper.map(findCategory, CategoryUpdateDto.class);
            return categoryUpdateDto;
    }
}
