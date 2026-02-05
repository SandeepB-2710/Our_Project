package com.tata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tata.payloads.PostDto;

@Service
public interface PostService {

    PostDto savePost(PostDto postDto);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    PostDto getPostById(Integer postId);

    List<PostDto> getAllPosts();
}
