package com.scb.bank.management.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.bank.management.entity.AccountEntity;

/*
 * 
 */

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	
}
