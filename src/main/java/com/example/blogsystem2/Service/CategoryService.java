package com.example.blogsystem2.Service;

import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategory();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);

    }
    public void updateCategory(Integer categoryId , Category category) {
        Category  category1 = categoryRepository.findCategoryById(categoryId);
          if (category1 == null) {
              throw new RuntimeException("Category not found");
          }
          category1.setName(category.getName());
          categoryRepository.save(category1);
    }

    public void deleteCategory(Integer categoryId) {
        Category  category1 = categoryRepository.findCategoryById(categoryId);
        if (category1 == null) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.delete(category1);
    }
}
