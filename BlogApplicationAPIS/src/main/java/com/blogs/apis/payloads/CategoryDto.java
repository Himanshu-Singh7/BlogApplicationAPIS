package com.blogs.apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {
    
	private Integer categoryId;

	@NotBlank
	@Size(min = 4,message = "Minimum category title is 4")
	private String categoryTitle;
    @NotBlank
    @Size(min = 10 , message = "minum category discription is 10")
	private String categoryDiscription;

}
