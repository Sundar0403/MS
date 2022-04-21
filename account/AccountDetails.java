package account;

public class AccountDetails
{
	private static int customerId;
	private static int accountId;
	private static double accountBalance=0.0;
	private static String branch; 
	private static boolean accountStatus=true;
	
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setAccountId(int accountId)
	{
		this.accountId=accountId;
	}
	
	public int getAccountId()
	{
		return accountId;
	}
	
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance=accountBalance;
	}
	
	public double getAccountBalance()
	{
		return accountBalance;
	}
	
	public void setBranch(String branch)
	{
		this.branch=branch;
	}
	
	public String getBranch()
	{
		return branch;
	}
	
	public String toString()
	{
		return "CustomerId = "+customerId+"{"+"AccountId = "+accountId+"{"+"Account Balance="+accountBalance+" , "+"Branch="+branch+" , "+"Account Status="+accountStatus+"}";
	}
}
