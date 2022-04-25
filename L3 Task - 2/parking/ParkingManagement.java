package parking;
import customer.*;
import vehicle.*;
import payment.*;
import slot.*;
import logic.*;
import java.text.*;
import java.util.*;

public class ParkingManagement
{
	Map<Integer,CustomerDetails> vehicleMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<Integer,PaymentGateway> paymentMap=new HashMap<>();
	
	ParkingLogic logicObj=new ParkingLogic();
	VehicleDetails vehicleObj=new VehicleDetails();
	Scanner scan=new Scanner(System.in);
	SimpleDateFormat simple=new SimpleDateFormat("h:mm:ss");
		Date date=new Date();
	
	private void getTicket() throws Exception
	{
		CustomerDetails customerObj=new CustomerDetails();
		int tokenId=logicObj.getTokenId();
		customerObj.setTokenId(tokenId);
		System.out.println("Enter the Vehicle Type :");
		String vehicleType=scan.nextLine();
		customerObj.setVehicleType(vehicleType);
		System.out.println("Enter the Vehicle Name :");
		String vehicleName=scan.nextLine();
		customerObj.setVehicleName(vehicleName);
		vehicleMap=logicObj.setCustomer(tokenId,customerObj);
		System.out.println(vehicleMap);
		
		ParkingDetails parkingObj=new ParkingDetails();
		parkingObj.setTokenId(tokenId);
		int floor=0;
		int i=1;
		while(i<2)
		{
			System.out.println("Enter the Floor to Park the Car :");
			floor=scan.nextInt();
			scan.nextLine();
			int floorCount=vehicleObj.floorMap.get(floor);
			int vehicleCount=vehicleObj.countMap.get(vehicleType);
			if(floorCount>0 && vehicleCount>0)
			{
				--floorCount;
				--vehicleCount;
				vehicleObj.floorMap.put(floor,floorCount);
				vehicleObj.countMap.put(vehicleType,vehicleCount);
				i++;
			}
			else
			{
				throw new Exception("The Floor Does Not Contains Capacity");
			}
		}
		parkingObj.setFloor(floor);
		parkingObj.setVehicleType(vehicleType);
		
		long entryTime=System.currentTimeMillis();
		System.out.println(entryTime);
		Date date=new Date(entryTime);
		parkingObj.setEntryTime(date);
		parkingMap=logicObj.setSlot(tokenId,parkingObj);
		System.out.println(parkingMap);
		System.out.println(vehicleObj.floorMap.get(floor));
		System.out.println(vehicleObj.countMap.get(vehicleType));	
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
		
		int floorCount=vehicleObj.floorMap.get(parkingObj.getFloor());

		int vehicleCount=vehicleObj.countMap.get(parkingObj.getVehicleType());

		//String entry=parkingObj.getEntryTime();

		//int index=entry.lastIndexOf(":");
		int entryTime=Integer.parseInt(entry.substring(index+1));
		SimpleDateFormat simple=new SimpleDateFormat("h:mm:ss");
		Date date=new Date();
		paymentObj.setExitTime(simple.format(date));
		String exit=paymentObj.getExitTime();
		
		int exitTime=Integer.parseInt(exit.substring(index+1));

		int diff=0;
		diff=Math.abs(exitTime-entryTime);
		int value=diff/3;

		double payableAmount=0.0;
		for(int i=0;i<value;i++)
		{
			if(i==0)
			{
				payableAmount=4.0;
			}
			if(i==1 || i==2)
			{
				payableAmount+=3.5;
			}
			if(i>2)
			{
				payableAmount+=2.5;
			}
		}

		paymentObj.setPaidAmount(payableAmount);
		paymentObj.setPaymentStatus(success);
		parkingObj.setPaymentStatus(success);
		paymentMap=logicObj.processPayment(tokenId,paymentObj);
		System.out.println(paymentMap);
		
		vehicleObj.floorMap.put(parkingObj.getFloor(),++floorCount);
		vehicleObj.countMap.put(parkingObj.getVehicleType(),++vehicleCount);
		parkingMap.remove(tokenId);
		System.out.println(parkingMap);
		
	}
	
	public static void main(String args[])
	{
		ParkingManagement mainObj=new ParkingManagement();
		Scanner scan=new Scanner(System.in);
		
		
		boolean flag=true;
		
		while(flag==true)
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
						/*mainObj.exitParking();*/
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




