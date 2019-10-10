package com.scb.bank.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scb.bank.management.entity.AccountEntity;
import com.scb.bank.management.exception.AccountException;
import com.scb.bank.management.model.AccountInfo;

@Service
public interface AccountService {
	
	/*
	 * getAllAccountList method is used to get all accountlist
	 */
     void createAccount(AccountInfo accountInfo);
	
	/*
	 * getAllAccountList method is used to get all accountlist
	 */
     List<AccountEntity> getAllAccountList();
     
	/*
	 * sendMoney method is used to transfer fund from one account to another account;
	 */
	void sendMoney(int fromAccountId, int toAccountId, double amount) throws AccountException;
	
	/*
	 * depositMoney method is used to deposit amount 
	 */
	
	void depositMoney(int fromAccountId,double amount) throws AccountException;
	
	/*
	 * depositMoney method is used to deposit amount 
	 */
	
	void deleteAccount(int accountId) throws AccountException;

}
