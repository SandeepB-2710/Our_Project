package com.tata.payloads;

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
	@Size(min=4, message="Category name must be greater than 4.")
	private String categoryTitle;

	@NotBlank
	@Size(min=10, message="Category Tagline must be greater than 10.")
	private String categoryTagLine;

	private String categoryImage;

	@NotBlank
	private String categoryDescription;

}
