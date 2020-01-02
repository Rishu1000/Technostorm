package com.Demo.Banking.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.Demo.Banking.model.Bank;

public interface BankRepositoryCustom {
	
	

	Bank findByFirstName(String firstName);

    Bank findByLastName(String lastName);

	Bank findByDate(Date date);

}
