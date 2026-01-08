package com.tata.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tata.entity.Category;
import com.tata.payloads.CategoryDto;
import com.tata.repo.CategoryRepository;
import com.tata.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modeMapper;
	
	
	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		
		Category category = this.modeMapper.map(categoryDto, Category.class);
		Category saveCategory = this.categoryRepository.save(category);
		return this.modeMapper.map(saveCategory, CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> category = this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos =category.stream().map((cat)->this.modeMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}
	
	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElse(null);
		return this.modeMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		return null;
	}

	@Override
	public String deleteCategeory(Integer categeoryId) {
		Category category = this.categoryRepository.findById(categeoryId).orElse(null);
		  categoryRepository.delete(category);
		  
		  return "Category with ID: "+categeoryId+" Deleted Successfully";
	}

}

