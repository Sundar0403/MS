package cache;
import java.util.*;
import customer.*;
import account.*;
import transactionHistory.*;

public class CacheLayer
{
	private Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	private Map<Integer,AccountDetails> accountMap=new HashMap<>();
	private Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
	private Map<Integer,List<TransactionHistoryDetails>> transactionMap=new HashMap<>();
	private List<TransactionHistoryDetails> transactionList=new ArrayList<>();
	
	public Map<Integer,CustomerDetails> userSignUp(int custId,CustomerDetails custObj)
	{
		if(!customerMap.containsKey(custId))
		{
			customerMap.put(custId,custObj);
		}	
		return customerMap;
	}
	
	public Map<Integer,AccountDetails> userAccount(int accountId,AccountDetails accountObj)
	{
		accountMap.put(accountId,accountObj);
		return accountMap;
	}
	
	public Map<Integer,List<Integer>> customerAccount(int customerId,List<Integer> accountList)
	{
		customerAccountMap.put(customerId,accountList);
		return customerAccountMap;
	}
	
	public AccountDetails getAccount(int accountId)
	{
		AccountDetails accountObj=accountMap.get(accountId);
		return accountObj;
	}
	
	public List<Integer> getAllAccounts(int customerId)
	{
		List<Integer> accountList=customerAccountMap.get(customerId);
		return accountList;
	}
	
	public CustomerDetails getCustomer(int customerId)
	{
		CustomerDetails customerObj=customerMap.get(customerId);
		return customerObj;
	}
	
	public Map<Integer,List<TransactionHistoryDetails>> transactionUpdate(int accountId,List<TransactionHistoryDetails> transactionList)
	{
		transactionMap.put(accountId,transactionList);
		return transactionMap;
	}
	
	public AccountDetails changeAccountStatus(int accountId)
	{
		AccountDetails accountObj=getAccount(accountId);
		accountObj.setAccountStatus(false);
		return accountObj;
	}
	
	public List<TransactionHistoryDetails> getTransactionHistory(int customerId)
	{
		transactionList=transactionMap.get(customerId);
		return transactionList;
	}
	
	public AccountDetails deposit(double amount,AccountDetails accountObj)
	{
		double balance=accountObj.getAccountBalance();
		balance=balance+amount;
		accountObj.setAccountBalance(balance);
		return accountObj;
	}
	
	public AccountDetails withdraw(double amount,AccountDetails accountObj)
	{
		double balance=accountObj.getAccountBalance();
		balance=balance-amount;
		accountObj.setAccountBalance(balance);
		return accountObj;
	}
	
	public AccountDetails moneyTransfer(double amount,AccountDetails accountObj,int receiverAccountId)
	{
		double senderBalance=accountObj.getAccountBalance();
		senderBalance=senderBalance-amount;
		accountObj.setAccountBalance(senderBalance);
		AccountDetails receiverObj=accountMap.get(receiverAccountId);
		double receiverBalance=receiverObj.getAccountBalance();
		receiverBalance=receiverBalance+amount;
		receiverObj.setAccountBalance(receiverBalance);
		return accountObj;
	}
	
	public double balanceEnquiry(int accountId)
	{
		AccountDetails accountObj=accountMap.get(accountId);
		double balance=accountObj.getAccountBalance();
		return balance;
	}
}





