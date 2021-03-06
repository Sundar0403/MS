package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private File custFile=new File("/home/inc3/eclipse-workspace/BankingWebApp/Sa");
	private File actFile=new File("//home/inc3/eclipse-workspace/BankingWebApp/Sundar");
	private File userFile=new File("/home/inc3/eclipse-workspace/BankingWebApp/file");
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
		int customerId=getId();
		Map<Integer,CustomerDetails> customerMap=readCustomerFile();
		customerObj.setCustomerId(customerId);
		while(customerMap.containsKey(customerId))
		{
			customerId=customerId+1;
		}
		customerObj.setCustomerId(customerId);
			customerMap.put(customerId,customerObj);
			System.out.println(customerMap);
			writeCustomerFile(customerMap);
			return customerMap;
	}
	
	public List<String> getBranches()
	{
		List<String> branchList=new ArrayList<String>();
		branchList.add("Pallathur");
		branchList.add("Chennai");
		branchList.add("Coimbatore");
		branchList.add("Madurai");
		branchList.add("Trichy");
		branchList.add("Salem");
		branchList.add("Tirunelveli");
		branchList.add("Vellore");
		branchList.add("Erode");
		branchList.add("Tuticorin");
		branchList.add("Tirupur");
		branchList.add("Thanjavur");
		branchList.add("Dindigul");
		branchList.add("Karaikudi");
		
		return branchList;
	}
	
	public  CustomerDetails getCustomerDetails(int id) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		Map<Integer,CustomerDetails> inputMap=readCustomerFile();
		return inputMap.get(id);
		
	}
	public Map<Integer,CustomerDetails> updateDetails(int customerId,CustomerDetails custObj) throws CustomException
	{
		Map<Integer,CustomerDetails> inputMap=readCustomerFile();
		inputMap.put(customerId,custObj);
		writeCustomerFile(inputMap);
		return inputMap;
	}
	public Map<Integer,Map<Integer,AccountDetails>> updateAccountDetails(int customerId,int accountId,AccountDetails accountObj) throws CustomException
	{
		System.out.println("File Update");
		Map<Integer,Map<Integer,AccountDetails>> accountMap=readAccountFile();
		Map<Integer,AccountDetails> inputMap=getAllAccountDetails(customerId);
		inputMap.put(accountId,accountObj);
		accountMap.put(customerId,inputMap);
		writeAccountFile(accountMap);
		return accountMap;
	}
	public  AccountDetails getAccountDetails(int customerId,int accountId/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		Map<Integer,Map<Integer,AccountDetails>> accountMap=readAccountFile();
		System.out.println(accountMap.get(customerId).get(accountId));
		return accountMap.get(customerId).get(accountId);
		
	}
	public  Map<Integer,AccountDetails> getAllAccountDetails(int customerId/*Map<Integer,CustomerDetails> inputMap*/) throws CustomException
	{
		//customerMapCheck(id);
		//return inputMap.get(id);
		Map<Integer,Map<Integer,AccountDetails>> accountMap=readAccountFile();
		return accountMap.get(customerId);
		
	}
	
	public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId) throws CustomException
	{
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile();
		
		Map<Integer,AccountDetails> accountMap=customerAccountMap.get(customerId);
		if(accountMap==null)
		{	
			accountMap=new HashMap<>();
			//accountMap.put(accountId, accountObj);
			customerAccountMap.put(customerId, accountMap);
		}
		accountObj.setCustomerId(customerId);
		long accountNo=++lastActNo;
		accountObj.setAccountNumber(accountNo);
		int accountId=++lastActId;
		accountObj.setAccountId(accountId);
		System.out.println(accountId);
		accountMap.put(accountId, accountObj);
		
		writeAccountFile(customerAccountMap);
		return customerAccountMap;
	}
	
	public void deposit(int customerId,int AccountId,double amount) throws CustomException
	{
		double deposit;
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile();
		System.out.println(customerAccountMap);
		AccountDetails accountObj=customerAccountMap.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount>100)
			{	
				if(amount<100000)
				{
					deposit=accountObj.getAccountBalance()+amount;
					accountObj.setAccountBalance(deposit);
					System.out.println(accountObj);
					System.out.println(customerAccountMap);
					writeAccountFile(customerAccountMap);
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
	
	public Map<Integer,String> userCredentials()
	{
		Map<Integer,String> userMap=new HashMap<>();
		userMap.put(1,"101");
		userMap.put(2,"102");
		userMap.put(3,"103");
		userMap.put(4,"104");
		userMap.put(5,"105");
		userMap.put(6,"106");
		userMap.put(7,"107");
		userMap.put(8,"108");
		userMap.put(9,"109");
		userMap.put(10,"110");
		userMap.put(11,"111");
		userMap.put(12,"112");
		userMap.put(13,"113");
		userMap.put(14,"114");
		userMap.put(15,"115");
		return userMap;
	}
	
	public void accountTransfer(int fromActId,int toActId,double amount) throws CustomException
	{
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile();
		for(int key:customerAccountMap.keySet())
		{
			Map<Integer,AccountDetails> accountMap=customerAccountMap.get(key);
			if(accountMap.containsKey(fromActId))
			{
				AccountDetails accountObj=accountMap.get(fromActId);
				if(accountObj.isAccountStatus()==true)
				{
					if(amount<accountObj.getAccountBalance())
					{
						double withdraw=accountObj.getAccountBalance()-amount;
						accountObj.setAccountBalance(withdraw);
						System.out.println(accountObj);
						System.out.println(customerAccountMap);
						writeAccountFile(customerAccountMap);
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
			if(accountMap.containsKey(toActId))
			{
				AccountDetails accountObj=accountMap.get(toActId);
				if(accountObj.isAccountStatus()==true)
				{
					if(amount>100)
					{	
						if(amount<100000)
						{
							double deposit=accountObj.getAccountBalance()+amount;
							accountObj.setAccountBalance(deposit);
							System.out.println(accountObj);
							System.out.println(customerAccountMap);
							writeAccountFile(customerAccountMap);
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
		}
	}
	
	public void withdraw(int customerId,int AccountId,double amount) throws CustomException
	{
		double withdraw;
		Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=readAccountFile();
		System.out.println(customerAccountMap);
		AccountDetails accountObj=customerAccountMap.get(customerId).get(AccountId);
		if(accountObj.isAccountStatus()==true)
		{
			if(amount<accountObj.getAccountBalance())
			{
				withdraw=accountObj.getAccountBalance()-amount;
				accountObj.setAccountBalance(withdraw);
				System.out.println(accountObj);
				System.out.println(customerAccountMap);
				writeAccountFile(customerAccountMap);
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
	
	public void fetchCustomerStatus(int customerId) throws CustomException
	{
		Map<Integer,CustomerDetails> inputMap=readCustomerFile();
		
		CustomerDetails customerObj=inputMap.get(customerId);
		customerObj.setCustomerStatus(false);
		writeCustomerFile(inputMap);
		
	}
	public void fetchAccountStatus(int customerId,int accountId) throws CustomException
	{
		Map<Integer,Map<Integer,AccountDetails>> inputMap=readAccountFile();
		
		AccountDetails accountObj=inputMap.get(customerId).get(accountId);
		accountObj.setAccountStatus(false);
		writeAccountFile(inputMap);
	}
	public void activateCustomerStatus(int customerId) throws CustomException
	{
		Map<Integer,CustomerDetails> inputMap=readCustomerFile();
		
		CustomerDetails customerObj=inputMap.get(customerId);
		customerObj.setCustomerStatus(true);
		writeCustomerFile(inputMap);
		
	}
	public void activateAccountStatus(int customerId,int accountId) throws CustomException
	{
		Map<Integer,Map<Integer,AccountDetails>> inputMap=readAccountFile();
		
		AccountDetails accountObj=inputMap.get(customerId).get(accountId);
		accountObj.setAccountStatus(true);
		writeAccountFile(inputMap);
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
		try(FileOutputStream output=new FileOutputStream(custFile);
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
		try(FileOutputStream output=new FileOutputStream(actFile);
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

	
	public Map<Integer,CustomerDetails> readCustomerFile() throws CustomException
	{
		Map<Integer,CustomerDetails> customerMap=new HashMap<>();
		
			try(FileInputStream input=new FileInputStream(custFile);
					ObjectInputStream object=new ObjectInputStream(input);)
			{
				customerMap=(Map<Integer,CustomerDetails>)object.readObject();
				System.out.println("---------------This is in File Layer------------");
				System.out.println(customerMap);
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
		public Map<Integer,Map<Integer,AccountDetails>> readAccountFile() throws CustomException
		{
			Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
			if(actFile.exists())
			{
				try(FileInputStream input=new FileInputStream(actFile);
						ObjectInputStream object=new ObjectInputStream(input);)
				{
				
					customerAccountMap=(Map<Integer,Map<Integer,AccountDetails>>)object.readObject();
					System.out.println("--------------This is in File Layer-----------------");
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
			}	
		//return customerMap;
			return customerAccountMap;
	}
	

}