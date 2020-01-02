package com.Demo.Banking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Bank")
@EntityListeners(AuditingEntityListener.class)
public class Bank {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@NotBlank
	private String accountType;
	
	
	private Double Balance;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "bank")
	private User user;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Bank [accountId=" + accountId + ", accountType=" + accountType + ", Balance=" + Balance + ", user="
				+ user + "]";
	}
	
	
	

}
