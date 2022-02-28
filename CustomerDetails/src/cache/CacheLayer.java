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
	public  void getCustomerCacheDetails(int id/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(customerMap.get(id));
		
	}
	public void addAccount(Map<Integer,Map<Integer,AccountDetails>> inputMap)
	{
		customerAccountDetails=inputMap;
		//System.out.println(customerAccountDetails);
	}
	public  void getAccountCacheDetails(int customerId,int accountId/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(customerAccountDetails.get(customerId).get(accountId));
		
	}
}
