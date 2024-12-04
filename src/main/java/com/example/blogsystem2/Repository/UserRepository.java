package com.example.blogsystem2.Repository;


import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.id = :id")
    User findUserById(@Param("id") Integer id);

    @Query("select u from Post u")
    List<User> getAllUsers();




}