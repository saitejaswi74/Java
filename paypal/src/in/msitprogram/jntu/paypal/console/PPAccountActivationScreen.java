package in.msitprogram.jntu.paypal.console;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
import in.msitprogram.jntu.paypal.persistance.DataStore;
//import in.msitprogram.jntu.paypal.utils.PPToolkit;

import java.io.IOException;
import java.util.Scanner;

public class PPAccountActivationScreen {
	static Scanner sc=new Scanner(System.in);
	public static void show() throws IOException, ClassNotFoundException {
		
		@SuppressWarnings("unused")
		String email = ""; //change to get console input
		System.out.println("Enter your email id here");
		String emailid=sc.next();
		
		/*
		 * TODO
		 * fetch the account object using email address
		 * check if the account is suspended
		 * if suspended then activate it
		 * if activation code invalid, retry for 2 more attempts
		 * on successful activation show main menu
		 * on failure show the error message and continue to main menu
		 */			
		PPAccount account;
		System.out.println("Account Activation");
		System.out.println("1. Activate ");
		System.out.println("2. Suspend ");
		System.out.println("Enter your choice here");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:account=DataStore.lookupAccount(emailid);
		       if(account==null)
		       {
		    	   System.out.println("Email doesn't exist.");
		    	   MainMenu.show();
		       }
		       else 
		       {
		    	   if(account!=null)
		    	   {
		    		   if(account.isActivated())
		    		   {
		    			   System.out.println("Your account activated succesfully");
		    			   DataStore.writeAccount(account);
		    			   MainMenu.show();
		    		   }
		    		   else
		    		   {
		    			   int i=0;
		    			   while(i<3)
		    			   {
		    				  System.out.println("Enter your activation code");
		    				  String otp=sc.next();
		    				  if(otp.equals(account.getActivation()))
		    				  {
		    					  System.out.println("Account verification done successfully");
		    					  account.setActivated(true);
		    					  DataStore.writeAccount(account);
		    					  MainMenu.show();
		    					  break;
		    				  }
		    				  else
		    				  {
		    					  System.out.println("Invalid option......Please try again ");
		    					  i++;
		    				  }
		    			   }
		    			   if(i==3)
		    			   {
		    				   System.out.println("Verification failed.......");
		    				   MainMenu.show();
		    			   }
		    		   }
		    	   }
		       }
		       break;	
		case 2: account=DataStore.lookupAccount(emailid);
		        if(account!=null)
		        {
		        	if(account.isActivated())
		        	{
		        		account.suspend();
		        		DataStore.writeAccount(account);
		        	}
		        	else
		        	{
		        		System.out.println("Your account suspended already!");
		        		show();
		        	}
		        }
		        break;
			
		
		
		default:
			System.out.println("Invalid option");
			MainMenu.show();
		    break;
		
		}
		
		//check if account is active. if yes then ask for suspending it
		
		// if yes suspend it if not go back to main menu
		
		// accept activation code, check if valid, if not give 2 more attempts
		
		//proceed to main menu
		MainMenu.show();
		
		
		
	}

}