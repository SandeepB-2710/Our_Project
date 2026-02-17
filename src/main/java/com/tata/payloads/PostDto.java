package com.tata.payloads;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private Integer postId;

	@NotEmpty
	private String title;

	@NotEmpty
	private String content;

	private String postImage;
//	private String postVedio;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private CategoryDto category;
	private UserDto user;
	private Set<CommentDto> comments = new HashSet<>();
}
