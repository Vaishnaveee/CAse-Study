package com.wallet.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.WalletRepository;

@SpringBootTest(classes= {WalletControllerTest.class})
public class WalletControllerTest {

	@Mock
	WalletRepository walletRepository;
	
	public List<Wallet> walletList;

	@InjectMocks
	WalletController walletController;
	
	@Test//test case for get all wallets
	public void aTest1() {
		List<Wallet> walletList1=new ArrayList<>();
		
		walletList1.add(new Wallet((long)1, (long)1, 0, 0)) ;
		walletList1.add(new Wallet((long)2, (long)3, 0, 0)) ;
		walletList1.add(new Wallet((long)3, (long)5, 0, 0)) ;
		
		when(walletRepository.findAll()).thenReturn(walletList1);
		
		assertEquals(walletList1, walletController.getWallet());
	}
	
	@Test//test case for get all wallets when there is no record in DB 
	public void aTest2() {
		List<Wallet> walletList1=new ArrayList<>();
		
		when(walletRepository.findAll()).thenReturn(walletList1);
		
		assertEquals(walletList1, walletController.getWallet());
	}


	@Test//test case for get all wallets
	public void getWalletsTest1() {
		List<Wallet> walletList1=new ArrayList<>();
		
		walletList1.add(new Wallet((long)1, (long)1, 0, 0)) ;
		walletList1.add(new Wallet((long)2, (long)3, 0, 0)) ;
		walletList1.add(new Wallet((long)3, (long)5, 0, 0)) ;
		
		when(walletRepository.findAll()).thenReturn(walletList1);
		
		assertEquals(walletList1, walletController.getWallet());
	}
	
	@Test//test case for get all wallets when there is no record in DB 
	public void getWalletsTest2() {
		List<Wallet> walletList1=new ArrayList<>();
		
		when(walletRepository.findAll()).thenReturn(walletList1);
		
		assertEquals(walletList1, walletController.getWallet());
	}
	
	@Test//test case for post(saving) wallet
	public void postWalletTest1() {
		Wallet wallet=new Wallet((long)3, (long)5, 0, 0);
		
		when(walletRepository.save(wallet)).thenReturn(wallet);
		
		assertEquals(wallet, walletController.postWallet(wallet));
	}
	
	@Test//test case for updating balance
	public void putWalletTest1() {
		Wallet wallet=new Wallet((long)1, (long)5, 0, 0);
		
		when(walletRepository.getById((long)1)).thenReturn(wallet);

		int newBalance=10;
		Wallet wallet1=new Wallet((long)0, (long)0, newBalance, 0);
		
		when(walletController.putWallet((long)1, wallet1)).thenReturn(wallet);
		
		assertThat(wallet.getBalance()).isEqualTo(newBalance);
	}
	
	@Test//test case for delete wallet
	public void deleteWalletTest1() {
		Wallet wallet=new Wallet((long)1, (long)5, 0, 0);

		when(walletRepository.getById((long)1)).thenReturn(wallet);
		
		walletController.deleteWallet((long)1);
		
		verify(walletRepository , times(1)).deleteById((long)1);
	
	}
	

}
