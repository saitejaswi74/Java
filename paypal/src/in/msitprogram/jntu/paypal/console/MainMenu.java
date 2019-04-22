/**
 * 
 */
package in.msitprogram.jntu.paypal.console;


import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import in.msitprogram.jntu.paypal.persistance.DataStore;

/**
 * @author pg
 *
 */
public class MainMenu {
	
	public static void show() throws IOException, ClassNotFoundException{
		//show the welcome message with the main menu options
		
		//take the menu option as input from the console
		
		//take email address as input from the console
		
		//based on the given menu option instantiate the respective screens
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\tWELCOME TO PAYPAL");
		System.out.println("\n1. Signin\n2. New Account ");
		System.out.println("Choose any option");
		int ch=sc.nextInt();
		String email;
		switch(ch)
		{
		case 1: 
			System.out.println("Signin into paypal account");
			System.out.println("Enter your email");
			email=sc.next();
			if(DataStore.lookupAccount(email)!=null)
            {
	          PPAccountScreen ppas=new PPAccountScreen(email);
		
	          ppas.show();
	          
            }
			else 
			{
				System.out.println("Account does not exists");
				MainMenu.show();
			}
			break;
			
		case 2:
			System.out.println("New Account");
			System.out.println("Enter your email");
			email=sc.next();
		    if(DataStore.lookupAccount(email)!=null)
		    {
				System.out.println("This email is already exits");
				MainMenu.show();
			}
			else
			{
			
				PPNewAccountScreen newaccount=new PPNewAccountScreen(email);
				newaccount.show();
			}
			break;
			
	    
		}
	}

}
