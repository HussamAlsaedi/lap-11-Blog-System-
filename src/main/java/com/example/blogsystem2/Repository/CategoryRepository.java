package com.example.blogsystem2.Repository;

import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select u from Category u where u.id = :id")
    Category findCategoryById(@Param("id") Integer id);

    @Query("select u from Category u")
    List<Category> getAllCategory();
}
