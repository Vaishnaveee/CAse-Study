package com.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

	Orders findByAddressId(Long cid);

	List<Orders> getReferenceByUserId(Long userId);

}
