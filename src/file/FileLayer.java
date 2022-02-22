package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
//import logic.*;
import account.AccountDetails;
import excep.CustomException;
import pojo.CustomerDetails;
import utility.UtilityClass;

public class FileLayer {
	
	//BankLogic bankObj=new BankLogic();
	private int id=0;
	private int actId=1000;
	private long actNo=324500000;
	//private int mergeId=0;
	public int lastActId=1000;
	public int lastId=0;
	public long lastActNo=324500000;
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
	UtilityClass utilObj=new UtilityClass();
	AccountDetails accObj=new AccountDetails();
	public long getAccountNo()
	{
		++lastActNo;
		return ++actNo;
	}
	public int getId()
	{
		++lastId;
		return ++id;
	}
	
	public int getAccountId()
	{
		System.out.println("asfd");
		++lastActId;
		return actId++;
	}
	
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerObj) throws CustomException
	{

		int customerId=getId();
		customerObj.setCustomerId(customerId);
		while(customerMap.containsKey(customerId))
		{
			customerId=customerId+1;
		}
			customerMap.put(customerId,customerObj);
			return customerMap;
	}
	
	public  void getCustomerDetails(int id/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(customerMap.get(id));
		
	}
	
	public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId) throws CustomException
	{

		int accountId=getAccountId();
		System.out.println(accountId);
		Map<Integer,AccountDetails> accountMap=customerAccountMap.get(customerId);
		if(accountMap==null)
		{	
			accountMap=new HashMap<>();
			customerAccountMap.put(customerId, accountMap);
		}
		accountMap.put(accountId, accountObj);
		return customerAccountMap;
	}
	
	public void getCustomerFromCache(int customerId)
	{
		
	}
	/*public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId) throws CustomException
	{
		
		bankObj.customerMapCheck(customerId);
		int accountId=getAccountId();
		accountObj.setAccountId(accountId);
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
	}*/
	
	public void createFile(String fileDestination,String fileName) throws CustomException
	{
		
		try
		{
			
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
	
	public void writeFile(String filePath,String fileName) throws CustomException
	{
		
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
	
	public void readsFile(String filePath,String fileName) throws CustomException
	{
		
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
	

}
