package com.tata.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tata.entity.Post;
import com.tata.exception.ResourceNotFoundException;
import com.tata.payloads.PostDto;
import com.tata.repo.PostRepository;
import com.tata.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto savePost(PostDto postDto) {

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setCreatedAt(LocalDateTime.now());
		post.setUpdatedAt(LocalDateTime.now());

		Post savedPost = this.postRepository.save(post);
		return this.modelMapper.map(savedPost, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts() {

		List<Post> posts = this.postRepository.findAll();
		return posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

//    @Override
//    public PostDto getPostById(Integer postId) {
//
//        Post post = this.postRepository.findById(postId).orElse(null);
//        return this.modelMapper.map(post, PostDto.class);
//    }

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {

		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setPostImage(postDto.getPostImage());
//        post.setPostVedio(postDto.getPostVedio());
		post.setUpdatedAt(LocalDateTime.now());

		Post updatedPost = this.postRepository.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);

	}

	@Override
	public void deletePost(Integer postId) {

		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
		postRepository.delete(post);

	}
}
