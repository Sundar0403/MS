package cache;
import java.util.*;
import customer.*;
import account.*;

public class CacheLayer
{
	private static Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	private static Map<Integer,AccountDetails> accountMap=new HashMap<>();
	private static Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
	public Map<Integer,CustomerDetails> userSignUp(int custId,CustomerDetails custObj)
	{
		customerMap.put(custId,custObj);
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
}
