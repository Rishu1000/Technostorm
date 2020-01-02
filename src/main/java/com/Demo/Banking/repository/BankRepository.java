package com.Demo.Banking.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.Banking.model.Bank;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>, BankRepositoryCustom {

	

	


	
	

}
