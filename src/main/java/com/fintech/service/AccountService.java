package com.fintech.service;

import java.util.List;

import com.fintech.dto.AccountResponse;
import com.fintech.dto.LinkAccountRequest;

public interface AccountService {
	
	
	public void link(String email,LinkAccountRequest link);
	
	public List<AccountResponse> getAccounts(String userEmail);

}
