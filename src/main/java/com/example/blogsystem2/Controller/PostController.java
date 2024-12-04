package com.example.blogsystem2.Controller;

import com.example.blogsystem2.ApiResponse.ApiResponse;
import com.example.blogsystem2.Model.Post;
import com.example.blogsystem2.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getAllErrors().get(0).getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(msg));
        }

        postService.addPost(post);
        return ResponseEntity.status(201).body(new ApiResponse("Post added successfully"));
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable Integer postId, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getAllErrors().get(0).getDefaultMessage();
            return  ResponseEntity.status(400).body(new ApiResponse(msg));
        }
            postService.updatePost(postId, post);
            return  ResponseEntity.status(201).body(new ApiResponse("Post updated successfully"));
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(201).body(new ApiResponse("Post deleted successfully"));
    }

    // Endpoints 1
    @GetMapping("/get-PostByTitle/{title}")
    public  Post getPostByTitle(@PathVariable String title) {
         return postService.findPostByTitles(title);
    }

    // Endpoints 2
    @GetMapping("/get-findAllCommentById/{postId}")
    public  List<Post> findAllCommentById(@PathVariable Integer postId) {
         return postService.findAllCommentById(postId);
    }

    // Endpoints 3
    @GetMapping("/findAllPostByUser_id/{user_id}")
    public  List<Post> findAllPostByUser_id(@PathVariable Integer user_id) {
        return postService.findAllPostByUser_id(user_id);
    }

    // Endpoints 4
    @GetMapping("/findAllPostByDate/{date}")
    public  List<Post> findAllPostByDate(@PathVariable LocalDate date) {
        return postService.findAllPostByDate(date);
    }

    // Endpoints 5
    @GetMapping("/findAllPostByUser_id/{category_id}")
    public  List<Post> findAllPostByCategory_id(@PathVariable Integer category_id) {
        return postService.findAllPostByCategory_id(category_id);
    }


    // Endpoints 6
    @GetMapping("/findPostByTitleAndUser_id/{title}/{user_id}")
    public  List<Post> findPostByTitleAndUser_id(@PathVariable String title,@PathVariable Integer user_id) {
        return postService.findPostByTitleAndUser_id(title,user_id);
    }


    // Endpoints 7
    @GetMapping("/findAllPostByDate/{minDate}/{maxDate}")
    public  List<Post> findAllPostByBetweenTwoDates(@PathVariable LocalDate minDate, @PathVariable LocalDate maxDate) {
        return postService.findAllPostByBetweenTwoDates(minDate,maxDate);
    }

    // Endpoints 8
    @GetMapping("/displayPostByBadTitle/{title}")
    public List<Post> displayPostByBadTitle(@PathVariable String title) {

        return  postService.displayPostByBadTitle(title);
    }
    // Endpoints 9

    @DeleteMapping("/deletePostByBadTitle/{title}")
    public ResponseEntity<ApiResponse> deletePostByBadTitle(@PathVariable String title) {
        postService.deletePostByBadTitle(title);
        return ResponseEntity.status(201).body(new ApiResponse("Post deleted successfully"));
    }










}
