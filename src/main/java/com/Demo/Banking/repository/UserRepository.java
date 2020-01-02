package com.Demo.Banking.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.Banking.model.Bank;
import com.Demo.Banking.model.User;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

	User findByFirstNameIgnoreCaseContaining(String firstName);


	
	

}
