package com.blogs.apis.service;

import java.util.List;

import com.blogs.apis.payloads.CategoryDto;

public interface CategoryService {

	// Create
      CategoryDto createCategory(CategoryDto categoryDto);

	// getAll
	 List<CategoryDto> getAllCategory();

	// get
	 CategoryDto getCategoryByID(Integer categoryId);
    
	// Upadte
	 CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	 void deleteCategory(Integer categoryId);

}
