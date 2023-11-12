package com.blogs.apis.service;
import java.util.List;
import com.blogs.apis.payloads.PostDto;
import com.blogs.apis.payloads.PostResponse;

public interface PostService {

//Create 
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
//Update 
	PostDto updatePost(PostDto postDto , Integer postId);
//Delete
	
	void deletePost(Integer postId);
// Get single Post
	
	PostDto getPostById(Integer postId);
// Get All Post
	
	PostResponse getAllPost(Integer pageNumber , Integer pageSize , String sortBy, String sortDir);
// get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
//get all post by User
	
	List<PostDto> getPostByUser(Integer userId);
	
	
}
