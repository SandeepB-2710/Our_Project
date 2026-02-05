package com.tata.controller;

import java.time.LocalDateTime;
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
import com.tata.payloads.PostDto;
import com.tata.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/savePost")
	public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {

		PostDto savedPost = this.postService.savePost(postDto);
		return new ResponseEntity<PostDto>(savedPost, HttpStatus.CREATED);
	}

	@GetMapping("/allPosts")
	public ResponseEntity<List<PostDto>> getAllPosts() {

		return new ResponseEntity<List<PostDto>>(this.postService.getAllPosts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("id") Integer postId) {

		return new ResponseEntity<PostDto>(this.postService.getPostById(postId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable("id") Integer postId, @RequestBody PostDto postDto) {

		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("id") Integer postId) {

		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse(LocalDateTime.now(),"Post with postId " + postId + " Deleted Successfully...!!", true, null), HttpStatus.OK);
	}
}
