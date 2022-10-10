package com.wallet.api.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.razorpay.*;
import com.wallet.api.model.Statement;
import com.wallet.api.model.User;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.StatementRepository;
import com.wallet.api.repository.WalletRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wallet")
@CrossOrigin(origins = { "http://localhost:4200/" })
public class WalletController {

	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	private StatementRepository statementRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${razorpay.secreat.id}")
	private String secretID;
	
	@Value("${razorpay.secreat.key}")
	private String secretKey;


	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@ApiOperation(value="fetch all the wallets",
			response=Wallet.class)
	@GetMapping("/allWallets")// get the list of all wallets
	public List<Wallet> getWallet() {
		return walletRepository.findAll();
	}
	
	@GetMapping("/getBalance/{uid}")
	public Long getbalance(@PathVariable("uid") Long uId) {
		Wallet wallet=walletRepository.getByUserId(uId);
		return (long)wallet.getBalance();
	}
	
	@GetMapping("/a")
	public List<Wallet> a() {
		return walletRepository.findAll();
	}
	
	@GetMapping("/{uid}")
	public Long getWalletIdByUserId(@PathVariable("uid") Long uId) {
		Wallet wallet=walletRepository.getByUserId(uId);
		return wallet.getId();
	}
	
		
	@ApiOperation(value="Post the wallet",
			
			response=Wallet.class)
	@PostMapping("/saveWallet")// post the wallet
	public Wallet postWallet(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	@ApiOperation(value="update wallet by wallet id",
			notes = "provide an id of the wallet and update it",
			response=Wallet.class)
	@PutMapping("/editWallet/{wId}")// edit the existent wallet
	public Wallet putWallet(@PathVariable("wId") Long wId, @RequestBody Wallet wallet) {
		Wallet wallet1=walletRepository.getById(wId);
		
		//balance is updated here
		if(wallet.getBalance()!=0) wallet1.setBalance(wallet.getBalance());

		return walletRepository.save(wallet1);
	}
	
	@ApiOperation(value="Delete wallet by wallet id",
			notes = "provide an id of the wallet and delete it",
			response=Wallet.class)
	@DeleteMapping("/deleteWallet/{wId}")// delete the existent wallet
	public List<Wallet> deleteWallet(@PathVariable("wId") Long wId){
		Wallet wallet1=walletRepository.getById(wId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(wId);
		return walletRepository.findAll();
	}
	
	@ApiOperation(value="Fetch wallet by userId",
			notes = "provide an id of the User and Fetch the wallet",
			response=Wallet.class)
	@GetMapping("/userid/{uId}")// get wallet by userId
	public Wallet getWalletByUserId(@PathVariable("uId") Long uId) {
		RestTemplate restTemplate=new RestTemplate();
		
		// calling profile service to check if user is present
		User user=restTemplate.getForObject("http://localhost:1000/user/"+uId, User.class);
		System.out.println(user.getUsername());
		if(user.getUserId()!=0) return walletRepository.getByUserId(uId);
		return new Wallet();
	}
	
	@ApiOperation(value="Post wallet by userId",
			notes = "provide an id of the User and Post the wallet",
			response=Wallet.class)
	@GetMapping("/saveWallet/{uId}")// post the wallet
	public Wallet postWallet(@PathVariable("uId") Long uId) {
		
		
		Wallet wallet=new Wallet();
		wallet.setUserId(uId);
		return walletRepository.save(wallet);

	}
	
	@ApiOperation(value="Delete wallet by userId",
			notes = "provide an id of the User and Delete the wallet",
			response=Wallet.class)
	@DeleteMapping("/deleteWallet/{uId}")// delete the existent wallet
	public List<Wallet> deleteWalletByUserId(@PathVariable("uId") Long uId){
		Wallet wallet1=walletRepository.getByUserId(uId);
		if(wallet1.getId() !=0 ) walletRepository.deleteById(uId);
		return walletRepository.findAll();
	}
	
	@ApiOperation(value="Activate wallet",
			notes = "provide an id of wallet and activate the wallet",
			response=Wallet.class)
	@GetMapping("/activate/{wId}")// activate the existent wallet
	public void activateWallet(@PathVariable("wId") Long wId) {
		Wallet wallet1=walletRepository.getById(wId);
		
		if(wallet1.isActivate()==0) wallet1.setActivate(1);

		walletRepository.save(wallet1);
	}
	
	@GetMapping("/deactivate/{wId}")// activate the existent wallet
	public void deactivateWallet(@PathVariable("wId") Long wId) {
		Wallet wallet1=walletRepository.getById(wId);
		
		if(wallet1.isActivate()==1) wallet1.setActivate(0);

		walletRepository.save(wallet1);
	}
	
	
	
	@GetMapping("/getStatementByWallet/{wId}")
	public List<Statement> getStatementByWalletId(@PathVariable("wId") Long wId) {
		Wallet wallet1=walletRepository.getById(wId);

		return statementRepository.findAllByWallet(wallet1);
	}
	
	//****************************************************************************************
	
	@ApiOperation(value="Fetch wallet balance by Price",
			notes = "provide an price and Fetch the wallet balance",
			response=Wallet.class)
	@GetMapping("/getWalletMoney/{wId}/{amount}")// subtracting wallet money from total
	public long getWalletMoney(@PathVariable("amount") Long amount, @PathVariable("wId") Long wId) {
		
		Wallet wallet=walletRepository.getById(wId);
		
		long temp1=amount/10;
		if(wallet.isActivate()==0 || wallet.getBalance()<temp1) return amount;
		
		// According to price of products wallet money is subtracting from total amount
		if(amount<500) return amount-temp1;
		if(amount<1500) return amount-(temp1+(temp1/2));
		if(amount<4000) return amount-(2*temp1);
		return amount-(3*temp1);
	}
	
	
	
	//payment gateway api
	@ApiOperation(value="Api for Payment",
			response=Wallet.class)
	@PostMapping("/pay/{wid}")
	@ResponseBody
	public String paymoneyyy(@RequestBody Map<String, Object> data, @PathVariable("wid") Long wid) throws Exception {
		System.out.println ("--------------------------------------------------------------------");

		int amt=Integer.parseInt(data.get("amount").toString ());


		// creating order object to pass it to razorpay api and get the orderId  
		RazorpayClient razorpayClient = new RazorpayClient(secretID, secretKey); 
		JSONObject options = new JSONObject(); 
		options.put("amount", amt*100); 
		options.put("currency", "INR"); 
		options.put("receipt", "txn_123456"); 
		Order order = razorpayClient.orders.create(options);
		System.out.println (order) ;
		
		
	
		Wallet wallet=walletRepository.getById(wid);
		
		Statement statement=new Statement();
		
		statement.setUserId(wallet.getUserId());
		statement.setOrderID("");
		statement.setPaid(amt);
		statement.setWallet(wallet);
		
		LocalDate ld=LocalDate.now();
		Date dt=new Date();
		dt=Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		statement.setsDate(dt);
		statement.setType("Withdraw");
		statementRepository.save(statement);
		
		
		return order.toString();
	}
	
	
	//payment gateway api
		@ApiOperation(value="Api for Payment",
				response=Wallet.class)
		@PostMapping("/pay/wallet/{wid}")
		@ResponseBody
		public String paymoneyinwallet(@RequestBody Map<String, Object> data, @PathVariable("wid") Long wid) throws Exception {
			System.out.println ("--------------------------------------------------------------------");

			int amt=Integer.parseInt(data.get("amount").toString ());


			// creating order object to pass it to razorpay api and get the orderId  
			RazorpayClient razorpayClient = new RazorpayClient(secretID, secretKey); 
			JSONObject options = new JSONObject(); 
			options.put("amount", amt*100); 
			options.put("currency", "INR"); 
			options.put("receipt", "txn_123456"); 
			Order order = razorpayClient.orders.create(options);
			System.out.println (order) ;
			
			
		
			Wallet wallet=walletRepository.getById(wid);
			
			wallet.setBalance(wallet.getBalance()+amt);
			walletRepository.save(wallet);			
			
			Statement statement=new Statement();
			
			statement.setUserId(wallet.getUserId());
			statement.setOrderID("");
			statement.setPaid(amt);
			statement.setWallet(wallet);
			
			LocalDate ld=LocalDate.now();
			Date dt=new Date();
			dt=Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			
			statement.setsDate(dt);
			statement.setType("Deposite");
			statementRepository.save(statement);
			
			
			return order.toString();
		}
}
