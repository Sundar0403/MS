package customer;
import java.util.*;

public class CustomerDetails
{
	private int custId;
	private String customerName;
	private String userId;
	private String customerPassword;
	private boolean customerStatus=true;
	
	public void setCustomerId(int custId)
	{
		this.custId=custId;
	}
	
	public int getCustomerId()
	{
		return custId;
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public void setCustomerPassword(String customerPassword)
	{
		this.customerPassword=customerPassword;
	}
	
	public String getCustomerPassword()
	{
		return customerPassword;
	}
	
	public String toString()
	{
		return "CustomerId ={"+"Customer Name="+customerName+" , "+"User Id="+userId+" , "+"Customer Password="+customerPassword+" , "+"Customer Status="+customerStatus+"}";
	}
}
