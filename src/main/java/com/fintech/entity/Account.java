package com.fintech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="accounts",uniqueConstraints = @UniqueConstraint(columnNames= {"accountNumber","user_id"}))
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String accountNumber;
	
	private String accountType;
	
	private String provider;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	 private Account(Builder builder) {
	        this.id = builder.id;
	        this.accountNumber = builder.accountNumber;
	        this.accountType = builder.accountType;
	        this.provider = builder.provider;
	        this.user = builder.user;
	    }

	    // Getters
	    public Long getId() {
	        return id;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public String getAccountType() {
	        return accountType;
	    }

	    public String getProvider() {
	        return provider;
	    }

	    public User getUser() {
	        return user;
	    }

	    // Builder class
	    public static class Builder {
	        private Long id;
	        private String accountNumber;
	        private String accountType;
	        private String provider;
	        private User user;

	        public Builder id(Long id) {
	            this.id = id;
	            return this;
	        }

	        public Builder accountNumber(String accountNumber) {
	            this.accountNumber = accountNumber;
	            return this;
	        }

	        public Builder accountType(String accountType) {
	            this.accountType = accountType;
	            return this;
	        }

	        public Builder provider(String provider) {
	            this.provider = provider;
	            return this;
	        }

	        public Builder user(User user) {
	            this.user = user;
	            return this;
	        }

	        public Account build() {
	            return new Account(this);
	        }
	    }
	
	
	
	

}
