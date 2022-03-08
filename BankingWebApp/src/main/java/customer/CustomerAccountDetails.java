package customer;
import implement.*;
import file.*;
import java.io.*;
import utility.*;
import excep.*;
import logic.*;
//import java.io.*;
import account.*;
import pojo.*;
import java.util.*;

public class CustomerAccountDetails {
	BankLogic newLogic=new BankLogic();
	UtilityClass utilObj=new UtilityClass();
	FileLayer fileObj=new FileLayer();
	
	Scanner scan=new Scanner(System.in);
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,AccountDetails> inputMap=new HashMap<>();
	Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
	
	private void retrieveFromCustomer() throws CustomException
	{
		System.out.println("Enter the Number of Customers :");
		int values=scan.nextInt();
		scan.nextLine(); 
		for(int i=0;i<values;i++)
		{
			CustomerDetails customerObj=new CustomerDetails();
			int customerId=newLogic.getId();
			/*while(newLogic.customerMap.containsKey(customerId))
			{
				customerId=customerId+1;
			}
			customerObj.setCustomerId(customerId);*/
			System.out.println("Enter the Customer Name :");
			String name=scan.nextLine();
			customerObj.setCustomerName(name);
			System.out.println("Enter the Customer Address :");
			String address=scan.nextLine();
			customerObj.setCustomerAddress(address);
			System.out.println("Enter the Customer Mobile Number :");
			long mobNo=scan.nextLong();
			scan.nextLine();
			customerObj.setMobileNumber(mobNo);
			System.out.println("Enter the Status of the Customer Details :");
			String status=scan.nextLine();
			if(status.equals("true"))
			{
				/*customerMap=*/newLogic.addCustomerDetails(customerObj);
			}
			else if(status.equals("false"))
			{
				boolean condition=false;
				customerObj=newLogic.fetchCustomerStatus(customerObj,condition);
			}
			else
			{
				throw new CustomException("Invalid Data Entered :");
			}	
		}
		//System.out.println(customerMap);
	}
	
	private void getCustomer()
	{
			try
			{
				System.out.println("Enter the File Name to get Customer Details :");
				String fName=scan.nextLine();
				System.out.println("Enter the Id That the Details Needed to Retrieve :");
				int inputId=scan.nextInt();
				scan.nextLine();
				newLogic.getCustomerDetails(inputId);
				newLogic.getCustomerCacheDetails(inputId,fName);
			}
			catch(CustomException e)
			{
				System.out.println("Exception Occured :"+e.getMessage());
				e.printStackTrace();
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured :"+e.getMessage());
				e.printStackTrace();
			}
	}
	
	private void retrieveFromAccount() throws CustomException
	{ 
		
		CustomerDetails customerObj=new CustomerDetails();

		if(customerObj.isCustomerStatus()==true)
		{
			System.out.println("Enter the Number of Accounts:"); 
			int values=scan.nextInt();
			scan.nextLine();
			
			for(int i=0;i<values;i++)
			{			
				//int accountId=newLogic.getAccountId();
				
				/*int accountId=newLogic.lastActId+1;
					
				accountObj.setAccountId(accountId);*/
				AccountDetails accountObj=new AccountDetails();	
				System.out.println("Enter the Customer Id :");
				int customerId=scan.nextInt();
				scan.nextLine();	
				accountObj.setCustomerId(customerId);
				
				System.out.println("Enter the Account Balance:");
				double accBalance=scan.nextDouble();
				scan.nextLine();
				accountObj.setAccountBalance(accBalance);
				System.out.println("Enter the Account Maintaining Branch :");
				String branch=scan.nextLine();
				accountObj.setBranchName(branch);
				System.out.println("Enter the Status");
				String status=scan.nextLine();
				if(status.equals("true"))
				{
					//try
					//{
						System.out.println(accountObj);
						/*customerAccountMap=*/newLogic.addAccountDetails(accountObj,customerId);
					//}
					//catch(CustomException e)
					//{
						//System.out.println("Exception Occured : "+e.getMessage());
					//}
					//catch(Exception e)
					//{
						//System.out.println("Exception Occured : "+e.getMessage());
					//}
				}
				else if(status.equals("false"))
				{
					boolean condition=false;
					accountObj=newLogic.fetchAccountStatus(accountObj,condition);
					System.out.println(accountObj);
				}
				else
				{
					throw new CustomException("Invalid Data Entered :");
				}
			}
	
			//System.out.println(customerAccountMap);
		}
		else
		{
			System.out.println("Account can't be created Beacuse it's a Deactivated Customer Id :");
		}
	}
		private void getAccounts()
		{
			AccountDetails accountObj=new AccountDetails();
			try
			{
				System.out.println("Enter the File Name to get Customer Details");
				String fileName=scan.nextLine();
				System.out.println("Enter the Customer ID To Retrieve Account Details :");
				int custId=scan.nextInt();
				scan.nextLine();
				//inputMap=newLogic.getAllAccounts(custId/*,customerAccountMap*/);
				System.out.println(inputMap);
				System.out.println("Enter the Account ID to Retrieve Specific Account :");
				int actId=scan.nextInt();
				scan.nextLine();
				newLogic.getAccountDetails(custId,actId);
				newLogic.getAllAccountDetails(custId);
				newLogic.getAccountCacheDetails(custId,actId,fileName);
				//System.out.println(accountObj);
			}
			catch(CustomException e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
				e.printStackTrace();
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
				e.printStackTrace();
			}
			
		}
		
	/*private void getAccountDetails()
	{
		AccountDetails accountObj=getAccounts();
		System.out.println(accountObj);
	}*/
	
	private void depositAmount()
	{
		try
		{
			System.out.println("Enter the Customer Id to Deposit:");
			int customerId=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Account Id to Deposit:");
			int accountId=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Amount to Deposit:");
			double amount=scan.nextDouble();
			scan.nextLine();
			newLogic.deposit(customerId, accountId, amount);
			
		}
		catch(CustomException e)
		{
			System.out.println("Deposit Can't be Done :");
		}
	}
	
	private void withdrawAmount()
	{
		try
		{
			System.out.println("Enter the Customer Id to Withdraw:");
			int customerId=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Account Id to Withdraw:");
			int accountId=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Amount to Withdraw:");
			double amount=scan.nextDouble();
			scan.nextLine();
			System.out.println("Enter the Filename:");
			String fName=scan.nextLine();
			newLogic.withdraw(customerId, accountId, amount);
			
		}
		catch(CustomException e)
		{
			System.out.println("Withdraw Can't be Done :");
		}
	
	}
	
	private void fileCreation()
	{
		try
		{
			/*System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();*/
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			newLogic.createFile(fileName);
			/*newLogic.writeFile(fileName,customerMap,customerAccountMap);
			newLogic.writeFile(filePath,fileName,customerAccountMap);*/
		}
		catch(CustomException e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void readFileCustomer()
	{
		try
		{
			newLogic.readCustomer();
			//newLogic.createFile(filePath,fileName);
			//fileObj.readsFile(filePath,fileName);
			/*Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=newLogic.readFileAccounts(filePath,fileName);
			System.out.println(customerMap);
			System.out.println("Enter the Id That the Details Needed to Retrieve :");
			int inputId=scan.nextInt();
			scan.nextLine();
			System.out.println(newLogic.getCustomerDetails(inputId,customerMap));*/
		}
		/*catch(CustomException e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}*/
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void readFileAccount()
	{
		try
		{
			newLogic.readAccount();
			//newLogic.createFile(filePath,fileName);
			//fileObj.readsFile(filePath,fileName);
			/*Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=newLogic.readFileAccounts(filePath,fileName);
			System.out.println(customerMap);
			System.out.println("Enter the Id That the Details Needed to Retrieve :");
			int inputId=scan.nextInt();
			scan.nextLine();
			System.out.println(newLogic.getCustomerDetails(inputId,customerMap));*/
		}
		/*catch(CustomException e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}*/
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void fetchCustomerStatus() throws CustomException
	{
		System.out.println("Enter the FileName to Change the Customer Details :");
		String fileName=scan.nextLine();
		System.out.println("Enter the CustomerId to Change the Customer Status :");
		int custId=scan.nextInt();
		scan.nextLine();
		newLogic.fetchCustomerStatus(custId);
	}
	private void fetchAccountStatus() throws CustomException
	{
		System.out.println("Enter the FileName to Change the Account Details :");
		String fileName=scan.nextLine();
		System.out.println("Enter the CustomerId to Change the Account Status :");
		int custId=scan.nextInt();
		System.out.println("Enter the AccountId to Change the Account Status :");
		int ActId=scan.nextInt();
		scan.nextLine();
		newLogic.fetchAccountStatus(custId,ActId);
	}

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		CustomerAccountDetails mainObj=new CustomerAccountDetails();
		int choice=0;
		System.out.println("1.GET CUSTOMER DETAILS & ACCOUNT DETAILS");
		System.out.println("2.READ CUSTOMER DETAILS & ACCOUNT DETAILS");
		System.out.println("3.GET CUSTOMER DETAILS");
		System.out.println("4.GET ACCOUNT DETAILS");
		System.out.println("5.DEPOSIT AMOUNT");
		System.out.println("6.WITHDRAW AMOUNT");
		System.out.println("7.CHANGE CUSTOMER STATUS");
		System.out.println("8.CHANGE ACCOUNT STATUS");
		//System.out.println("9.ADD NEW ACCOUNT IN A EXISTING FILE");
		System.out.println("Enter Your Choice :");
		try
		{
			choice=scan.nextInt();
			scan.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured :");
			e.printStackTrace();
		}
		
		switch(choice)
		{
					
			
				
			case 1:
			
				try
				{
					mainObj.fileCreation();
					//mainObj.readFile();
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					//mainObj.getCustomer();
					//mainObj.getAccounts();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 2:
				
				try
				{
					mainObj.readFileCustomer();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 3:
				
				try
				{
					mainObj.getCustomer();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 4:
				
				try
				{
					mainObj.getAccounts();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
				
			case 5:
				
				
				try
				{
					mainObj.depositAmount();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 6:
				
				try
				{
					mainObj.withdrawAmount();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 7:
				try
				{
					mainObj.fetchCustomerStatus();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
			
			case 8:
				try
				{
					mainObj.fetchAccountStatus();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 9:
				try
				{
					mainObj.readFileAccount();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;	
		}
		scan.close();
	}	
}



