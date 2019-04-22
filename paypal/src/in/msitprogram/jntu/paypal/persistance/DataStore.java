package in.msitprogram.jntu.paypal.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import in.msitprogram.jntu.paypal.accounts.PPAccount;
//import in.msitprogram.jntu.paypal.accounts.PPRestrictedAccount;

public class DataStore
{

	static Vector<PPAccount> vector =new Vector<>();

	public static PPAccount lookupAccount(String email) throws FileNotFoundException, IOException, ClassNotFoundException{
		PPAccount account = null; //initialize it after reading from file
		// write code to open the files, read
		File ppfile = new File("PersonalAcc1.txt");
		if (ppfile.exists())
		{
			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ppfile));
				Vector<PPAccount> vec = new Vector<PPAccount>();
				vec = (Vector<PPAccount>)ois.readObject();
				for (int i = 0; i <vec.size();i++){
					account = vec.get(i);
					
					//System.out.println(account);
					if(account.getEmail().equals(email)){
						ois.close();
						return account;
					}
				
				ois.close();
			
		}
		return null;}
		return account;
	}

	@SuppressWarnings("unchecked")
	public static void writeAccount(PPAccount account) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream Ois = null;

	
			File ppfile = new File("PersonalAcc1.txt");
			if (ppfile.exists()){
				//creating the obj for read the data
				Ois = new ObjectInputStream(new FileInputStream(ppfile));
				//creating the vector to read the obj which is already present
				//getting the obj already exists into it 
				vector = (Vector<PPAccount>)Ois.readObject();
				
				for (int i = 0 ; i < vector.size();i++){
				
					if (vector.get(i).getEmail().equals(account.getEmail()))
						vector.removeElement(vector.get(i));
				}
				vector.addElement(account);
				ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(ppfile));
				OOS.writeObject(vector);
				OOS.close();
				Ois.close();
			} 
			else 
			{
				
				ppfile.createNewFile();
				ObjectOutputStream Oos = new ObjectOutputStream(new FileOutputStream(ppfile));
				vector.add(account);
				Oos.writeObject(vector);
				Oos.close();
			}
		

	}
}