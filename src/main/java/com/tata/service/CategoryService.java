package com.tata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tata.payloads.CategoryDto;

@Service
public interface CategoryService {

	CategoryDto saveCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	public String deleteCategory(Integer categeoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategories();
}
