package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;
import java.util.ArrayList;

//import java.util.ArrayList;

public class PPAccount implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234567890;
	private static final float amount = 0;
	/**
	 * 
	 */
	
	@SuppressWarnings("unused")
	private Profile profile;
	private String email;
	private float accountBal;
	private boolean isActivated;
	private String activationCode;
	
	private ArrayList<Transaction> transactions;
	
	//ArrayList<Transaction> t ;
	//t.addTransaction(t);
	
	
	public PPAccount(Profile profile) {
		// TODO Auto-generated constructor stub
		this.profile=profile;
		transactions = new ArrayList<Transaction>();
		
	}
	public void setAccountbal(float accountbal)
	{
		this.accountBal=accountbal;
	}
	
	public float getAccountbal()
	{
		return accountBal;
	}

	public String toString()
	{
		// implement this function to return a beautiful looking string
		// to display the summary of the account
		return "\nProfile = " +profile + "\nEmail = " +email+ "\nAccount balance = " +accountBal+ "\nActivation = " +isActivated +"\nActivationCode = "+activationCode +"\nTransactions = "+transactions;
	}

	public void activate(String activationCode) 
	{
		
		// TODO Auto-generated method stub
		this.activationCode=activationCode;
	}
	public float getaccountBal()
	{
		return accountBal;
	}

	public boolean withdraw(float withdrawAmount) {
		if(accountBal>withdrawAmount)
		{
			accountBal=accountBal-withdrawAmount;
			System.out.println("Remaining Balance:"+accountBal);
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean addFunds(float creditAmount) 
	{
		if(accountBal!=0)
		{
			accountBal=accountBal+creditAmount;
			System.out.println("added funds :"+accountBal);
			return true;
		}
		
		return false;
	}
	
	public boolean sendMoney(float creditAmount) 
	{
		
		if(accountBal!=0)
		{
			accountBal=accountBal-creditAmount;
			System.out.println("added funds :"+accountBal);
			return true;
		}
		
		return false;
	}
	
	
	public boolean requestMoney(float creditAmount) 
	{
		if(accountBal!=0)
		{
			accountBal=accountBal+creditAmount;
			System.out.println("added funds :"+accountBal);
			return true;
		}
		
		return false;
	
	}

	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public void setActivated(boolean isActivated)
	{
		this.isActivated=isActivated;
	}
	
	public boolean isActivated()
	{
		return isActivated;
	}
	
	public void suspend()
	{
		setActivated(false);
	}
	public void setActivation(String activationCode)
	{
		this.activationCode=activationCode;
	}
	
	public String getActivation()
	{
		return activationCode;
	}
	public Profile getProfile() {
		// TODO Auto-generated method stub
		return profile;
	}
	
	public void setTransactions(Transaction ta) 
	{
		// TODO Auto-generated method stub
		this.transactions.add(ta);
	
	}
	public ArrayList<Transaction> getTransactions()
	{
		return transactions;
	}
}
