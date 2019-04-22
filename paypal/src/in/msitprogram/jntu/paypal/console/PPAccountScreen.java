package in.msitprogram.jntu.paypal.console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.accounts.Transaction;
import in.msitprogram.jntu.paypal.persistance.DataStore;
public class PPAccountScreen
{
	PPAccount account;
	Scanner scan;
	
	public PPAccountScreen(String email) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		scan = new Scanner(System.in);
		account = DataStore.lookupAccount(email);
		
	}
	public void show() throws IOException, ClassNotFoundException {
		
		//check if account is active
		//if active
		
		// print the account summary
		
		if(account.isActivated())
		{
			
			System.out.println(account);
			
			
		}
		else
		{
			PPAccountActivationScreen.show();
		}

		Profile profile=account.getProfile();
		
		
	 	System.out.println("Type of account transaction");
		System.out.println("\n1.withdrawFunds\n2.requestMoney\n3.sendMoney\n4.addFunds\n5.exit");
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("withdraw");
			withdrawFunds();
			break;
		case 2:
			System.out.println("request money");
			requestMoney();
			break;
		case 3:
			System.out.println("send money");
			sendMoney();
			break;
		case 4:
			System.out.println("add funds");
			addFunds();
			break;
		case 5:
			MainMenu.show();
			default :
				System.out.println("invalid type");
				break;
		}
		
			show();
			// print menu and accept menu options
			// for all the paypal account operations
			
			
	}

	private void withdrawFunds() throws IOException, ClassNotFoundException {
		// implement the withdraw funds user interface here
	
		System.out.println("The balance in the account is :"+""+account.getAccountbal());
		System.out.println("Enter the withdraw amount:");
		float amount=scan.nextFloat();
		boolean b=account.withdraw(amount);
		if(b==true)
		{
		    System.out.println("Successfully withdrawn funds");
		    
		    
		}
		else
		{
			System.out.println("Insufficient Funds");
		}
		
		String tDate = "29";
		String narration = "withdraw";
		String reference = "paypal";
		String status = "add";
		float debit = amount;
		float credit = 0;
	    String tTime = "12:00";
	    ArrayList<Transaction> ta=new ArrayList<Transaction>();
		Transaction ta1=new Transaction(tDate, account, narration,reference,status,debit,credit, tTime);
		account.setTransactions(ta1);
		DataStore.writeAccount(account);
		
	}
		//use the account object as needed for withdraw funds
		
		


	private void requestMoney() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 	implement the request money user interface here
		
        System.out.println("Enter the amount you want");
		float credit=scan.nextFloat();
		account.requestMoney(credit);
		System.out.println("Enter email from whom you want to request money");
		//use the account object as needed for request money funds
		String tDate = "29";
		String narration = "request";
		String reference = "paypal";
		String status = "add";
		float debit = 0;
		float credit1 = credit;
	    String tTime = "12:00";
	    ArrayList<Transaction> ta=new ArrayList<Transaction>();
		Transaction ta1=new Transaction(tDate, account, narration,reference,status,debit,credit1, tTime);
		account.setTransactions(ta1);
		DataStore.writeAccount(account);
	}

	private void sendMoney() throws FileNotFoundException, IOException, ClassNotFoundException {
		// implement the send money user interface here
	
		System.out.println("Enter the amount that is to be sent to the other account holder");
		float amount=scan.nextFloat();
		account.sendMoney(amount);
		//use the account object as needed for send money funds
		String tDate = "29";
		String narration = "sendmoney";
		String reference = "paypal";
		String status = "add";
		float debit = amount;
		float credit = 0;
	    String tTime = "12:00";
	    ArrayList<Transaction> ta=new ArrayList<Transaction>();
		Transaction ta1=new Transaction(tDate, account, narration,reference,status,debit,credit, tTime);
		account.setTransactions(ta1);
		DataStore.writeAccount(account);
	}

	private void addFunds() throws IOException, ClassNotFoundException {
		// implement the add funds user interface here
		
		System.out.println("Enter the amount that you would like to deposit in your account");
		float amount=scan.nextFloat();
		account.addFunds(amount);
		//use the account object as needed for add funds
		
		String tDate = "29";
		String narration = "addfunds";
		String reference = "paypal";
		String status = "add";
		float debit = 0;
		float credit = amount;
	    String tTime = "12:00";
	    ArrayList<Transaction> ta=new ArrayList<Transaction>();
		Transaction ta1=new Transaction(tDate, account, narration,reference,status,debit,credit, tTime);
		account.setTransactions(ta1);
		DataStore.writeAccount(account);
	}

}