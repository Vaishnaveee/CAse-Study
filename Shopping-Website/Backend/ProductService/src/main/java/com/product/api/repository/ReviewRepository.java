package com.product.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.api.model.Review;


public interface ReviewRepository extends JpaRepository<Review, Long>{
	@Query("select COUNT(r.id) from Review r where r.product.id=?1")
	Long getReviewCount(Long pid);

	List<Review> findByProductId(Long pid);

}