package com.fintech.dto;

public class AccountResponse {

    private String accountNumber;
    private String accountType;
    private String provider;

    // No-args constructor
    public AccountResponse() {}

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getProvider() {
        return provider;
    }


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public AccountResponse(String accountNumber, String accountType, String provider) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.provider = provider;
	}

    
}

