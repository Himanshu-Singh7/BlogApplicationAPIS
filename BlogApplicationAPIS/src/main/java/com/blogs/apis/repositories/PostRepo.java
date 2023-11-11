package com.blogs.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.apis.entites.Category;
import com.blogs.apis.entites.Post;
import com.blogs.apis.entites.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

}
