package com.tata.controller;

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

import com.tata.payloads.ApiResponse;
import com.tata.payloads.CategoryDto;
import com.tata.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/ping")
	public String apicheck() {
		
		return "Category working";
	}
	
	@PostMapping("/saveCategory")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto saveCategoryDto = this.categoryService.saveCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(saveCategoryDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/allCategories")
	public ResponseEntity<List<CategoryDto>> getCategory(){
		
		return new ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategories(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Integer categoryId){
		
		return new ResponseEntity<CategoryDto>(this.categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Integer categoryId,@RequestBody CategoryDto categoryDto){
		
		CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);
		
		return new ResponseEntity<CategoryDto>(updateCategoryDto, HttpStatus.OK);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer categoryId){
//		
//	String msg=	this.categoryService.deleteCategory(categoryId);
//		
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
		this.categoryService.deleteCategory(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category with id "+id+ " Deleted Successfully...!!",true), HttpStatus.OK);
	}
	
}
