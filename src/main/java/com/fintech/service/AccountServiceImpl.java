package com.fintech.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.dto.AccountResponse;
import com.fintech.dto.LinkAccountRequest;
import com.fintech.entity.Account;
import com.fintech.entity.User;
import com.fintech.repository.AccountRepository;
import com.fintech.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService{

	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private AccountRepository repo;
	
	public void link(String userEmail, LinkAccountRequest request) {
		 User user=   userrepo.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("User not found"));
         if(repo.existsByAccountNumberAndUser(request.getAccountNumber(), user))  {
      	   throw new RuntimeException("account already linked");
         }
         Account account=new Account.Builder().accountNumber(request.getAccountNumber())
      		   .accountType(request.getAccountType())
      		   .provider(request.getProvider())
      		   .build();
       Account ac=  repo.save(account);
		
	}

	@Override
	public List<AccountResponse> getAccounts(String userEmail) {
		                  User user=  userrepo.findByEmail(userEmail).orElseThrow(()-> new RuntimeException("no accounts found"));
		               List<Account> account=    repo.findByUser(user);
		               return account.stream()
		            		   .map(accounts -> { AccountResponse res=new AccountResponse();
		            		                res.setAccountNumber(accounts.getAccountNumber());
		            		                res.setProvider(accounts.getProvider());
		            		                res.setAccountType(accounts.getAccountType());
		            		        
		            		   
		            		       return res; 
		            		     
		            		   }).collect(Collectors.toList());
	}

}
