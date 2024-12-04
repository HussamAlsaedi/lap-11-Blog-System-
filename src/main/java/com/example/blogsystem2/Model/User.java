package com.example.blogsystem2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "userName is required")
    @Size(min=5, message = "userName Length more than 4 characters")
    @Column(columnDefinition = "varchar(15) unique not null")
    private String username;

    @NotEmpty(message = "password is required")
    @Column(columnDefinition = "varchar(20)  not null")
    private String password;

    @NotEmpty(message = "email is required")
    @Email(message = "email not correct.")
    @Column(columnDefinition = "varchar(80)  not null")
    private String email;

     @JsonFormat(pattern = "yyy-mm-dd")
    @Column(columnDefinition = "Date  not null")
    private LocalDate registration_date;

    public User(Integer id, String username, String password, String email, LocalDate registration_date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registration_date = registration_date;
    }

    public User() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }
}
