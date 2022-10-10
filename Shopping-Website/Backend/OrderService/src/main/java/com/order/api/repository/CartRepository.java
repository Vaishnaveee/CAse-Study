package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
