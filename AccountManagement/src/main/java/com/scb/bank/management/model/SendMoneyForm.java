package com.scb.bank.management.model;

/*
 * 
 */
public class SendMoneyForm {
	    private int fromAccountId;
	    private int toAccountId;
	    private Double amount;
	    public SendMoneyForm() {
	    	
	    }
	    public SendMoneyForm(int fromAccountId, int toAccountId, Double amount) {
	        this.fromAccountId = fromAccountId;
	        this.toAccountId = toAccountId;
	        this.amount = amount;
	    }
		public int getFromAccountId() {
			return fromAccountId;
		}
		public void setFromAccountId(int fromAccountId) {
			this.fromAccountId = fromAccountId;
		}
		public int getToAccountId() {
			return toAccountId;
		}
		public void setToAccountId(int toAccountId) {
			this.toAccountId = toAccountId;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
	    

}
