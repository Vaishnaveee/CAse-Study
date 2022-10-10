package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.ProductDto;
import com.product.api.model.Category;
import com.product.api.model.Product;
import com.product.api.model.Review;
import com.product.api.repository.CategoryRepository;
import com.product.api.repository.ProductRepository;
import com.product.api.repository.ReviewRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ProductController {
  @Autowired
  private ProductRepository productRepository;
  
  @Autowired
 private ReviewRepository reviewRepository;
  
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/product")
	public Product postProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	@PostMapping("/product/{cid}")
	public Product postProduct(@PathVariable("cid") Long cid,
			@RequestBody Product product) {
		
		Category category=categoryRepository.getById(cid);
		product.setCategory(category);
				return productRepository.save(product);
		
		
	}
	@GetMapping("/product/cart/{pId}")
	public Product getProduct(@PathVariable("pId") Long pId) {
		return productRepository.getById(pId);
		
	}
	
	@GetMapping("/product/{cid}")
	public List<ProductDto> getAllProducts(@PathVariable("cid") Long cid) {
		List<ProductDto> listdto=new ArrayList<>();
		List<Product> list=productRepository.findByCategoryId(cid);
		for(Product p:list) {
			
			ProductDto dto=new ProductDto();
			dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setPrice(p.getPrice());
			dto.setShortDescription(p.getShortDescription());
			dto.setCategoryId(p.getCategory().getId());
			dto.setCategoryName(p.getCategory().getName());
			dto.setReviewCount(reviewRepository.getReviewCount(p.getId()));
			listdto.add(dto);
			
			
		}
		return listdto;
	}
	
	
	@GetMapping("/product/review/{pid}")
	public Long getReview(@PathVariable("pid") Long pid){
		
		return reviewRepository.getReviewCount(pid);
		
	}
	

	@GetMapping("/review/product/{pid}")
	public List<Review> getAllReviews(@PathVariable("pid") Long pid){
		
		return reviewRepository.findByProductId(pid);
		
	}
	
	@PostMapping("/review/{pid}")
	public Review PostReview(@PathVariable("pid") Long pid, @RequestBody Review review){
		Product product=productRepository.getById(pid);
		review.setProduct(product);
		return reviewRepository.save(review);
		
	}
	@DeleteMapping("/review/{rid}")	
	public void deleteReview(@PathVariable("rid") Long rid) {
		reviewRepository.deleteById(rid);

	}
	
	

}