package com.order.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.api.model.Address;
import com.order.api.model.Orders;
import com.order.api.repository.AddressRepository;
import com.order.api.repository.OrderRepository;

@SpringBootTest(classes= {OrderControllerTest.class})
public class OrderControllerTest {
	
//	@Mock
//	OrderRepository orderRepository; 
//	
//	@InjectMocks
//	OrderController orderController;
//	
//	@Mock
//	AddressRepository addressRepository;
//	
//	
//	@Test	//test case for get all wallets
//	public void getAllOrdersTest1() {
//		List<Orders> orderList1 = new ArrayList<>();
//		
//		orderList1.add(new Orders((long)1, LocalDate.now(),500.25,"COD","DONE",5)) ;
//		orderList1.add(new Orders((long)2, LocalDate.now(),501.25,"COD","DONE",5)) ;
//		orderList1.add(new Orders((long)3, LocalDate.now(),502.25,"COD","DONE",5)) ;
//		
//		when(orderRepository.findAll()).thenReturn(orderList1);
//		
//		assertEquals(orderList1, orderController.getAllOrders());
//	}
//	
//	@Test	//test case for null orders
//	public void getAllOrderTest2() {
//		List<Orders> orderList = new ArrayList<>();
//		
//		when(orderRepository.findAll()).thenReturn(orderList);
//		assertEquals(orderList, orderController.getAllOrders());
//	}
//	
//	
//	@Test	//test case for delete wallet
//	public void deleteOrderTest1() {
//
//		long order = (long)1;
//		orderController.removeOrder(order);
//		verify(orderRepository , times(1)).deleteById(order);
//	
//	}
//	
//	@Test  //Test Case for Placing order
//	public void postOrderTest() {
//		
//		Orders orders = (new Orders((long)1, LocalDate.now(),500.25,"COD","DONE",5)) ;
//		when(orderRepository.save(orders)).thenReturn(orders);
//		assertEquals(orders, orderController.placeOrder(orders));
//	}
//	
//	@Test //Test Case to update the order status 
//	public void putOrderTest() {
//		
//		Orders orders = (new Orders((long)1, LocalDate.now(),500.25,"COD","DONE",5)) ;
//		when(orderRepository.getById((long)1)).thenReturn(orders);
//		
//		String newStatus="Intransit";
//		
//		Orders order1 = new Orders((long)1, null,0.0,null,newStatus,0);
//		when(orderController.changeOrderStatus((long)1, order1)).thenReturn(orders);
//		
//		assertEquals(newStatus, orders.getOrderStatus());
//		
//	}
//	
//	@Test   //Test case to check all the Order info and also for order getter and setters
//	public void getOrderInfoTest() {
//		
//		Orders orders = (new Orders((long)1, LocalDate.now(),500.25,"COD","DONE",5)) ;
//		
//		when(orderRepository.getById((long)1)).thenReturn(orders);
//		
//		LocalDate ld = LocalDate.of(2022, 9, 6) ; double amount = 500.25 ; String modeOfPayment = "COD";
//		String orderStatus = "Delievered" ; int quantity = 2;
//		
//		Orders order1 = new Orders((long)1 , ld , amount , modeOfPayment , orderStatus , quantity);
//		
//				
//		assertThat(order1.getOrderDate()).isEqualTo(ld);
//		assertThat(order1.getAmmountPaid()).isEqualTo(amount);
//		assertThat(order1.getModeOfPayment()).isEqualTo(modeOfPayment);
//		assertThat(order1.getOrderStatus()).isEqualTo(orderStatus);
//		assertThat(order1.getQuantity()).isEqualTo(quantity);
//	
//		
//	}
//	
//	@Test  //test case to fetch all the address
//	public void getAllAddressTest() {
//		
//		List<Address> addressList = new ArrayList<>();
//		
//		addressList.add(new Address((long) 1, "harry", "94954515454",22, "Pune",413102,
//				"Maharashtra"));
//		
//		addressList.add(new Address((long)2,"ron","56565656",23,"Mumbai",412102,"Delhi"));
//		
//		addressList.add(new Address((long)3,"Draco","121515",24,"Delhi",41515,"Gujarat"));
//		
//		when(addressRepository.findAll()).thenReturn(addressList);
//		assertEquals(addressList, orderController.getAllAddress());
//	
//	}
//	
//	@Test   //test case to store a new address
//	public void storeAddressTest() {
//		
//		Address address = (new Address((long) 1, "harry", "94954515454",22, "Pune",413102,
//				"Maharashtra")) ;
//		when(addressRepository.save(address)).thenReturn(address);
//		assertEquals(address, orderController.storeAddress(address));
//	}
	
	
}
