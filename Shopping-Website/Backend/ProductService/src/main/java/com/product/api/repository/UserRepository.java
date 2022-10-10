package com.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
