package customer;
import java.util.*;

public class CustomerDetails
{
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String password;
	private double customerInfoWallet;
	
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;	
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public void setCustomerAddress(String customerAddress)
	{
		this.customerAddress=customerAddress;
	}
	
	public String getCustomerAddress()
	{
		return customerAddress;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setCustomerInfoWallet(double customerInfoWallet)
	{
		this.customerInfoWallet=customerInfoWallet;
	}
	
	public double getCustomerInfoWallet()
	{
		return customerInfoWallet;
	}
	
	public String toString()
	{
		return "CustomerId ={CustomerName = "+customerName+" CustomerAddress = "+customerAddress+" Password = "+password+" Customer Info Wallet = $"+customerInfoWallet+"}";
	}
}
