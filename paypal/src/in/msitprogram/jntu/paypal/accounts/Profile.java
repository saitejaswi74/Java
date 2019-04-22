package in.msitprogram.jntu.paypal.accounts;

import java.io.Serializable;

public class Profile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456789;
	private String name;
	private String address;
	private String phone;
	
	public void setName(String name)
	{
		this.name=name;
	}
	

	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getPhone()
	{
		return phone;
	}
}
