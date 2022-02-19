package logic;
import implement.*;
import utility.*;

import java.io.*;
import pojo.*;

import java.util.*;

import account.AccountDetails;
import excep.*;

public class BankLogic implements ImplementorFunction {
	private int id=0;
	private int actId=1000;
	private long actNo=324500000;
	private int mergeId=0;
	//private int lastCustId=0;
	public int lastActId=1000;
	public long lastActNo=324500000;
	public static Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	//public static Map<Integer,AccountDetails> tempMap=new HashMap<>();
	private static Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
	UtilityClass utilObj=new UtilityClass();
	AccountDetails accObj=new AccountDetails();
	public long getAccountNo()
	{
		actNo=actNo+1;
		++lastActId;
		return actNo;
	}
	public int getId()
	{
		id=id+1;
		return id;
	}
	
	public int getAccountId()
	{
		++lastActNo;
		return ++actId;
	}
	
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerObj,int customerId) throws CustomException
	{
		//int custId=customerId;
		while(customerMap.containsKey(customerId))
		{
			//throw new CustomException("The Customer Id is Already Present");
			customerId=customerId+1;
		}
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
			
				//accountId=accountId+1;
			
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
	
	public void fileCheck(File fileObj) throws CustomException
	{
		if(fileObj==null)
		{
			throw new CustomException("File Can't be Null");
		}
	}
	
	public void createFile(String fileDestination,String fileName) throws CustomException
	{
		
		try
		{
			//utilObj.stringCheck(fileDestination);
			//utilObj.stringCheck(fileName);
			File fileObj=new File(fileDestination,fileName);
			if(fileObj.createNewFile())
			{
				System.out.println("New File is Created:");
			}
			else
			{
				System.out.println("File Already Exists:");
			}
		} 
		catch (IOException e) 
		{
			throw new CustomException("IOException Occured:");
			//e.printStackTrace();
		} 
	}
	
	public void writeFile(String filePath,String fileName/*,Map<Integer,CustomerDetails> customerMap,Map<Integer,Map<Integer,AccountDetails>> customerAccountMap*/) throws CustomException
	{
		//fileCheck(fileObj);
		//utilObj.stringCheck(filePath);
		//utilObj.stringCheck(fileName);
		try(FileOutputStream output=new FileOutputStream(filePath+fileName);
				ObjectOutputStream object=new ObjectOutputStream(output);)
		{
			object.writeObject(customerMap);
			object.writeObject(customerAccountMap);
			object.writeObject(lastActId);
			object.writeObject(lastActNo);
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
	}
	
	public void readsFile(String filePath,String fileName/*,Map<Integer,CustomerDetails> customerMap*/) throws CustomException
	{
		//fileCheck(fileObj);
		//utilObj.stringCheck(filePath);
		//utilObj.stringCheck(fileName);
		//Map<Integer,CustomerDetails> customerMap=new HashMap<>();
		try(FileInputStream input=new FileInputStream(filePath+fileName);
				ObjectInputStream object=new ObjectInputStream(input);)
		{
			customerMap=(Map<Integer,CustomerDetails>)object.readObject();
			System.out.println(customerMap);
			customerAccountMap=(Map<Integer,Map<Integer,AccountDetails>>)object.readObject();
			System.out.println(customerAccountMap);
			lastActId=(int)object.readObject();
			System.out.println("Last Used Account Id : "+lastActId);
			lastActNo=(long)object.readObject();
			System.out.println("Last Used Account Number : "+lastActNo);
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured:");
			e.printStackTrace();
		}
		//return customerMap;
	}
	
	
	/*public void writeFileAccounts(String filePath,String fileName,Map<Integer,Map<Integer,AccountDetails>> customerAccountMap) throws CustomException
	{
		//fileCheck(fileObj);
		utilObj.stringCheck(filePath);
		utilObj.stringCheck(fileName);
		try(FileOutputStream output=new FileOutputStream(filePath+fileName);
				ObjectOutputStream object=new ObjectOutputStream(output);)
		{
			
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
	}
	
	public Map<Integer,Map<Integer,AccountDetails>> readFileAccounts(String filePath,String fileName) throws CustomException
	{
		//fileCheck(fileObj);
		utilObj.stringCheck(filePath);
		utilObj.stringCheck(fileName);
		//Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
		try(FileInputStream input=new FileInputStream(filePath+fileName);
				ObjectInputStream object=new ObjectInputStream(input);)
		{
			
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured:");
			e.printStackTrace();
		}
		return customerAccountMap;
	}*/
	
	public void customerAccountMapCheck(int id,Map<Integer,AccountDetails> accountMap) throws CustomException
	{
		if(accountMap.get(id)==null)
		{
			throw new CustomException("Key Does Not Exist");
		}
		
	}
	
	public CustomerDetails getCustomerDetails(int id/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		return customerMap.get(id);
	}
	
	public Map<Integer,AccountDetails> getAllAccounts(int id/*,Map<Integer,Map<Integer,AccountDetails>> customerAccountMap*/) throws CustomException
	{
		customerMapCheck(id);
		return customerAccountMap.get(id);
	}
	
	public AccountDetails fetchAccountStatus(AccountDetails accountObj,boolean condition)
	{
		accountObj.setAccountStatus(condition);
		return accountObj;
	}
	
	public CustomerDetails fetchCustomerStatus(CustomerDetails accountObj,boolean condition)
	{
		accountObj.setCustomerStatus(condition);
		return accountObj;
	}
	
	public AccountDetails getSpecificAccount(int id,int actId) throws CustomException
	{
		//customerMapCheck(id);
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
