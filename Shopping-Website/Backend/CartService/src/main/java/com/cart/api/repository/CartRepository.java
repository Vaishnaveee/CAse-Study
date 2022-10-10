package com.cart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.api.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart getByUserId(Long uId);

}
