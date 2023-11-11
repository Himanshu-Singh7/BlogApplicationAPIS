package com.blogs.apis.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogs.apis.entites.Category;
import com.blogs.apis.entites.Post;
import com.blogs.apis.entites.User;
import com.blogs.apis.exceptions.ResourceNotFoundException;
import com.blogs.apis.payloads.PostDto;
import com.blogs.apis.payloads.UserDto;
import com.blogs.apis.repositories.CategoryRepo;
import com.blogs.apis.repositories.PostRepo;
import com.blogs.apis.repositories.UserRepo;
import com.blogs.apis.service.PostService;

@Service
public class PostServiceImp implements PostService {
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newSavepost = this.postRepo.save(post);
		return this.modelMapper.map(newSavepost, PostDto.class);

	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User users = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));

		List<Post> posts = this.postRepo.findByUser(users);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;

	}

}
