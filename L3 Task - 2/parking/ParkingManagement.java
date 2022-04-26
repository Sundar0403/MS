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
		CustomerDetails customerObj=new CustomerDetails();
		int tokenId=logicObj.getTokenId();
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
		
		
			
		System.out.println("Enter the Floor to Park the Car :");
		int floor=scan.nextInt();
		scan.nextLine();
		
		Map<Integer,Map<String,List<EmptySpot>>> newMap=logicObj.getEmptyMapDetails();
		//System.out.println(newMap);
		emptyList=newMap.get(floor).get(vehicleType);
		//System.out.println(emptyList);	
		
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
				emptyList.remove(emptyObj);
				break;				
			}
		}
		//logicObj.setEmptyDetails(emptyList);
	
		vehicleMap=logicObj.setCustomer(tokenId,customerObj);
		System.out.println(vehicleMap);
		
		ParkingDetails parkingObj=new ParkingDetails();
		parkingObj.setTokenId(tokenId);
		parkingObj.setSpotNumber(spotNumber);
		parkingObj.setFloor(floor);
		parkingObj.setVehicleType(vehicleType);
		
		entryTime=System.currentTimeMillis();
		//System.out.println(entryTime);
		Date date=new Date(entryTime);
		parkingObj.setEntryTime(date);
		parkingMap=logicObj.setSlot(tokenId,parkingObj);
		System.out.println(parkingMap);
		/*System.out.println(vehicleObj.floorMap.get(floor));
		System.out.println(vehicleObj.countMap.get(vehicleType));	
		System.out.println(vehicleObj.floorCountMap.get(floor).get(vehicleType));*/
	}
	
	public void exitParking()
	{
		PaymentGateway paymentObj=new PaymentGateway();
		boolean success=true;
		System.out.println("Enter Token Id :");
		int tokenId=scan.nextInt();
		scan.nextLine();
		paymentObj.setTokenId(tokenId);
		
		
		
		ParkingDetails parkingObj=logicObj.getParkingDetails(tokenId);
		int floor=parkingObj.getFloor();
		int spotNumber=parkingObj.getSpotNumber();
		String vehicleType=parkingObj.getVehicleType();

		long exitTime=System.currentTimeMillis();		
		
		double payableAmount=logicObj.getPayableAmount(entryTime,exitTime);
		System.out.println(payableAmount);

		Date date=new Date(exitTime);
		paymentObj.setExitTime(date);
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
						mainObj.exitParking();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Can't Park Your Vehicle Here"+e.getMessage());
						e.printStackTrace();
						break;
					}	
					
				case 3:
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




