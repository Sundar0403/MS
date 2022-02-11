package customer;
import excep.*;
import logic.*;
import account.*;
import pojo.*;
import java.util.*;

public class CustomerAccountDetails {
	CustomerLogic newLogic=new CustomerLogic();
	
	Scanner scan=new Scanner(System.in);
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,AccountDetails> inputMap=new HashMap<>();
	Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=new HashMap<>();
	
	private void retrieveFromCustomer()
	{
		System.out.println("Enter the Number of Customers :");
		int values=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<values;i++)
		{
			CustomerDetails customerObj=new CustomerDetails();
			int customerId=newLogic.getId();
			customerObj.setCustomerId(customerId);
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
			customerMap=newLogic.addCustomer(customerObj,customerId);
		}
		System.out.println(customerMap);
	}
	
	private void getCustomer()
	{
		try
		{
			System.out.println("Enter the Id That the Details Needed to Retrieve :");
			int inputId=scan.nextInt();
			scan.nextLine();
			System.out.println(newLogic.getCustomerDetails(inputId,customerMap));
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
	
	private void retrieveFromAccount()
	{ 
		
		System.out.println("Enter the Number of Accounts:");
		int values=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<values;i++)
		{
			AccountDetails accountObj=new AccountDetails();
			int accountId=newLogic.getAccountId();
			accountObj.setAccountId(accountId);
			System.out.println("Enter the Customer Id :");
			int customerId=scan.nextInt();
			scan.nextLine();	
			accountObj.setCustomerId(customerId);
			long accNo=newLogic.getAccountNo();
			accountObj.setAccountNumber(accNo);
			System.out.println("Enter the Account Balance:");
			double accBalance=scan.nextDouble();
			scan.nextLine();
			accountObj.setAccountBalance(accBalance);
			System.out.println("Enter the Account Maintaining Branch :");
			String branch=scan.nextLine();
			accountObj.setBranchName(branch);
			try
			{
				customerAccountMap=newLogic.addAccount(accountObj,customerId,accountId);
			}
			catch(CustomException e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured : "+e.getMessage());
			}
		}
	
		System.out.println(customerAccountMap);
	}
		private AccountDetails getAccounts()
		{
			AccountDetails accountObj=new AccountDetails();
			try
			{
				System.out.println("Enter the Customer ID To Retrieve Account Details :");
				int custId=scan.nextInt();
				scan.nextLine();
				inputMap=newLogic.getAllAccounts(custId);
				System.out.println(inputMap);
				System.out.println("Enter the Account ID to Retrieve Specific Account :");
				int actId=scan.nextInt();
				scan.nextLine();
				accountObj=newLogic.getSpecificAccount(custId,actId);
				System.out.println(accountObj);
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
	
	private void depositAmount()
	{
		try
		{
			AccountDetails deposit=getAccounts();
			System.out.println(deposit);
			System.out.println("Enter the Deposit Amount : ");
			double amount=scan.nextDouble();
			scan.nextLine();
			amount=amount+deposit.getAccountBalance();
			deposit.setAccountBalance(amount);
			System.out.println(customerAccountMap);
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void withdrawAmount()
	{
		try
		{
			AccountDetails withdraw=getAccounts();
			System.out.println(withdraw);
			System.out.println("Enter the Withdraw Amount : ");
			double amount=scan.nextDouble();
			scan.nextLine();
			amount=withdraw.getAccountBalance()-amount;
			withdraw.setAccountBalance(amount);
			System.out.println(customerAccountMap);
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
				
					mainObj.retrieveFromCustomer();
					mainObj.getCustomer();
					break;
					
			case 2:
				
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.getAccounts();
					break;
					
			case 3:
				
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.depositAmount();
					break;
					
			case 4:
				
					mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					mainObj.withdrawAmount();
					break;
		}
		scan.close();
	}	
}





