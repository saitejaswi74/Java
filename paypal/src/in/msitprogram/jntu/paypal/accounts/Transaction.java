package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;

public class Transaction implements Serializable
{
   String tDate;
   PPAccount account;
   String narration;
   String reference;
   String status;
   float debit;
   float credit;		
   String tTime;
   
	public Transaction(String tDate, PPAccount account, String narration, String reference, String status, float debit,
			float credit, String tTime)
	{
		super();
		this.tDate = tDate;
		this.account = account;
		this.narration = narration;
		this.reference = reference;
		this.status = status;
		this.debit = debit;
		this.credit = credit;
		this.tTime = tTime;
	}
	public String gettTime() {
		return tTime;
	}

	public void settTime(String tTime) {
		this.tTime = tTime;
	}

	public String gettDate() {
		return tDate;
	}

	public void settDate(String tDate) {
		this.tDate = tDate;
	}

	public PPAccount getAccount() {
		return account;
	}

	public void setAccount(PPAccount account) {
		this.account = account;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	
	
	public String toString()
	{
		//return the description of the transaction 
		return "\tNarration = "+narration+"\tReference = "+reference+"\tStatus = "+status+"\tDebit = "+debit+
				"\tCredit = "+credit ;
	}
	public void addTransaction(PPAccount account2) {
		// TODO Auto-generated method stub
		this.addTransaction(account2);
	}
	
}
