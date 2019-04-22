package in.msitprogram.jntu.paypal.console;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.accounts.PPBusinessAccount;
import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;
import in.msitprogram.jntu.paypal.accounts.Profile;
import in.msitprogram.jntu.paypal.accounts.Transaction;
import in.msitprogram.jntu.paypal.persistance.DataStore;
import in.msitprogram.jntu.paypal.utils.PPToolkit;

public class PPNewAccountScreen implements Serializable
{
	Profile profile;
	PPAccount account;
	String email;
	Scanner scan;
	
	
	public PPNewAccountScreen(String email) 
	{
		profile = new Profile();
		scan = new Scanner(System.in);
		this.email = email;
		try
		{
			show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void show() throws IOException, ClassNotFoundException 
	{
		
		/*if(account==null)
		{
			System.out.println("account already exists");
			MainMenu.show();
		}
		else
		{*/
			Profile profile=createProfile();
			
			System.out.println("Create new account");
			//System.out.println("----Account types----");
			System.out.println("1.Business Account 2.Student Account 3.Personal Account");
			System.out.println("Enter your option:");
			int opt=scan.nextInt();
			switch(opt)
			{
			case 1:
				System.out.println("Business Account");
				createBusinessAccount(email);
				break;
			case 2:
				System.out.println("Student Account");
				createStudentAccount();
				break;
			case 3:
				System.out.println("Personal Account");
				createPersonalAccount();
				break;
			}
		}
			
			
			
			
			
		//check if the account with the given email address exists 
		
		//if not create the user profile
		
		//show the account types
		
		//based on the given account type selected create the account object
	

	private Profile createProfile() 
	{
		//Profile cp=new Profile();
		// use this for creating the profile
		System.out.println("Enter Name ");
		String name=scan.next();
		profile.setName(name);
		System.out.println("Enter Address ");
		String address=scan.next();
		profile.setAddress(address);
		System.out.println("Enter Phone number");
		String phone=scan.next();		
		profile.setPhone(phone);
		 return profile;
	}

	private void createBusinessAccount(String businessAccount) throws IOException 
	{
		
		//use this for creating the business account
	}

	private void createStudentAccount() throws IOException, ClassNotFoundException 
	{
		/*Sysstem.out.println("Enter Parents email id");
		String pid=scan.next();
		account=DataStore.lookupAccount(pid);
		if(DataStore.lookupAccount(email)!=null)
		{
			System.out.println("Enter student limit:");
			String sl=scan.next();
			System.out.println("Enter withdraw amount");
			float wd=scan.nextFloat();
			//float creditAmount = 0;
			account.addFunds(wd);
			float withdrawAmount = 0;
			account.withdraw(withdrawAmount);
		}
		else
		{
			System.out.println("Student account does not exist");
			MainMenu.show();
		
		}
		int i=0;
		if(i<3)
		{
			System.out.println("enter parents pid");
			account.setActivated(false);
			completeAccountCreation();
			
		}
		else
		{
			if(i==3)
			{
				System.out.print("it is not parents mail id");
				MainMenu.show();
			}
			
			
			
			
			
			
			
			
		}*/
		
		//use this for creating the student account 
		
	}

	/*
	 * this method create the personal account, saves it to the file system
	 * and redirects the users to the next screen
	 */
	private void createPersonalAccount() throws IOException, ClassNotFoundException 
	{
		//use this for creating the personal account
		
		account=new PPAccount(profile);
		account.setEmail(email);
		System.out.println("Deposit  money to open  Personal Account");
		float accountbal=scan.nextFloat();
		account.setAccountbal(accountbal);
		account.setActivated(false);
		completeAccountCreation();
	}
	
	private void completeAccountCreation() throws IOException, ClassNotFoundException{
		//generate activation code and set it to account
	
		String activationCode=PPToolkit.generateActivationCode();
	    System.out.println("Activation code for account is: "+activationCode);
		account.setActivation(activationCode);
		DataStore.writeAccount(account);
		
	    PPAccountActivationScreen.show();
				
		
		
		//send activation code to the phone
		
		//ask & redirect the user to the activation screen or the main menu
		
	}

}
