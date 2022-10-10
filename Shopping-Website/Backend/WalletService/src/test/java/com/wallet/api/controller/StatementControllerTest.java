package com.wallet.api.controller;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.wallet.api.model.Statement;
import com.wallet.api.model.Wallet;
import com.wallet.api.repository.StatementRepository;
import com.wallet.api.repository.WalletRepository;

@SpringBootTest(classes= {StatementControllerTest.class})
public class StatementControllerTest {

	@Mock
	StatementRepository statementRepository;
	
	public List<Statement> statementList;

	@InjectMocks
	StatementController statementController;
	
	
	
}
