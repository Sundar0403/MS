package cache;
import pojo.*;
import account.*;
import excep.CustomException;

import java.util.*;

public class CacheLayer {
	
	public static Map <Integer,CustomerDetails> customerMap=new HashMap<>();
	public static Map <Integer,Map<Integer,AccountDetails>> customerAccountDetails=new HashMap<>();
	public void addCustomer(Map<Integer,CustomerDetails> inputMap)
	{
		customerMap=inputMap;
		System.out.println(customerMap);
	}
	public  void getCustomerCacheDetails(int id,Map<Integer,CustomerDetails> inputMap) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		customerMap=inputMap;
		System.out.println(customerMap.get(id));
		
	}
	public void addAccount(Map<Integer,Map<Integer,AccountDetails>> inputMap)
	{
		customerAccountDetails=inputMap;
		System.out.println(customerAccountDetails);
	}
	public  void getAccountCacheDetails(int customerId,int accountId,Map<Integer,Map<Integer,AccountDetails>> inputMap) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(customerAccountDetails.get(customerId).get(accountId));
		
	}
	public void deposit(int customerId,int AccountId,double amount,Map<Integer,Map<Integer,AccountDetails>> accountMap) throws CustomException
	{
		
		double deposit;
		customerAccountDetails=accountMap;
		AccountDetails accountObj=customerAccountDetails.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount>100)
			{
				if(amount<100000)
				{
					deposit=accountObj.getAccountBalance()+amount;
					accountObj.setAccountBalance(deposit);
					System.out.println(accountObj);
					System.out.println(customerAccountDetails);
				}
				else
				{
					System.out.println("Deposit Amount Should be Less than 100000");
				}
			}
			else
			{
				System.out.println("Deposit Amount Should be Greater than 100");
			}
		}
		else
		{
			System.out.println("This is a Deactivated Account Can't be Deposit");
		}
	}
	public void withdraw(int customerId,int AccountId,double amount,Map<Integer,Map<Integer,AccountDetails>> inputMap) throws CustomException
	{
		double withdraw;
		customerAccountDetails=inputMap;
		System.out.println(customerAccountDetails);
		AccountDetails accountObj=customerAccountDetails.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount<accountObj.getAccountBalance())
			{
				withdraw=accountObj.getAccountBalance()-amount;
				accountObj.setAccountBalance(withdraw);
				System.out.println(accountObj);
				System.out.println(customerAccountDetails);
			}
			else
			{
				System.out.println("Insufficient Balance to Withdraw");
			}
		}
		else
		{
			System.out.println("This is a Deactivated Account Can't be Deposit");
		}
	}
	public void fetchCustomerStatus(int customerId,Map<Integer,CustomerDetails> inputMap) throws CustomException
	{
		customerMap=inputMap;
		CustomerDetails customerObj=customerMap.get(customerId);
		customerObj.setCustomerStatus(false);
		System.out.println(customerMap);
	}
	public void fetchAccountStatus(int customerId,int accountId,Map<Integer,Map<Integer,AccountDetails>> inputMap) throws CustomException
	{
		customerAccountDetails=inputMap;
		AccountDetails accountObj=customerAccountDetails.get(customerId).get(accountId);
		accountObj.setAccountStatus(false);
		System.out.println(customerAccountDetails);
	}
	
}
