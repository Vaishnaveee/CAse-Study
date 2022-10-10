//package com.wallet.api.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class WalletStatement {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	@OneToOne
//	private Wallet wallet;
//	@OneToOne
//	private Statement statement;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Wallet getWallet() {
//		return wallet;
//	}
//	public void setWallet(Wallet wallet) {
//		this.wallet = wallet;
//	}
//	public Statement getStatement() {
//		return statement;
//	}
//	public void setStatement(Statement statement) {
//		this.statement = statement;
//	}
//	
//	
//}
