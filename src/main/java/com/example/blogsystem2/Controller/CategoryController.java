package com.example.blogsystem2.Controller;

import com.example.blogsystem2.ApiResponse.ApiResponse;
import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Model.User;
import com.example.blogsystem2.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public List<Category> getAllCategorys() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            ResponseEntity.status(400).body(new ApiResponse(errorMessage));
        }

        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("category added successfully"));
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Integer categoryId, @RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
            ResponseEntity.status(400).body(new ApiResponse(errorMessage));
        }
        categoryService.updateCategory(categoryId, category);
        return ResponseEntity.status(200).body(new ApiResponse("category updated successfully"));
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(200).body(new ApiResponse("category deleted successfully"));

    }
}
