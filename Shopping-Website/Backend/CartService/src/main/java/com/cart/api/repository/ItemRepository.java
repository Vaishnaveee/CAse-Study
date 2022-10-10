package com.cart.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cart.api.model.Cart;
import com.cart.api.model.Items;

public interface ItemRepository extends JpaRepository<Items, Long> {

	List<Items> findAllByCart(Cart cart1);
//@Query("select i from Items i where i.cart.id=?1")
//	List<Items> getByCart(Long id);
	@Query("select i from Items i where i.cart.id=?1")
	List<Items> getItemsByCart(Long cId);
//	@Query("select i from Items i where i.cart.id=?1 & i.productId=?2")
//	Items getBycId(Long cId, Long pId);
	@Query("select i.productId from Items i where i.cart.id=?1")
	List<Long> getproductId(Long cId);
	@Query("select i from Items i where i.cart.id=?1 and i.productId=?2")
	Items getBycId(Long cId, Long pId);
	
}
