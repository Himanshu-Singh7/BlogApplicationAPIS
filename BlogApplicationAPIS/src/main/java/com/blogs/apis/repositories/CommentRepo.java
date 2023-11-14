package com.blogs.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.apis.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    
	
}
