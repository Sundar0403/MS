package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import logic.*;
import account.AccountDetails;
import excep.CustomException;
import pojo.CustomerDetails;
import utility.UtilityClass;

public class FileLayer {
	
	//BankLogic bankObj=new BankLogic();
	Scanner scan=new Scanner(System.in);
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
		++lastActId;
		return ++actId;
	}
	
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerObj) throws CustomException
	{

		System.out.println("Enter the FileName");
		String fileName=scan.nextLine();
		int customerId=getId();
		Map<Integer,CustomerDetails> customerMap=readCustomerFile(fileName);
		customerObj.setCustomerId(customerId);
		while(customerMap.containsKey(customerId))
		{
			customerId=customerId+1;
		}
			customerMap.put(customerId,customerObj);
			System.out.println(customerMap);
			writeCustomerFile(customerMap);
			return customerMap;
	}
	
	public  void getCustomerDetails(int id,Map<Integer,CustomerDetails> inputMap) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(inputMap.get(id));
		
	}
	public  void getAccountDetails(int customerId,int accountId/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		System.out.println(customerAccountMap.get(customerId).get(accountId));
		
	}
	
	public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId) throws CustomException
	{
		
		System.out.println("Enter the FileName");
		String fileName=scan.nextLine();
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile(fileName);
		
		Map<Integer,AccountDetails> accountMap=customerAccountMap.get(customerId);
		if(accountMap==null)
		{	
			accountMap=new HashMap<>();
			//accountMap.put(accountId, accountObj);
			customerAccountMap.put(customerId, accountMap);
		}
		long accountNo=++lastActNo;
		accountObj.setAccountNumber(accountNo);
		int accountId=++lastActId;
		System.out.println(accountId);
		accountMap.put(accountId, accountObj);
		
		writeAccountFile(customerAccountMap);
		return customerAccountMap;
	}
	
	public void deposit(int customerId,int AccountId,double amount) throws CustomException
	{
		System.out.println("Enter the FileName");
		String fileName=scan.nextLine();
		double deposit;
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile(fileName);
		System.out.println(customerAccountMap);
		AccountDetails accountObj=customerAccountMap.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount>100)
			{	
				if(amount<100000)
				{
					deposit=amount+accountObj.getAccountBalance();
					accountObj.setAccountBalance(deposit);
					System.out.println(accountObj);
					System.out.println(customerAccountMap);
				}
				else
				{
					System.out.println("Deposit Amount Should Not Be Greater than 100000");
				}
			}
			else
			{
				System.out.println("Deposit Amount Should Not Be Less than 100");
			}
		}
		else
		{
			System.out.println("This is a Deactivated Account Can't be Deposit");
		}
	}
	
	public void withdraw(int customerId,int AccountId,double amount) throws CustomException
	{
		System.out.println("Enter the FileName");
		String fileName=scan.nextLine();
		double withdraw;
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile(fileName);
		System.out.println(customerAccountMap);
		AccountDetails accountObj=customerAccountMap.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount<accountObj.getAccountBalance())
			{
				withdraw=amount+accountObj.getAccountBalance();
				accountObj.setAccountBalance(withdraw);
				System.out.println(accountObj);
				System.out.println(customerAccountMap);
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
	
	public void createFile(String fileName) throws CustomException
	{
		
		try
		{
			
			File fileObj=new File(fileName);
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
	
	public void writeCustomerFile(Map<Integer,CustomerDetails>customerMap) throws CustomException
	{
		System.out.println("Enter the Filename To Write Customer Deatils:");
		String fileName=scan.nextLine();
		try(FileOutputStream output=new FileOutputStream(fileName);
				ObjectOutputStream object=new ObjectOutputStream(output);)
		{
			object.writeObject(customerMap);
			object.writeObject(lastId);
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
	}
	public void writeAccountFile(Map<Integer,Map<Integer,AccountDetails>>AccountMap) throws CustomException
	{
		System.out.println("Enter the Filename To Write Account Details:");
		String fileName=scan.nextLine();
		try(FileOutputStream output=new FileOutputStream(fileName);
				ObjectOutputStream object=new ObjectOutputStream(output);)
		{
			object.writeObject(AccountMap);
			object.writeObject(lastActId);
			object.writeObject(lastActNo);
		}
	
		catch(IOException e)
		{
			System.out.println("IOException Occured:");
			e.printStackTrace();
		}
	}

	
	public Map<Integer,CustomerDetails> readCustomerFile(String fileName) throws CustomException
	{
		Map<Integer,CustomerDetails> customerMap=new HashMap<>();
		try(FileInputStream input=new FileInputStream(fileName);
				ObjectInputStream object=new ObjectInputStream(input);)
		{
			customerMap=(Map<Integer,CustomerDetails>)object.readObject();
			//System.out.println(customerMap);
			lastId=(int)object.readObject();
			System.out.println("Last Used Account Id : "+lastId);
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
		return customerMap;
	}	
		public Map<Integer,Map<Integer,AccountDetails>> readAccountFile(String fileName) throws CustomException
		{
			Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
			try(FileInputStream input=new FileInputStream(fileName);
					ObjectInputStream object=new ObjectInputStream(input);)
			{
				
				customerAccountMap=(Map<Integer,Map<Integer,AccountDetails>>)object.readObject();
				//System.out.println(customerAccountMap);
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
			return customerAccountMap;
	}
	

}