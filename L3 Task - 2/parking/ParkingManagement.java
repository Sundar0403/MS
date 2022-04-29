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
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<String,VehicleDetails> vehicleMap=new HashMap<>();
	List<Spot> emptyList=new ArrayList<>();
	List<Spot> filledList=new ArrayList<>();
	
	ParkingLogic logicObj=new ParkingLogic();
	Scanner scan=new Scanner(System.in);
	SimpleDateFormat simple=new SimpleDateFormat("h:mm:ss");
	Date date=new Date();
	long entryTime=0;
	
	//List<EmptySpot> emptyList=new ArrayList<>();
	
	private void getTicket() throws Exception
	{
		try
		{
			System.out.println("ENTER YOUR VEHICLE TYPE FROM THE GIVEN BELOW TYPES :");
			System.out.println("------------------- Compact ---------------------------");
			System.out.println("------------------- Large -----------------------------");
			System.out.println("------------------- Handicapped -----------------------");
			System.out.println("------------------- Motor Cycle -------------------------------");
			System.out.println("------------------- Electric Vehicle --------------------------");
		
			int tokenId=logicObj.getTokenId();
	
			System.out.println("Enter the Vehicle Type :");
			String vehicleType=scan.nextLine();
			if(vehicleType.charAt(0)>='0'&&vehicleType.charAt(0)<='9')
			{
				throw new Exception("Enter Valid Vehicle Type");
			}
;
			System.out.println("Enter the Vehicle Number :");
			String vehicleNumber=scan.nextLine();
			int floor=0;
			
			Map<Integer,Map<String,List<Spot>>> newMap=logicObj.getEmptyMapDetails();
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
			//System.out.println(floor);	
			emptyList=logicObj.getEmptyDetails(floor,vehicleType);
			
			Spot emptyObj=emptyList.get(0);
				
			Spot filledObj=new Spot();
			filledObj.setSpotNumber(emptyObj.getSpotNumber());
			filledObj.setVehicleType(vehicleType);
			filledObj.setFloor(floor);
			filledList=logicObj.setFilledDetails(tokenId,filledObj);
			System.out.println();
			//System.out.println(filledList);
			emptyList=logicObj.removeEmpty(0,floor,vehicleType);
								
				
			
			ParkingDetails parkingObj=new ParkingDetails();
			parkingObj.setTokenId(tokenId);
			parkingObj.setSpotNumber(emptyObj.getSpotNumber());
			parkingObj.setFloor(floor);
			parkingObj.setVehicleType(vehicleType);
			parkingObj.setVehicleNumber(vehicleNumber);
			
			entryTime=System.currentTimeMillis();
			parkingObj.setEntryTime(entryTime);
			parkingMap=logicObj.setSlot(tokenId,parkingObj);
			System.out.println("-----------------------------");
			System.out.println("TOKEN-ID        : "+parkingObj.getTokenId());
			System.out.println("FLOOR-NO        : "+parkingObj.getFloor());
			System.out.println("VEHICLE-TYPE    : "+parkingObj.getVehicleType());
			System.out.println("VEHICLE-NUMBER  : "+parkingObj.getVehicleNumber());
			System.out.println("SPOT-NUMBER     : "+parkingObj.getSpotNumber());
			System.out.println("-----------------------------");
			//System.out.println(parkingMap);
			//emptyList=newMap.get(floor).get(vehicleType);
			//System.out.println(emptyList);
			
			System.out.println();
			//System.out.println(newMap);
			
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
		
		
		int customerId=logicObj.getCustomerId();
		VehicleDetails vehicleObj=new VehicleDetails();
		System.out.println(" Enter Your Vehicle Number ");
		String vehicleNumber=scan.nextLine();
		System.out.println(" Enter Your Vehicle Type ");
		String vehicleType=scan.nextLine();
		
		
		vehicleObj.setVehicleNumber(vehicleNumber);
		vehicleObj.setVehicleType(vehicleType);
		vehicleObj.setCustomerId(customerId);
		vehicleMap=logicObj.setVehicle(vehicleNumber,vehicleObj);
		//System.out.println(vehicleMap);
		CustomerDetails customerObj=new CustomerDetails();
		
		//int customerId=vehicleObj.getCustomerId();
		customerObj.setCustomerId(customerId);
		
		System.out.println("Enter the Customer Name :");
		String name=scan.nextLine();
		customerObj.setCustomerName(name);
		System.out.println("Enter the Customer Mobile Number :");
		long mobNo=scan.nextLong();
		scan.nextLine();
		customerObj.setCustomerMobileNo(mobNo);

		System.out.println("Enter the Amount to Add to Your Customer Info Wallet For Further Use :");
		double amount=scan.nextDouble();
		scan.nextLine();
		customerObj.setCustomerInfoWallet(amount);
		
		customerMap=logicObj.setCustomer(customerId,customerObj);
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("*CUSTOMER-ID        : "+customerObj.getCustomerId());
		System.out.println("*CUSTOMER-NAME      : "+customerObj.getCustomerName());
		System.out.println("*MOBILENUMBER       : "+customerObj.getCustomerMobileNo());
		System.out.println("*WALLET BALANCE     : $"+customerObj.getCustomerInfoWallet());
		System.out.println("----------------------------------");
	}
	
	public void getCustomerInfoPortal() throws Exception
	{
		try
		{
			System.out.println("------------------------------- WELCOME TO CUSTOMER INFO PORTAL ----------------------------------------");
			System.out.println("Enter the Vehicle Number ");
			String vehicleNumber=scan.nextLine();
		
			VehicleDetails vehicleObj=logicObj.getVehicleDetails(vehicleNumber);
			if(vehicleObj==null)
			{
				throw new Exception(" The User Credentials Are Incorrect");
			}
			
			int customerId=vehicleObj.getCustomerId();
			
			CustomerDetails customerObj=logicObj.getCustomer(customerId);
			System.out.println("WELCOME "+customerObj.getCustomerName()+"!");
				
			double wallet=customerObj.getCustomerInfoWallet();
			System.out.println("Enter the Amount to Add to Your Customer Info Wallet For Further Use :");
			double amount=scan.nextDouble();
			scan.nextLine();
			double add=amount+wallet;
			customerObj.setCustomerInfoWallet(add);
					
			System.out.println(customerMap);
		}
		catch(Exception e)
		{
			throw new Exception("Error Occured");
		}
			
	}
	
	public void exitParking() throws Exception
	{
		try
		{
			boolean success=true;
			System.out.println("Enter Token Id :");
			int tokenId=scan.nextInt();
			scan.nextLine();
			ParkingDetails parkingObj=logicObj.getParkingDetails(tokenId);
			
			long entryTime=parkingObj.getEntryTime();
			int floor=parkingObj.getFloor();
			int spotNumber=parkingObj.getSpotNumber();
			String vehicleType=parkingObj.getVehicleType();
			String vehicleNumber=parkingObj.getVehicleNumber();
			
			VehicleDetails vehicleObj=logicObj.getVehicleDetails(vehicleNumber);
			int customerId=vehicleObj.getCustomerId();
			
			CustomerDetails customerObj=logicObj.getCustomer(customerId);


			double wallet=customerObj.getCustomerInfoWallet();
			long exitTime=System.currentTimeMillis();		
		
			double payableAmount=logicObj.getPayableAmount(entryTime,exitTime);
			System.out.println("The Amount Payable for The Parking is : "+payableAmount);
			System.out.println("The Amount In Customer Info Wallet is : "+wallet);
			
			if(payableAmount<wallet)
			{
				double paidAmount=payableAmount-wallet;
				customerObj.setCustomerInfoWallet(Math.abs(paidAmount));
				parkingObj.setPaidAmount(payableAmount);
			}
			else
			{
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
			System.out.println("Enter the Amount to Pay :");
			double pay=scan.nextDouble();
			scan.nextLine();
			double paidAmount=pay+wallet;
			
			if(payableAmount>wallet)
			{
				customerObj.setCustomerInfoWallet(0.0);
			}
			
			parkingObj.setPaidAmount(paidAmount);
			}
			

			parkingObj.setPaymentStatus(success);
			parkingMap=logicObj.setSlot(tokenId,parkingObj);
			System.out.println();
			System.out.println(parkingMap);
		
			customerMap=logicObj.setCustomer(customerId,customerObj);
			System.out.println();
			System.out.println("After Payment the Available Balance in Wallet is : "+customerObj.getCustomerInfoWallet());
			System.out.println(customerMap);
				
			filledList=logicObj.getFilledDetails(tokenId);
			for(int i=0;i<filledList.size();i++)
			{
				Spot filledObj=filledList.get(i);
				//System.out.println(emptyObj);
				if(spotNumber==filledObj.getSpotNumber())
				{
					Spot emptyObj=new Spot();
					emptyObj.setSpotNumber(spotNumber);
					emptyObj.setVehicleType(vehicleType);
					emptyObj.setFloor(floor);
					emptyList=logicObj.setEmptyDetails(emptyObj,floor,vehicleType);
					System.out.println();
					System.out.println(emptyList);
					filledList=logicObj.removeFilled(i,tokenId);
					break;				
				}
			}
			Map<Integer,Map<String,List<Spot>>> newMap=logicObj.getEmptyMapDetails();
			System.out.println(newMap);
			
			System.out.println();
			System.out.println();
			System.out.println("THANKS FOR COMING VISIT AGAIN.......");
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
			System.out.println();
			System.out.println();
			
			System.out.println("----------------------- 1.ENTRY & PARK THE VEHICLES -----------------------");
			System.out.println("----------------------- 2.CUSTOMER INFO PORTAL ----------------------------");
			System.out.println("----------------------- 3.PAY & EXIT FROM THE LOT -------------------------");
			
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
						System.out.println("-------- YES ---------");
						System.out.println("--------- NO ---------");
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




