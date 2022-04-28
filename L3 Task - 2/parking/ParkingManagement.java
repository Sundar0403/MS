package parking;
import customer.*;
import vehicle.*;
import payment.*;
import slot.*;
import logic.*;
import filled.*;
import empty.*;
import java.text.*;
import java.util.*;

public class ParkingManagement
{
	Map<Integer,CustomerDetails> vehicleMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<Integer,PaymentGateway> paymentMap=new HashMap<>();
	List<EmptySpot> emptyList=new ArrayList<>();
	List<FilledSpot> filledList=new ArrayList<>();
	
	ParkingLogic logicObj=new ParkingLogic();
	VehicleDetails vehicleObj=new VehicleDetails();
	Scanner scan=new Scanner(System.in);
	SimpleDateFormat simple=new SimpleDateFormat("h:mm:ss");
	Date date=new Date();
	long entryTime=0;
	
	//List<EmptySpot> emptyList=new ArrayList<>();
	
	private void getTicket() throws Exception
	{
		try
		{
			System.out.println("------------------- SPOT NUMBER 1 COMPACT VEHICLES ---------------------------");
			System.out.println("------------------- SPOT NUMBER 2 LARGE VEHICLES -----------------------------");
			System.out.println("------------------- SPOT NUMBER 3 HANDICAPPED VEHICLES -----------------------");
			System.out.println("------------------- SPOT NUMBER 4 MOTOR CYCLES -------------------------------");
			System.out.println("------------------- SPOT NUMBER 5 ELECTRIC VEHICLES --------------------------");
		
			int tokenId=logicObj.getTokenId();
	
			System.out.println("Enter the Vehicle Type :");
			String vehicleType=scan.nextLine();
			if(vehicleType.charAt(0)>='0'&&vehicleType.charAt(0)<='9')
			{
				throw new Exception("Enter Valid Vehicle Type");
			}
			System.out.println("Enter the Vehicle Name :");
			String vehicleName=scan.nextLine();
			int floor=0;
			
			Map<Integer,Map<String,List<EmptySpot>>> newMap=logicObj.getEmptyMapDetails();
			int count=0;
			for(int i=0;i<newMap.size();i++)
			{
				emptyList=newMap.get(i+1).get(vehicleType);
				
				System.out.println("The Number of Available Spots in the Floor "+(i+1)+" is "+emptyList.size());
				if(emptyList.size()>0 && count==0)
				{
					floor=i+1;
					count++;
				}
			}
			System.out.println(floor);	
			emptyList=logicObj.getEmptyDetails(floor,vehicleType);
			
			EmptySpot emptyObj=emptyList.get(0);
				
			FilledSpot filledObj=new FilledSpot();
			filledObj.setSpotNumber(emptyObj.getSpotNumber());
			filledObj.setVehicleType(vehicleType);
			filledObj.setFloor(floor);
			filledList=logicObj.setFilledDetails(filledObj,floor,vehicleType);
			System.out.println(filledList);
			emptyList=logicObj.removeEmpty(0,floor,vehicleType);
								
				
			
			ParkingDetails parkingObj=new ParkingDetails();
			parkingObj.setTokenId(tokenId);
			parkingObj.setSpotNumber(emptyObj.getSpotNumber());
			parkingObj.setFloor(floor);
			parkingObj.setVehicleType(vehicleType);
			
			entryTime=System.currentTimeMillis();
			parkingObj.setEntryTime(entryTime);
			parkingMap=logicObj.setSlot(tokenId,parkingObj);
			System.out.println(parkingMap);
			emptyList=newMap.get(floor).get(vehicleType);
			System.out.println(emptyList);
			System.out.println("The Spot is Booked Successfully");
		}
		catch(Exception e)
		{
			throw new Exception("There is No Parking Lot Available Now :");
		}
			
	}	
	
	public void setCustomerInfoPortal() throws Exception
	{
		System.out.println("---------------------------- REGISTER TO CUSTOMER INFO PORTAL ---------------------------------");
		CustomerDetails customerObj=new CustomerDetails();
		int customerId=logicObj.getCustomerId();
		customerObj.setCustomerId(customerId);
		
		System.out.println("Enter the Customer Name :");
		String name=scan.nextLine();
		customerObj.setCustomerName(name);
		System.out.println("Enter the Customer Address :");
		String address=scan.nextLine();
		customerObj.setCustomerAddress(address);
		System.out.println("Enter the Password :");
		String password=scan.nextLine();
		customerObj.setPassword(password);
		System.out.println("Enter the Amount to Add to Your Customer Info Wallet For Further Use :");
		double amount=scan.nextDouble();
		scan.nextLine();
		customerObj.setCustomerInfoWallet(amount);
		
		vehicleMap=logicObj.setCustomer(customerId,customerObj);
		System.out.println(vehicleMap);
	}
	
	public void getCustomerInfoPortal() throws Exception
	{
		System.out.println("------------------------------- WELCOME TO CUSTOMER INFO PORTAL ----------------------------------------");
		System.out.println("Enter the Customer Id:");
		int customerId=scan.nextInt();
		scan.nextLine();
		CustomerDetails customerObj=vehicleMap.get(customerId);
		System.out.println("Enter the Password :");
		String password=scan.nextLine();
		if(customerObj.getPassword().equals(password))
		{
			double wallet=customerObj.getCustomerInfoWallet();
			System.out.println("Enter the Amount to Add to Your Customer Info Wallet For Further Use :");
			double amount=scan.nextDouble();
			scan.nextLine();
			double add=amount+wallet;
			customerObj.setCustomerInfoWallet(add);
			
			System.out.println(vehicleMap);
		}
		else
		{
			throw new Exception(" The User Credentials Are Incorrect");
		}
	}
	
	public void exitParking() throws Exception
	{
		try
		{
			PaymentGateway paymentObj=new PaymentGateway();
			boolean success=true;
			System.out.println("Enter Token Id :");
			int tokenId=scan.nextInt();
			scan.nextLine();
			paymentObj.setTokenId(tokenId);
			System.out.println("Enter the Customer Id:");
			int customerId=scan.nextInt();
			scan.nextLine();
			
			CustomerDetails customerObj=vehicleMap.get(customerId);
			double wallet=customerObj.getCustomerInfoWallet();
			ParkingDetails parkingObj=logicObj.getParkingDetails(tokenId);
			int floor=parkingObj.getFloor();
			int spotNumber=parkingObj.getSpotNumber();
			String vehicleType=parkingObj.getVehicleType();

			long exitTime=System.currentTimeMillis();		
		
			double payableAmount=logicObj.getPayableAmount(entryTime,exitTime);
			System.out.println("The Amount Payable for The Parking is : "+payableAmount);
			
			System.out.println("Enter Payment Mode :");
			System.out.println("1.Cash");
			System.out.println("2.Card");
			String mode=scan.nextLine();
			if(mode.equals("Card"))
			{
				System.out.println("Enter the Card Number:");
				long card=scan.nextLong();
				scan.nextLine();
				if(String.valueOf(card).length()<16)
				{
					System.out.println("Card Details are Incorrect");
				}
			}
		
			double paidAmount=payableAmount-wallet;
			if(paidAmount<0)
			{
				customerObj.setCustomerInfoWallet(Math.abs(paidAmount));
			}
			if(payableAmount>wallet)
			{
				customerObj.setCustomerInfoWallet(0.0);
			}
			paymentObj.setExitTime(exitTime);
			paymentObj.setPaymentMode(mode);
			paymentObj.setPaidAmount(payableAmount);
			paymentObj.setPaymentStatus(success);
			parkingObj.setPaymentStatus(success);
			paymentMap=logicObj.processPayment(tokenId,paymentObj);
			System.out.println(paymentMap);
		
			System.out.println(parkingMap);
			System.out.println(vehicleMap);
				
			filledList=logicObj.getFilledDetails(floor,vehicleType);
			for(int i=0;i<filledList.size();i++)
			{
				FilledSpot filledObj=filledList.get(i);
				//System.out.println(emptyObj);
				if(spotNumber==filledObj.getSpotNumber())
				{
					EmptySpot emptyObj=new EmptySpot();
					emptyObj.setSpotNumber(spotNumber);
					emptyObj.setVehicleType(vehicleType);
					emptyObj.setFloor(floor);
					emptyList=logicObj.setEmptyDetails(emptyObj,floor,vehicleType);
					System.out.println(emptyList);
					filledList=logicObj.removeFilled(i,floor,vehicleType);
					break;				
				}
			}
			Map<Integer,Map<String,List<EmptySpot>>> newMap=logicObj.getEmptyMapDetails();
			System.out.println(newMap);
		}
		catch(Exception e)
		{
			throw new Exception("Unable to Process Your Request");
		}
	}
	
	public static void main(String args[])
	{
		ParkingManagement mainObj=new ParkingManagement();
		Scanner scan=new Scanner(System.in);
		
		
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("Enter your Choice :");
			int choice=scan.nextInt();
			scan.nextLine();
			System.out.println();
			System.out.println();
			System.out.println();
			switch(choice)
			{
				case 1:
					try
					{
						mainObj.getTicket();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Can't Park Your Vehicle Here"+e.getMessage());
						//e.printStackTrace();
						break;
					}
					
				case 2:
					try
					{
						System.out.println("EXISTING USER OR NOT :");
						String value=scan.nextLine();
						if(value.equals("NO"))
						{
							mainObj.setCustomerInfoPortal();
							break;
						}
						else if(value.equals("YES"))
						{
							mainObj.getCustomerInfoPortal();
							break;
						}	
						else
						{
							System.out.println("INVALID INPUT");
							break;
						}
					}
					catch(Exception e)
					{
						System.out.println("Unable to Process Your Request"+e.getMessage());
						//e.printStackTrace();
						break;
					}	
					
				case 3:
					try
					{
						mainObj.exitParking();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Can't Park Your Vehicle Here"+e.getMessage());
						//e.printStackTrace();
						break;
					}	
					
				default:
					try
					{
						flag=false;
					}
					catch(Exception e)
					{
						System.out.println("Exception Occured :"+e.getMessage());
						//e.printStackTrace();
						break;
					}		
			}
		}
	}	
}




