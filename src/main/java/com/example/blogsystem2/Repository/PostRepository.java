package com.example.blogsystem2.Repository;

import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Model.Post;
import com.example.blogsystem2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where p.id = :id")
    Post findPostById(@Param("id") Integer id);

    @Query("select p from Post p")
    List<Post> getAllPosts();

    @Query("select p from Post p where p.user_id =:user_id ")
    List<Post> findAllPostByUser_id(@Param("user_id") Integer user_id);

    @Query("select p from Post p where p.category_id =:category_id ")
    List<Post> findAllPostByCategory_id(@Param("category_id") Integer category_id);

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    Post findPostByTitle(@Param("title") String title);

    @Query("select p from Post p where p.id = :post_id")
    List<Post>  findAllCommentById(@Param("post_id") Integer post_id);


    @Query("select p from Post p where p.publishDate  > :date ")
    List<Post> findAllPostByDate(@Param("date") LocalDate date);


    @Query("SELECT p FROM Post p WHERE p.title = :title and p.user_id =:user_id")
    List<Post> findPostByTitleAndUser_id(@Param("title") String title, @Param("user_id") Integer user_id);


    @Query("select p from Post p where p.publishDate  between  :minDate  and :maxDate ")
    List<Post> findAllPostByBetweenTwoDates(@Param("minDate") LocalDate min1,@Param("maxDate") LocalDate max);


    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post>   displayPostByBadTitle(@Param("title") String title);
















}
