package logic;
import cache.*;
import customer.*;
import account.*;
import java.util.*;

public class InternetBankingLogic
{
	CacheLayer cacheObj=new CacheLayer();
	int custId=0;
	int accountId=1000;
	int loanId=10000;
	public int getCustId()
	{
		return ++custId;
	}
	public int getAccountId()
	{
		return ++accountId;
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
	
	public Map<Integer,List<Integer>> customerAccount(int customerId,List<Integer> accountList)
	{
		Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
		customerAccountMap=cacheObj.customerAccount(customerId,accountList);
		return customerAccountMap; 
	}
}
