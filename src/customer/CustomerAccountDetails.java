package customer;
import logic.*;
import account.*;
import pojo.*;
import java.util.*;

public class CustomerAccountDetails {
	CustomerLogic newLogic=new CustomerLogic();
	
	Scanner scan=new Scanner(System.in);
	
	private Map<Object,Object> retrieveFromCustomer()
	{
		Map<Object,Object> inputMap=new HashMap();
		List newList=newLogic.inputList();
		System.out.println("Enter the Number of Customers :");
		int values=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<values;i++)
		{
			CustomerDetails pojo=new CustomerDetails();
			System.out.println("Enter the Account Holder Name :");
			String name=scan.nextLine();
			pojo.setCustomerName(name);
			System.out.println("Enter the Account Holder Address :");
			String address=scan.nextLine();
			pojo.setCustomerAddress(address);
			System.out.println("Enter the Account Holder Mobile Number :");
			long mobNo=scan.nextLong();
			scan.nextLine();
			pojo.setMobileNumber(mobNo);
			//newList.add(pojo);
			Object customerId=newLogic.getId();
			//inputMap.put(customerId,newList);
			//customerId++;
			inputMap=newLogic.getMap(customerId,pojo);
		}
		return inputMap;
	}
	
	private void getCustomer()
	{
		System.out.println("Enter the Id That the Details Needed to Retrieve :");
		Object inputId=scan.nextInt();
		//scan.nextLine();
		System.out.println(newLogic.getIdDetails(inputId));
	}
	
	private void retrieveFromAccount()
	{ 
		
		Map<Object,Object> inputMap=retrieveFromCustomer();
		List newList=newLogic.inputList();
		System.out.println("Enter the Number of Accounts:");
		int values=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<values;i++)
		{
			AccountDetails pojo=new AccountDetails();
			System.out.println("Enter the Customer Id :");
			int customerId=scan.nextInt();
			scan.nextLine();
			if(inputMap.containsKey(customerId))
			{	
				pojo.setCustomerId(customerId);
				System.out.println("Enter the Account Number :");
				long accNo=scan.nextLong();
				scan.nextLine();
				pojo.setAccountNumber(accNo);
				System.out.println("Enter the Account Balance:");
				double accBalance=scan.nextDouble();
				scan.nextLine();
				pojo.setAccountBalance(accBalance);
				System.out.println("Enter the Account Maintaining Branch :");
				String branch=scan.nextLine();
				pojo.setBranchName(branch);
				//newList.add(pojo);
				Object AccountId=newLogic.getAccountId();
				//inputMap.put(customerId,newList);
				//customerId++;
				inputMap=newLogic.getMap(AccountId,pojo);
			}
			else
			{
				System.out.println("Customer Id Cannot Exist :");
			}	
		}
		System.out.println(inputMap);
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
			/*case 1:
				
					System.out.println(mainObj.retrieveFromPojo());
					break;*/
					
			case 1:
				
					System.out.println(mainObj.retrieveFromCustomer());
					mainObj.getCustomer();
					break;
					
			case 2:
				
					//mainObj.retrieveFromCustomer();
					mainObj.retrieveFromAccount();
					break;
					
			case 3:
				
					mainObj.retrieveFromAccount();
					mainObj.getCustomer();
					break;
		}
		scan.close();
	}	
}
