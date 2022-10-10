package com.wallet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wallet.api.model.Statement;
import com.wallet.api.model.Wallet;

public interface StatementRepository extends JpaRepository<Statement, Long>{

	List<Statement> findAllByWallet(Wallet wallet1);

	@Query("select s from Statement s where s.wallet.id=?1")
	List<Statement> getStatementByWallet(Long id);


}
