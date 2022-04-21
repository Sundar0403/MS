package customerAccount;
import customer.*;
import account.*;
import logic.*;
import java.util.*;

public class InternetBanking
{
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	
	
	Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
	Map<Integer,AccountDetails> accountMap=new HashMap<>();
	
	Scanner scan=new Scanner(System.in);
	
	InternetBankingLogic logicObj=new InternetBankingLogic();
	
	private boolean userLogin() throws Exception
	{
		System.out.println("Enter the Customer Id:");
		int custId=scan.nextInt();
		scan.nextLine();
		CustomerDetails custObj=customerMap.get(custId);
		System.out.println(custObj);
		System.out.println("Enter the User Login Id:");
		String userId=scan.nextLine();
		System.out.println("Enter the User Login Password:");
		String password=scan.nextLine();
		
		if(custObj.getUserId().equals(userId) && custObj.getCustomerPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	private void userSignUp() throws Exception
	{
		int count=0;
		String password="";
		String rePass="";
		CustomerDetails custObj=new CustomerDetails();
		AccountDetails accountObj=new AccountDetails();
		
		int custId=logicObj.getCustId();
		custObj.setCustomerId(custId);
		System.out.println("Enter the Customer Name:");
		String name=scan.nextLine();
		custObj.setCustomerName(name);
		
		System.out.println("Enter the User Id:");
		String userId=scan.nextLine();
		custObj.setUserId(userId);
		while(count==0)
		{
			System.out.println("Enter the User Password:");
			password=scan.nextLine();
			
			System.out.println("Re Enter the Typed Password:");
			rePass=scan.nextLine();
			if(password.equals(rePass))
			{
				count++;
			}
			else
			{
				System.out.println("Password Mismatch");
			}
		}
		custObj.setCustomerPassword(password);
		customerMap=logicObj.userSignUp(custId,custObj);
		
		System.out.println("The Details are entered Successfully:");	
		
		
		accountObj.setCustomerId(custId);
		int accountId=logicObj.getAccountId();
		accountObj.setAccountId(accountId);
		System.out.println();
		System.out.println("Enter the Branch Details");
		String branch=scan.nextLine();
		accountObj.setBranch(branch);
		
		List<Integer> accountList=new ArrayList<>();
		accountMap=logicObj.userAccount(accountId,accountObj);
		accountList.add(accountId);
		customerAccountMap=logicObj.customerAccount(custId,accountList);
		System.out.println(customerAccountMap);
		
	}
	private void accountCreation() throws Exception
	{
		AccountDetails accountObj=new AccountDetails();
		System.out.println("Enter the User Id:");
		int customerId=scan.nextInt();
		scan.nextLine();
		accountObj.setCustomerId(customerId);
		int accountId=logicObj.getAccountId();
		accountObj.setAccountId(accountId);
		
		System.out.println("Enter the Branch Details");
		String branch=scan.nextLine();
		accountObj.setBranch(branch);
		
		List<Integer> accountList=customerAccountMap.get(customerId);
		accountMap=logicObj.userAccount(accountId,accountObj);
		accountList.add(accountId);
		customerAccountMap=logicObj.customerAccount(customerId,accountList);
		System.out.println(customerAccountMap);
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		InternetBanking bankObj=new InternetBanking();
		boolean flag=true;
		boolean condition=false;
		int choice=0;
		int count=0;
		int innerChoice=0;
		int i=0;
		
		System.out.println("-------------1 . EXISTING USER LOG-IN ------------------");
		System.out.println("-------------2 . NEW USER SIGN-UP ------------------");
		while(count==0)
		{
			System.out.println("Enter the Task to Execute:");
			try
			{
				choice=scan.nextInt();
				scan.nextLine();
			}
			catch(Exception e)
			{
				System.out.println("Enter Valid Input");
			}
			switch(choice)
			{
				case 1:
					try
					{
						condition=bankObj.userLogin();
						if(condition==true)
						{
							count++;
						}
						break;
					}
					catch(Exception e)
					{
						System.out.println("Cant Login Now");
						break;
					}
				
				case 2:
					try
					{
						bankObj.userSignUp();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Cant SignUp Now");
						break;
					}	
					
				default:
					try
					{
						flag=false;
						break;
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :");
						break;
					}		
			}
			
		}
		System.out.println(" Enter the Task to Process:");
		System.out.println("------------- 1 . ACCOUNT CREATION : --------------");
		System.out.println("------------- 2 . ACCOUNT DEPOSIT : --------------");
		System.out.println("------------- 3 . ACCOUNT WITHDRAW : --------------");
		while(condition)
		{
			System.out.println("Enter the Task to Execute:");
			try
			{
				innerChoice=scan.nextInt();
				scan.nextLine();
			}
			catch(Exception e)
			{
				System.out.println("Enter Valid Input");
			}
			switch(innerChoice)
			{
				case 1:
					try
					{
						bankObj.accountCreation();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :");
					}		
			}
		}
	}

}


