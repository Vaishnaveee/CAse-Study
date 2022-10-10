package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
