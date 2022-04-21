package customer;
import java.util.*;

public class CustomerDetails
{
	private static int custId;
	private static String customerName;
	private static String userId;
	private static String customerPassword;
	private static boolean customerStatus=true;
	
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
		return "CustomerId = "+custId+"{"+"Customer Name="+customerName+" , "+"User Id="+userId+" , "+"Customer Password="+customerPassword+" , "+"Customer Status="+customerStatus+"}";
	}
}
