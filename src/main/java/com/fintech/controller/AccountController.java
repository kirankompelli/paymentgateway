package com.fintech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.dto.AccountResponse;
import com.fintech.dto.LinkAccountRequest;
import com.fintech.service.AccountService;

@RestController
@RequestMapping("/account/api")
public class AccountController {
	
	
	@Autowired
	private AccountService service;
	
	
	@PostMapping("/link")
	public ResponseEntity<String> link(@RequestParam LinkAccountRequest request,@AuthenticationPrincipal UserDetails userDetails){
		                    
		                service.link(userDetails.getUsername(),request);		    
		                   
		return ResponseEntity.ok("Account linked successfully");
	}

	 @GetMapping("/my")
	    public ResponseEntity<List<AccountResponse>> getMyAccounts(@AuthenticationPrincipal UserDetails userDetails) {
	        return ResponseEntity.ok(service.getAccounts(userDetails.getUsername()));
	    }
}
