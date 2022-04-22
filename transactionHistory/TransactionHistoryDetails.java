package transactionHistory;
import java.util.*;
import java.text.*;

public class TransactionHistoryDetails
{
	private int customerId;
	private int transactionId;
	private String date;
	private String transactionType;
	private double amount;
	private boolean transactionStatus=true;
	
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setTransactionId(int transactionId)
	{
		this.transactionId=transactionId;
	}
	
	public int getTransactionId()
	{
		return transactionId;
	}
	
	public void setDate(String date)
	{
		this.date=date;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setTransactionType(String transactionType)
	{
		this.transactionType=transactionType;
	}
	
	public String getTransactionType()
	{
		return transactionType;
	}
	
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setTransactionStatus(boolean transactionStatus)
	{
		this.transactionStatus=transactionStatus;
	}
	
	public boolean getTransactionStatus()
	{
		return transactionStatus;
	}
	
	public String toString()
	{
		return "TransactionId = { TransactionDate = "+date+" TransactionType = "+transactionType+" TransactionAmount = "+amount+" TransactionStatus = "+transactionStatus+" } ";	
	}
	
}

	
