package com.wallet.api.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.api.model.Statement;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.StatementRepository;
import com.wallet.api.repository.WalletRepository;

@RestController
@RequestMapping("/wallet/statement")
@CrossOrigin(origins = { "http://localhost:4200/" })
public class StatementController {

	@Autowired
	private StatementRepository statementRepository;
	
	@Autowired
	WalletRepository walletRepository;
	
	@GetMapping("/allStatements")// get all statements
	public List<Statement> getStatements() {
		return statementRepository.findAll();
	}
	
	@GetMapping("/getStatementById/{id}")// get statement by id
	public Statement getStatementById(@PathVariable("id") Long id) {
		return statementRepository.getById(id);
	}
	
	@PostMapping("/saveStatement/{wId}")// post the statement
	public Statement postWallet(@RequestBody Statement statement,@PathVariable("wId") Long wId) {
		Wallet wallet1=walletRepository.getById(wId);
		
		LocalDate ld=LocalDate.now();
		Date dt=new Date();
		dt=Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		statement.setUserId(wallet1.getUserId());
		statement.setOrderID("");
		statement.setsDate(dt);
		statement.setWallet(wallet1);
		
		return statementRepository.save(statement);
	}


	@DeleteMapping("/deleteStatement/{sId}")// delete the existent statement
	public List<Statement> deleteWallet(@PathVariable("sId") Long sId){
		Statement statement1=statementRepository.getById(sId);
		if(statement1.getId() !=0 ) statementRepository.deleteById(sId);
		return statementRepository.findAll();
	}
	
	
	@GetMapping("/get/{id}")// get statement by id
	public List<Statement> getStatement(@PathVariable("id") Long id) {
		Wallet wallet1=walletRepository.getById(id);
		List<Statement> sList=statementRepository.getStatementByWallet(wallet1.getId());
		return sList;
	}
	
}
