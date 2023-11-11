package com.blogs.apis.payloads;

import java.util.Date;
import com.blogs.apis.entites.Category;
import com.blogs.apis.entites.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private String title;
	
	private String contant;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto  category;
	
	private UserDto user;
	
	

}
