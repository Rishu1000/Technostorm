package com.Demo.Banking.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.Demo.Banking.model.Bank;
import com.Demo.Banking.model.User;

public interface BankRepositoryCustom {
	
	

	
	
	Bank findByFirstName(String firstName);

    Bank findByLastName(String lastName);

	Bank findByDate(Date date);

}
