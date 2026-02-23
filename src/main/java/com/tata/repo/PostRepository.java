package com.tata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tata.entity.Category;
import com.tata.entity.Post;
import com.tata.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findPostByUserOrderByCreatedAtDesc(User user);

	List<Post> findPostByCategoryOrderByCreatedAtDesc(Category category);

	@Query("select p from Post p where p.title like :key order by p.createdAt desc")
	List<Post> findPostByKeyword(@Param("key") String keyword);

}





//package com.tata.repo;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.tata.entity.Category;
//import com.tata.entity.Post;
//import com.tata.entity.User;
//
//public interface PostRepository extends JpaRepository<Post, Integer> {
//	
//	List<Post> findPostByUser(User user);
//	
//	List<Post> findPostByCategory(Category category);
//
//	@Query("select p from Post p where p.title like :key")
//	List<Post> findPostByKeyword(@Param("key") String keyword);
//
//}




