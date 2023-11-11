package com.blogs.apis.service;
import java.util.List;
import com.blogs.apis.entites.Post;
import com.blogs.apis.payloads.PostDto;

public interface PostService {

//Create 
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
//Update 
	Post updatePost(PostDto postDto , Integer postId);
//Delete
	
	void deletePost(Integer postId);
// Get single Post
	
	Post getPostById(Integer postId);
// Get All Post
	
	List<Post> getAllPost();
// get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
//get all post by User
	
	List<PostDto> getPostByUser(Integer userId);
	
	
}