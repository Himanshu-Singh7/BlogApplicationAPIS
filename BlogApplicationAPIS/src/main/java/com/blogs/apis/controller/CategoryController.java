package com.blogs.apis.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogs.apis.payloads.ApiResponse;
import com.blogs.apis.payloads.CategoryDto;
import com.blogs.apis.service.CategoryService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
	@Autowired
	private CategoryService categoryService;
    // POST Create the Category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
	}

	// PUT Update the category

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);

		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);

	}
	// DELETE 
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId ){
		this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully !!" , true),HttpStatus.OK);
		
	}
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId){
		
		return ResponseEntity.ok(this.categoryService.getCategoryByID(catId));
		
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(@RequestBody CategoryDto categoryDto){
		 return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	

}
