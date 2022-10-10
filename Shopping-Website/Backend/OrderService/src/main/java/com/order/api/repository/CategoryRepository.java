package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
