package com.example.blogsystem2.Service;

import com.example.blogsystem2.Model.User;
import com.example.blogsystem2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.jni.SSL.getTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {

        user.setRegistration_date(LocalDate.now());

        userRepository.save(user);
    }

    public void updateUser(Integer userId, User user) {
        User user1 = userRepository.findUserById(userId);

        if (user1 == null) {
            throw new RuntimeException("User not found");
        }
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        userRepository.delete(user);
    }

}
