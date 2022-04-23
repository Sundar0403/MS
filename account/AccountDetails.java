package account;

public class AccountDetails
{
	private int customerId;
	private int accountId;
	private double accountBalance=0.0;
	private String branch; 
	private boolean accountStatus=true;
	
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
	
	public void setAccountStatus(boolean accountStatus)
	{
		this.accountStatus=accountStatus;
	}
	
	public boolean getAccountStatus()
	{
		return accountStatus;
	}
	
	public String toString()
	{
		return "CustomerId = "+customerId+"{"+"AccountId = "+accountId+"{"+"Account Balance="+accountBalance+" , "+"Branch="+branch+" , "+"Account Status="+accountStatus+"}";
	}
}
