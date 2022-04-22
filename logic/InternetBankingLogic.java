package logic;
import cache.*;
import customer.*;
import account.*;
import java.util.*;
import transactionHistory.*;

public class InternetBankingLogic
{
	CacheLayer cacheObj=new CacheLayer();
	int custId=0;
	int accountId=1000;
	int transactionId=10000;
	int loanId=100000;
	public int getCustId()
	{
		return ++custId;
	}
	public int getAccountId()
	{
		return ++accountId;
	}
	public int getTransactionId()
	{
		return ++transactionId;
	}
	public int getLoanId()
	{
		return ++loanId;
	}
	public Map<Integer,CustomerDetails> userSignUp(int custId,CustomerDetails custObj)
	{
		Map<Integer,CustomerDetails> newMap=new HashMap<>();
		newMap=cacheObj.userSignUp(custId,custObj);
		return newMap;
	}
	
	public Map<Integer,AccountDetails> userAccount(int accountId,AccountDetails accountObj)
	{
		Map<Integer,AccountDetails> accountMap=new HashMap<>();
		accountMap=cacheObj.userAccount(accountId,accountObj);
		return accountMap;
	}
	
	public Map<Integer,List<TransactionHistoryDetails>> transactionUpdate(int accountId,List<TransactionHistoryDetails> transactionList)
	{
		Map<Integer,List<TransactionHistoryDetails>> transactionMap=new HashMap<>();
		transactionMap=cacheObj.transactionUpdate(accountId,transactionList);
		return transactionMap;
	}
	
	public List<TransactionHistoryDetails> getTransactionHistory(int customerId)
	{
		List<TransactionHistoryDetails> transactionList=new ArrayList<>();
		transactionList=cacheObj.getTransactionHistory(customerId);
		return transactionList;
	}
	
	public Map<Integer,List<Integer>> customerAccount(int customerId,List<Integer> accountList)
	{
		Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
		customerAccountMap=cacheObj.customerAccount(customerId,accountList);
		return customerAccountMap; 
	}
	public AccountDetails getAccount(int accountId)
	{
		AccountDetails accountObj=new AccountDetails();
		accountObj=cacheObj.getAccount(accountId);
		return accountObj;
	}
	
	public List<Integer> getAllAccounts(int customerId)
	{
		List<Integer> accountList=new ArrayList<>();
		accountList=cacheObj.getAllAccounts(customerId);
		return accountList;
	}
	
	public CustomerDetails getCustomer(int customerId)
	{
		CustomerDetails customerObj=new CustomerDetails();
		customerObj=cacheObj.getCustomer(customerId);
		return customerObj;
	}
	public AccountDetails deposit(double amount,AccountDetails accountObj)
	{
		accountObj=cacheObj.deposit(amount,accountObj);
		return accountObj;
	}
	public AccountDetails withdraw(double amount,AccountDetails accountObj)
	{
		accountObj=cacheObj.withdraw(amount,accountObj);
		return accountObj;
	}
	public AccountDetails moneyTransfer(double amount,AccountDetails accountObj,int receiverAccountId)
	{
		accountObj=cacheObj.moneyTransfer(amount,accountObj,receiverAccountId);
		return accountObj;
	}
	public double balanceEnquiry(int accountId)
	{
		double balance=cacheObj.balanceEnquiry(accountId);
		return balance;
	}
}



