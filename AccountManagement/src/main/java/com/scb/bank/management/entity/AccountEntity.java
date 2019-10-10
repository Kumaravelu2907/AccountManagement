package com.scb.bank.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
 */
@Entity
@Table(name ="SCB_BANK")
public class AccountEntity {
	    @Id
	    @Column(name = "ID")
	    private int id;
	 
	    @Column(name = "FULL_NAME")
	    private String fullName;
	 
	    @Column(name = "BALANCE")
	    private double balance;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

}
