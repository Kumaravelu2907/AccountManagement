package com.scb.bank.management.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.bank.management.dao.AccountRepository;
import com.scb.bank.management.entity.AccountEntity;
import com.scb.bank.management.exception.AccountException;
import com.scb.bank.management.model.AccountInfo;
import com.scb.bank.management.service.AccountService;


/*
 * @author boopathi.r
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	
	@Autowired
	private AccountRepository accountDao;

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public void createAccount(AccountInfo accountInfo) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(accountInfo.getId());
		accountEntity.setFullName(accountInfo.getFullName());
		accountEntity.setBalance(accountInfo.getBalance());
		accountDao.save(accountEntity);

	}

	@Override
	public List<AccountEntity> getAllAccountList() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

	@Override
	public void sendMoney(int fromAccountId, int toAccountId, double amount) throws AccountException {
		// TODO Auto-generated method stub
		    addAmount(toAccountId, amount);
	        addAmount(fromAccountId, -amount);
		
	}
	
	@Override
	public void deleteAccount(int accountId) throws AccountException {
		// TODO Auto-generated method stub
		if(accountDao.existsById(accountId)) {
			accountDao.deleteById(accountId);	
		}
		else {
			 throw new AccountException("Account not found " + accountId);	
		}
		
	}

	private void addAmount(int id, double amount) throws AccountException {
		// TODO Auto-generated method stub
           AccountEntity account = this.getAccountById(id);
	        if (account == null) {
	            throw new AccountException("Account not found " + id);
	        }
	        double newBalance = account.getBalance() + amount;
	        if (account.getBalance() + amount < 0) {
	            throw new AccountException(
	                    "The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
	        }
	        account.setBalance(newBalance);
	}
	
	private AccountEntity getAccountById(int id) {
		return entityManager.find(AccountEntity.class,id);
	}

	@Override
	public void depositMoney(int fromAccountId, double amount) throws AccountException {
		// TODO Auto-generated method stub
		
		AccountEntity accountEntity =
				entityManager.find(AccountEntity.class,fromAccountId);
		 if (accountEntity == null) {
	            throw new AccountException("Account not found " + fromAccountId);
	        }
		accountEntity.setBalance(amount);
		accountDao.save(accountEntity);
		}

}
