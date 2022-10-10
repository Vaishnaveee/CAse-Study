package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Items;

public interface ItemRepository extends JpaRepository<Items, Long>{

}
