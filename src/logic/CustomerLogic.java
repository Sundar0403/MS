package logic;
import pojo.*;

import java.util.*;

import account.AccountDetails;
import excep.*;

public class CustomerLogic {
	int id=0;
	int actId=1000;
	long actNo=324500000;
	int mergeId=0;
	static Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	static Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
	
	public long getAccountNo()
	{
		return ++actNo;
	}
	public int getId()
	{
		return ++id;
	}
	
	public int getAccountId()
	{
		return ++actId;
	}
	
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerObj,int customerId)
	{
		customerMap.put(customerId,customerObj);
		return customerMap;
	}
	
	public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId,int accountId) throws CustomException
	{
		customerMapCheck(customerId);
		Map<Integer,AccountDetails> accountMap=customerAccountMap.get(customerId);
		if(accountMap==null)
		{	
			accountMap=new HashMap<>();
			accountMap.put(accountId, accountObj);
			customerAccountMap.put(customerId, accountMap);
		}
		else
		{
			accountMap.put(accountId, accountObj);
		}
		
		return customerAccountMap;
	}
	
	public void customerMapCheck(int id) throws CustomException
	{
		if(customerMap.get(id)==null)
		{
			throw new CustomException("Key Does Not Exist");
		}
		
	}
	
	public CustomerDetails getCustomerDetails(int id,Map<Integer,CustomerDetails> inputMap) throws CustomException
	{
		customerMapCheck(id);
		return inputMap.get(id);
	}
	
	public Map<Integer,AccountDetails> getAllAccounts(int id) throws CustomException
	{
		customerMapCheck(id);
		return customerAccountMap.get(id);
	}
	
	
	public AccountDetails getSpecificAccount(int id,int actId) throws CustomException
	{
		customerMapCheck(id);
		Map<Integer,AccountDetails> tempMap=customerAccountMap.get(id);
		if(tempMap!=null)
		{	
			return tempMap.get(actId);
		}
		else
		{
			throw new CustomException("Key Does Not Exist");
		}
	}
	
}
