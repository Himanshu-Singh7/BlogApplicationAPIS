package com.blogs.apis.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.apis.entites.Comment;
import com.blogs.apis.entites.Post;
import com.blogs.apis.exceptions.ResourceNotFoundException;
import com.blogs.apis.payloads.CommentDto;
import com.blogs.apis.repositories.CommentRepo;
import com.blogs.apis.repositories.PostRepo;
import com.blogs.apis.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
	private PostRepo postRepo;
	
    @Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
	    Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId ));
	    Comment comment = this.modelMapper.map(commentDto, Comment.class);
	    comment.setPost(post);
	    Comment savecomment = this.commentRepo.save(comment);
		return this.modelMapper.map(savecomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
	    this.commentRepo.delete(com);
	}

}
