package com.example.blogsystem2.Service;

import com.example.blogsystem2.Model.Category;
import com.example.blogsystem2.Model.Post;
import com.example.blogsystem2.Model.User;
import com.example.blogsystem2.Repository.CategoryRepository;
import com.example.blogsystem2.Repository.PostRepository;
import com.example.blogsystem2.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service

public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public void  addPost(Post post) {
        User user1 = userRepository.findUserById(post.getUser_id());

        if(user1 == null) {
            throw new RuntimeException("User not found");
        }

       Category category1 = categoryRepository.findCategoryById(post.getCategory_id());

        if(category1 == null) {
            throw new RuntimeException("category  not found");
        }
        post.setPublishDate(LocalDate.now());

        postRepository.save(post);
    }

    public void updatePost(Integer postId, Post post) {
        Post post1 = postRepository.findPostById(postId);
        if(post1 == null) {
            throw new RuntimeException("Post not found");
        }
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        post1.setCategory_id(post.getCategory_id());
        post1.setUser_id(post.getUser_id());
        post1.setPublishDate(LocalDate.now());
        postRepository.save(post1);
    }

    public void deletePost(Integer postId) {
        Post post1 = postRepository.findPostById(postId);
        if(post1 == null) {
            throw new RuntimeException("Post not found");
        }
        postRepository.delete(post1);
    }

    public Post findPostByTitles(String title) {
         Post posts = postRepository.findPostByTitle(title);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }

        return postRepository.findPostByTitle(title);
    }



    public List<Post> findAllCommentById(Integer postId) {
        List<Post> posts = postRepository.findAllCommentById(postId);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findAllCommentById(postId);
    }

    public List<Post> findAllPostByUser_id(Integer user_id) {
        List<Post> posts = postRepository.findAllPostByUser_id(user_id);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findAllPostByUser_id(user_id);
    }

    public List<Post> findAllPostByDate(LocalDate date) {
        List<Post> posts = postRepository.findAllPostByDate(date);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findAllPostByDate(date);
    }


    public List<Post> findAllPostByCategory_id(Integer category_id) {
        List<Post> posts = postRepository.findAllPostByCategory_id(category_id);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findAllPostByCategory_id(category_id);
    }


    public List<Post> findPostByTitleAndUser_id(String title, Integer user_id) {
        List<Post> posts = postRepository.findPostByTitleAndUser_id(title,user_id);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findPostByTitleAndUser_id(title,user_id);
    }




    public List<Post> findAllPostByBetweenTwoDates(LocalDate minDate, LocalDate maxDate) {
        List<Post> posts = postRepository.findAllPostByBetweenTwoDates(minDate,maxDate);
        if (posts == null) {
            throw new RuntimeException("Post not found");
        }
        return postRepository.findAllPostByBetweenTwoDates(minDate,maxDate);
    }

  // delete bad title
    public void deletePostByBadTitle(String title) {
        Post post1 = postRepository.findPostByTitle(title);
        if(post1 == null) {
            throw new RuntimeException("Post not found");
        }
        postRepository.delete(post1);
    }

    // display bad title
    public List<Post> displayPostByBadTitle(String title) {
        List<Post>  posts = postRepository.displayPostByBadTitle(title);
        if(posts == null) {
            throw new RuntimeException("Post not found");
        }
       return  posts;
    }

}
