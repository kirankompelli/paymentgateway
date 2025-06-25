package com.fintech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintech.entity.Account;
import com.fintech.entity.User;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Long>{

	   List<Account> findByUser(User user);
	   
	   boolean existsByAccountNumberAndUser(String accountnumber,User user);
	
}
