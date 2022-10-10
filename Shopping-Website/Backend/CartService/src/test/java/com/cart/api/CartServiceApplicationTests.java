package com.cart.api;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cart.api.controller.CartController;
import com.cart.api.model.Cart;
import com.cart.api.repository.CartRepository;

@SpringBootTest(classes= {CartServiceApplicationTests.class})
class CartServiceApplicationTests {
	
   @Mock
   private CartRepository cartRepository;
 
   @InjectMocks
  private CartController cartController;
   public List<Cart> cartList;

   //checking the all records in cart
/*	@Test
	public void getCartTest() {
		when(cartRepository.findAll()).thenReturn(Stream.of(new Cart(1,1, "abc", 2000, 2 ),new Cart(2,2, "bnm", 3000, 1))
				.collect(Collectors.toList()));
		
		assertEquals(2, cartController.getCart().size());
		
	}
	
	@Test//checking  when there is no product in cart
	public void getCartTest2() {
		List<Cart> cartList1=new ArrayList<>();
		
		when(cartRepository.findAll()).thenReturn(cartList1);
		
		assertEquals(cartList1, cartController.getCart());
	}
	
	//checking the test case for add records in cart
	@Test
	public void postCartTest() {
		Cart cart=new Cart(1,1, "abc", 2000, 2);
		when(cartRepository.save(cart)).thenReturn(cart);
		assertEquals(cart, cartController.postCart(cart));
	}
	
	@Test//test case for updating price
	public void putWalletTest1() {
		Cart cart=new Cart(1,1, "abc", 2000, 2 );
		
		when(cartRepository.getById((long)1)).thenReturn(cart);

		double newBalance=10;
		Cart cart1=new Cart((long)1,(long)1, "abc",newBalance, 2);
		
		when(cartController.updateCart((long)1, cart1)).thenReturn(cart);
		
		assertThat(cart.getPrice()).isEqualTo(newBalance);
	}
	
	//checking for delete the product from cart using cartId
	@Test
	public void deleteCartTest()
	{
		
		Long cartId=(long) 1;
		cartController.deleteCart(cartId);
		verify(cartRepository, times(1)).deleteById(cartId);
	}
	
	
	*/
	
}
