package com.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wallet.api.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	
}
