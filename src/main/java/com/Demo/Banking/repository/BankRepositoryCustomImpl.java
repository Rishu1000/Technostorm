package com.Demo.Banking.repository;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.Demo.Banking.model.Bank;
import com.Demo.Banking.model.User;

public class BankRepositoryCustomImpl implements BankRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	
	@Override
	public Bank findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(
				"SELECT em.* FROM spring_data_jpa_example.employee as em " + "WHERE em.firstname LIKE ?", User.class);
		query.setParameter(1, firstName + "%");
		return (Bank) query.getResultList();

	}

	@Override
	public Bank findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank findByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
