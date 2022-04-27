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
		System.out.println("------------------- SPOT NUMBER 1 TO 2 COMPACT VEHICLES ----------------------");
		System.out.println("------------------- SPOT NUMBER 3 TO 4 LARGE VEHICLES ----------------------");
		System.out.println("------------------- SPOT NUMBER 5 TO 6 HANDICAPPED VEHICLES ----------------------");
		System.out.println("------------------- SPOT NUMBER 7 TO 8 MOTOR CYCLES ----------------------");
		System.out.println("------------------- SPOT NUMBER 9 TO 10 ELECTRIC VEHICLES ----------------------");
		
		int tokenId=logicObj.getTokenId();
		System.out.println("Enter the Spot Number :");
		int spotNumber=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Vehicle Type :");
		String vehicleType=scan.nextLine();
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
				floor++;
				count++;
			}
		}
		System.out.println(floor);	
		emptyList=newMap.get(floor).get(vehicleType);
		for(int i=0;i<emptyList.size();i++)
		{
			EmptySpot emptyObj=emptyList.get(i);
			//System.out.println(emptyObj);
			if(emptyObj.getFloor()==floor && emptyObj.getVehicleType().equals(vehicleType) && spotNumber==emptyObj.getSpotNumber())
			{
				FilledSpot filledObj=new FilledSpot();
				filledObj.setSpotNumber(spotNumber);
				filledObj.setVehicleType(vehicleType);
				filledObj.setFloor(floor);
				filledList=logicObj.setFilledDetails(filledObj);
				System.out.println(filledList);
				emptyList=logicObj.removeEmpty(i,floor,vehicleType);
				break;				
			}
			else
			{
				throw new Exception("Sorry Unable to Book Your Slot");
			}
		}
		
		ParkingDetails parkingObj=new ParkingDetails();
		parkingObj.setTokenId(tokenId);
		parkingObj.setSpotNumber(spotNumber);
		parkingObj.setFloor(floor);
		parkingObj.setVehicleType(vehicleType);
		
		entryTime=System.currentTimeMillis();
		parkingObj.setEntryTime(entryTime);
		parkingMap=logicObj.setSlot(tokenId,parkingObj);
		System.out.println(parkingMap);
		emptyList=newMap.get(floor).get(vehicleType);
		System.out.println(emptyList);
	
	}
	
	public void customerInfoPortal() throws Exception
	{
		System.out.println("---------------------------- WELCOME TO CUSTOMER INFO PORTAL ---------------------------------");
		CustomerDetails customerObj=new CustomerDetails();
		System.out.println("Enter the Token Id :");
		int tokenId=scan.nextInt();
		scan.nextLine();
		customerObj.setTokenId(tokenId);
		System.out.println("Enter the Spot Number :");
		int spotNumber=scan.nextInt();
		scan.nextLine();
		customerObj.setSpotNumber(spotNumber);
		System.out.println("Enter the Vehicle Type :");
		String vehicleType=scan.nextLine();
		customerObj.setVehicleType(vehicleType);
		System.out.println("Enter the Vehicle Name :");
		String vehicleName=scan.nextLine();
		customerObj.setVehicleName(vehicleName);
		System.out.println("Enter the Amount to Add to Your Customer Info Wallet For Further Use :");
		double amount=scan.nextDouble();
		scan.nextLine();
		customerObj.setCustomerInfoWallet(amount);
		
		vehicleMap=logicObj.setCustomer(tokenId,customerObj);
		System.out.println(vehicleMap);
	}
	
	public void exitParking()
	{
		PaymentGateway paymentObj=new PaymentGateway();
		boolean success=true;
		System.out.println("Enter Token Id :");
		int tokenId=scan.nextInt();
		scan.nextLine();
		paymentObj.setTokenId(tokenId);
		
		
		CustomerDetails customerObj=vehicleMap.get(tokenId);
		double wallet=customerObj.getCustomerInfoWallet();
		ParkingDetails parkingObj=logicObj.getParkingDetails(tokenId);
		int floor=parkingObj.getFloor();
		int spotNumber=parkingObj.getSpotNumber();
		String vehicleType=parkingObj.getVehicleType();

		long exitTime=System.currentTimeMillis();		
		
		double payableAmount=logicObj.getPayableAmount(entryTime,exitTime);
		System.out.println(payableAmount);
		
		paymentObj.setExitTime(exitTime);
		paymentObj.setPaidAmount(payableAmount);
		paymentObj.setPaymentStatus(success);
		parkingObj.setPaymentStatus(success);
		paymentMap=logicObj.processPayment(tokenId,paymentObj);
		System.out.println(paymentMap);
		
		System.out.println(parkingMap);
		
		filledList=logicObj.getFilledDetails();
		for(int i=0;i<filledList.size();i++)
		{
			FilledSpot filledObj=filledList.get(i);
			//System.out.println(emptyObj);
			if(filledObj.getFloor()==floor && filledObj.getVehicleType().equals(vehicleType) && spotNumber==filledObj.getSpotNumber())
			{
				EmptySpot emptyObj=new EmptySpot();
				emptyObj.setSpotNumber(spotNumber);
				emptyObj.setVehicleType(vehicleType);
				emptyObj.setFloor(floor);
				emptyList=logicObj.setEmptyDetails(emptyObj);
				System.out.println(emptyList);
				filledList=logicObj.removeFilled(filledObj);
				break;				
			}
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
						e.printStackTrace();
						break;
					}
					
				case 2:
					try
					{
						mainObj.customerInfoPortal();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Unable to Process Your Request"+e.getMessage());
						e.printStackTrace();
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
						e.printStackTrace();
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
						e.printStackTrace();
						break;
					}		
			}
		}
	}	
}




