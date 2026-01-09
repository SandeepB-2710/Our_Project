package com.tata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tata.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
