package customerAccount;
import customer.*;
import account.*;
import logic.*;
import admin.*;
import transactionHistory.*;
import java.text.*;
import java.util.*;

public class InternetBanking
{
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	
	String debit="DR";
	String credit="CR";
	String role="";
	Map<Integer,List<Integer>> customerAccountMap=new HashMap<>();
	Map<Integer,AccountDetails> accountMap=new HashMap<>();
	
	Map<Integer,List<TransactionHistoryDetails>> transactionMap=new HashMap<>();
	//Map<Integer,List<TransactionHistoryDetails>> transactionMap=new HashMap<>();
	
	List<TransactionHistoryDetails> transactionList=new ArrayList<>();
	Scanner scan=new Scanner(System.in);
	
	InternetBankingLogic logicObj=new InternetBankingLogic();
	
	private boolean userLogin() throws Exception
	{
		/*System.out.println("Enter the Customer Id:");
		int custId=scan.nextInt();
		scan.nextLine();*/
		
		AdminDetails adminObj=new AdminDetails();
		System.out.println("Enter the User Login Id:");
		int userId=scan.nextInt();
		scan.nextLine();
		CustomerDetails custObj=customerMap.get(userId);
		System.out.println(custObj);
		
		System.out.println("Enter the User Login Password:");
		String password=scan.nextLine();
	
		if(custObj!=null && custObj.getCustomerId()==userId && custObj.getCustomerPassword().equals(password))
		{
			/*role=adminObj.getRole();
			System.out.println(role);*/
			return true;
		}
		else if(adminObj.getAdminId()==userId && adminObj.getAdminPassword().equals(password))
		{
			role=adminObj.getRole();
			System.out.println(role);
			return true;
		}
		return true;
	}
	private void userSignUp() throws Exception
	{
		int count=0;
		String password="";
		String rePass="";
		
		CustomerDetails custObj=new CustomerDetails();
		AccountDetails accountObj=new AccountDetails();
		int custId=logicObj.getCustId();
		System.out.println(custId);
		custObj.setCustomerId(custId);
		System.out.println("Enter the Customer Name:");
		String name=scan.nextLine();
		custObj.setCustomerName(name);
		
		/*System.out.println("Enter the User Id:");
		int userId=scan.nextInt();
		scan.nextLine();
		custObj.setUserId(userId);*/
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
		System.out.println(customerMap);
		
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
	
	private void retrieveAccount() throws Exception
	{
		System.out.println("Enter the Customer Id to Receive Account Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		List<Integer> accountList=logicObj.getAllAccounts(customerId);
		
		System.out.println("Enter the Account Id to Receive Account Details");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		if(accountList.contains(accountId))
		{
			AccountDetails accountObj=logicObj.getAccount(accountId);
			System.out.println(accountObj);
		}
		else
		{
			System.out.println("Account Id Entered is Incorrect");
			throw new Exception();
		}	
	}
	
	private void retrieveCustomer() throws Exception
	{
		System.out.println("Enter the Customer Id to Receive Customer Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		CustomerDetails customerObj=logicObj.getCustomer(customerId);
		System.out.println(customerObj);
	}
	
	private void deposit() throws Exception
	{
		System.out.println("Enter the Customer Id to Receive Account Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		List<Integer> accountList=logicObj.getAllAccounts(customerId);
		
		System.out.println("Enter the Account Id to Receive Account Details");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		if(accountList.contains(accountId))
		{
			AccountDetails accountObj=logicObj.getAccount(accountId);
			System.out.println("Enter the Deposit Amount:");
			double amount=scan.nextDouble();
			scan.nextLine();
			if(amount>100&&amount<100000)
			{
				accountObj=logicObj.deposit(amount,accountObj);
			}
			else
			{
				System.out.println("Can't Deposit Now");
			}	
		}
		else
		{
			System.out.println("Account Id Entered is Incorrect");
			throw new Exception();
		}
	}
	private void withdraw() throws Exception
	{
		System.out.println("Enter the Customer Id to Receive Account Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		List<Integer> accountList=logicObj.getAllAccounts(customerId);
		
		System.out.println("Enter the Account Id to Receive Account Details");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		if(accountList.contains(accountId))
		{
			AccountDetails accountObj=logicObj.getAccount(accountId);
			System.out.println("Enter the withdraw Amount:");
			double amount=scan.nextDouble();
			scan.nextLine();
			if(accountObj.getAccountBalance()-amount>100)
			{
				accountObj=logicObj.withdraw(amount,accountObj);
			}
			else
			{
				System.out.println("Insufficient Balance to Withdraw");
			}	
		}
		else
		{
			System.out.println("Account Id Entered is Incorrect");
			throw new Exception();
		}
	}
	
	private void moneyTransfer() throws Exception
	{
		boolean result=false;
		System.out.println("Enter the Sender Customer Id to Receive Account Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		List<Integer> accountList=logicObj.getAllAccounts(customerId);
		
		System.out.println("Enter the Sender Account Id to Receive Account Details");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		double amount=0.0;
		
		if(accountList.contains(accountId))
		{
			System.out.println("Enter the Receiver Account Id to Transfer the Amount");
			int receiverAccountId=scan.nextInt();
			scan.nextLine();
			AccountDetails accountObj=logicObj.getAccount(accountId);
			System.out.println("Enter the Transfer Amount:");
			amount=scan.nextDouble();
			scan.nextLine();
			if(accountObj.getAccountBalance()-amount>100 && amount>100 && amount<100000)
			{
				accountObj=logicObj.moneyTransfer(amount,accountObj,receiverAccountId);
				System.out.println(accountObj);
				result=true;
			}
			else
			{
				System.out.println("Insufficient Balance to Withdraw");
				result=false;
			}	
		}
		else
		{
			System.out.println("Account Id Entered is Incorrect");
			throw new Exception();
		}
		TransactionHistoryDetails transactionObj=new TransactionHistoryDetails();
		transactionObj.setCustomerId(accountId);
		int transId=logicObj.getTransactionId();
		transactionObj.setTransactionId(transId);
		SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dates=new Date();
		transactionObj.setDate(date.format(dates));
		transactionObj.setTransactionType(debit);
		transactionObj.setAmount(amount);
		transactionObj.setTransactionStatus(result);
		
		transactionList.add(transactionObj);
		transactionMap=logicObj.transactionUpdate(accountId,transactionList);
	}
	
	private void balanceEnquiry() throws Exception
	{
		
		System.out.println("Enter the Account Id to Receive Account Details");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		if(!role.equals("admin"))
		{
			double accountBalance=logicObj.balanceEnquiry(accountId);
			System.out.println(accountBalance);
		}
		else
		{
			System.out.println("Enter the Customer Id to Receive Account Details");
			int customerId=scan.nextInt();
			scan.nextLine();
		
			List<Integer> accountList=logicObj.getAllAccounts(customerId);
			if(accountList.contains(accountId))
			{
				double accountBalance=logicObj.balanceEnquiry(accountId);
				System.out.println("Account Balance : "+accountBalance);
			}
			else
			{
				System.out.println("Account Id Entered is Incorrect");
				throw new Exception();
			}
		}	
	}
	
	private void getTransactionHistory() throws Exception
	{
		System.out.println("Enter the Customer Id to Receive Account Details");
		int customerId=scan.nextInt();
		scan.nextLine();
		List<TransactionHistoryDetails> transactionList=logicObj.getTransactionHistory(customerId);
		for(int i=transactionList.size()-1;i>=0;i--)
		{
			System.out.println(transactionList.get(i));
		}
		
	}
	
	private void changeAccountStatus() throws Exception
	{
		System.out.println("Enter the Customer Id to Change the Account Status : ");
		int customerId=scan.nextInt();
		scan.nextLine();
		
		List<Integer> accountList=logicObj.getAllAccounts(customerId);
		
		System.out.println("Enter the Account Id to Change the Account Status : ");
		int accountId=scan.nextInt();
		scan.nextLine();
		
		if(accountList.contains(accountId))
		{
			AccountDetails accountObj=logicObj.changeAccountStatus(accountId);
			System.out.println(accountObj);
		}
		else
		{
			System.out.println("Account Id Entered is Incorrect");
			throw new Exception();
		}
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
				count++;
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
					       e.printStackTrace();
						//System.out.println(e.printStackTrace);
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
						count++;
						break;
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :");
						break;
					}		
			}
			
		}
		//System.out.println(" Enter the Task to Process:");
		
		while(condition)
		{
			System.out.println("Enter the Task to Execute:");
			System.out.println("------------- 1 . ACCOUNT CREATION : --------------");
			System.out.println("------------- 2 . GET ACCOUNT : --------------");
			System.out.println("------------- 3 . GET CUSTOMER : --------------");
			System.out.println("------------- 4 . DEPOSIT : ---------------");
			System.out.println("------------- 5 . WITHDRAW : ---------------");
			System.out.println("------------- 6 . MONEY TRANSFER : ---------------");
			System.out.println("------------- 7 . BALANCE ENQUIRY : ---------------");
			System.out.println("------------- 8 . TRANSACTION HISTORY : ---------------");
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
						if(bankObj.role.equals("admin"))
						{
							bankObj.userSignUp();
							bankObj.accountCreation();
							break;
						}
						else
						{
							bankObj.accountCreation();
						}	
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :");
					}
					
				case 2:
					try
					{
						bankObj.retrieveAccount();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Account Retrieval Failed : "+e.getMessage());
					}
					
				case 3:
					try
					{
						bankObj.retrieveCustomer();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Customer Retrieval Failed : "+e.getMessage());
						break;
					}
					
				case 4:
					try
					{
						bankObj.deposit();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Deposit Can't be Done Now : "+e.getMessage());
						break;
					}
					
				case 5:
					try
					{
						bankObj.withdraw();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Withdraw Can't be Done Now : "+e.getMessage());
						break;
					}
					
				case 6:
					try
					{
						bankObj.moneyTransfer();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Withdraw Can't be Done Now : "+e.getMessage());
						break;
					}
					
				case 7:
					try
					{
						bankObj.balanceEnquiry();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Withdraw Can't be Done Now : "+e.getMessage());
						break;
					}
					
				case 8:
					try
					{
						bankObj.getTransactionHistory();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Withdraw Can't be Done Now : "+e.getMessage());
						break;
					}
					
				case 9:
					try
					{
						bankObj.changeAccountStatus();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Account Status Can't be Changed Now : "+e.getMessage());
						break;
					}					
					
				default:
					try
					{
						condition=false;
						break;
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :");
						break;
					}					
			}
		}
	}

}


