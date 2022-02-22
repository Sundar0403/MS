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
				System.out.println("Enter the Id That the Details Needed to Retrieve :");
				int inputId=scan.nextInt();
				scan.nextLine();
				newLogic.getCustomerDetails(inputId/*,customerMap*/);
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
				accountObj.setAccountNumber(++newLogic.lastActNo);
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
		private AccountDetails getAccounts()
		{
			AccountDetails accountObj=new AccountDetails();
			try
			{
				System.out.println("Enter the Customer ID To Retrieve Account Details :");
				int custId=scan.nextInt();
				scan.nextLine();
				//inputMap=newLogic.getAllAccounts(custId/*,customerAccountMap*/);
				System.out.println(inputMap);
				System.out.println("Enter the Account ID to Retrieve Specific Account :");
				int actId=scan.nextInt();
				scan.nextLine();
				accountObj=newLogic.getSpecificAccount(custId,actId);
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
			return accountObj;
		}
		
	private void getAccountDetails()
	{
		AccountDetails accountObj=getAccounts();
		System.out.println(accountObj);
	}
	
	private void depositAmount()
	{
		AccountDetails deposit=new AccountDetails();
		if(deposit.isAccountStatus()==true)
		{	
			try
			{
				deposit=getAccounts();
				System.out.println(deposit);
				System.out.println("Enter the Deposit Amount : ");
				double amount=scan.nextDouble();
				scan.nextLine();
				amount=amount+deposit.getAccountBalance();
				deposit.setAccountBalance(amount);
				System.out.println(/*customerAccountMap*/deposit);
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Deposit can't be done, Beacuse it's a Deactivated Account");
		}
	}
	
	private void withdrawAmount() throws CustomException
	{
		AccountDetails withdraw=new AccountDetails();
		if(withdraw.isAccountStatus()==true)
		{
			try
			{
				withdraw=getAccounts();
				System.out.println(withdraw);
				System.out.println("Enter the Withdraw Amount : ");
				double amount=scan.nextDouble();
				scan.nextLine();
				if(amount<=withdraw.getAccountBalance())
				{
					amount=withdraw.getAccountBalance()-amount;
					withdraw.setAccountBalance(amount);
					System.out.println(/*customerAccountMap*/withdraw);
				}
				else
				{
					throw new CustomException("Insufficient Balance to Withdraw");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Withdraw can't be done, Beacuse it's a Deactivated Account");
		}
	}
	
	private void fileCreation()
	{
		try
		{
			System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			fileObj.createFile(filePath,fileName);
			fileObj.writeFile(filePath,fileName/*,customerMap,customerAccountMap*/);
			//newLogic.writeFile(filePath,fileName,customerAccountMap);
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
	private void readFile()
	{
		try
		{
			System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			//newLogic.createFile(filePath,fileName);
			fileObj.readsFile(filePath,fileName);
			/*Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=newLogic.readFileAccounts(filePath,fileName);
			System.out.println(customerMap);
			System.out.println("Enter the Id That the Details Needed to Retrieve :");
			int inputId=scan.nextInt();
			scan.nextLine();
			System.out.println(newLogic.getCustomerDetails(inputId,customerMap));*/
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

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		CustomerAccountDetails mainObj=new CustomerAccountDetails();
		int choice=0;
		System.out.println("1.GET CUSTOMER DETAILS");
		System.out.println("2.GET ACCOUNT DETAILS");
		System.out.println("3.DEPOSIT AMOUNT");
		System.out.println("4.WITHDRAW AMOUNT");
		System.out.println("5.WRITING CUSTOMER DETAILS AND ACCOUNT DETAILS IN A FILE");
		System.out.println("6.GET CUSTOMER DETAILS FROM A FILE");
		System.out.println("7.GET ACCOUNT DETAILS IN A FILE");
		System.out.println("8.ADD NEW CUSTOMER ACCOUNT IN A EXISTING FILE");
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
					mainObj.retrieveFromCustomer();
					mainObj.getCustomer();
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
				break;
					
			case 2:
				
				try
				{
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.getAccountDetails();
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
				break;
					
			case 3:
				
				try
				{
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.depositAmount();
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
				break;
					
			case 4:
				
				try
				{
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.withdrawAmount();
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
				break;
				
			case 5:
				
				try
				{
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.fileCreation();
				}
				catch(CustomException e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
					e.printStackTrace();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 6:
				
				try
				{
					mainObj.readFile();
					mainObj.getCustomer();
				}
				/*catch(CustomException e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
					e.printStackTrace();
				}*/
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 7:
				
				try
				{
					//mainObj.retrieveFromCustomer();
					mainObj.readFile();
					mainObj.getAccountDetails();
				}
				/*catch(CustomException e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
					e.printStackTrace();
				}*/
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}
				break;
				
			case 8:
				
				try
				{
					//mainObj.retrieveFromCustomer();
					//mainObj.readFileAccounts();
					//mainObj.getAccountDetails();
					mainObj.readFile();
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.fileCreation();
				}
				catch(CustomException e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
					e.printStackTrace();
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured : "+e.getMessage());
				}	
				break;
				
			case 9:
				
				try
				{
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
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





