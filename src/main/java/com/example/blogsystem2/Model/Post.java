package com.example.blogsystem2.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null" )
    @NotNull(message = "categoryId is required.")
    private Integer category_id;

    @Column(columnDefinition = "varchar(20)  not null")
    @NotEmpty(message = "title is required")
    private String title;

    @Column(columnDefinition = "text(300) not null")
    @NotEmpty(message = "content is required")
    private String content;

    @Column(columnDefinition = "int not null" )
    @NotNull(message = "user_id is required.")
    private Integer user_id;


    @Column(columnDefinition = "Date  not null")
    private LocalDate publishDate;


    public Post() {
    }

    public Post(Integer id, Integer category_id, String title, String content, Integer user_id, LocalDate publishDate) {
        this.id = id;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}


