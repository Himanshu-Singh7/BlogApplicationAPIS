package com.blogs.apis.service;

import com.blogs.apis.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto , Integer postId);
	
	void deleteComment(Integer commentId);
}
