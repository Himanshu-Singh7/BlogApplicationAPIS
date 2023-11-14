package com.blogs.apis.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blogs.apis.entites.Comment;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class PostDto {
	
	private String postId;

	private String title;
	
	private String contant;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto  category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
	

}
