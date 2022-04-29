package cache;
import customer.*;
import empty.*;
import filled.*;
import slot.*;
import payment.*;
import vehicle.*;
import java.util.*;

public class CacheLayer
{
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<String,VehicleDetails> vehicleMap=new HashMap<>();
	Scanner scan=new Scanner(System.in);
	
	List<Spot> filledList=new ArrayList<>();
	Map<String,List<Spot>> spotMap=new HashMap<>();
	Map<Integer,Map<String,List<Spot>>> spotSetMap=new HashMap<>();
	Map<Integer,List<Spot>> filledMap=new HashMap<>();

	int count=0;
	List<Spot> newList=new ArrayList<>();
	public CacheLayer()
	{
		System.out.println("Enter the Number of Floors :");
		int floor=scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the Number of Spots :");
		int spots=scan.nextInt();
		scan.nextLine();
		if(spots<5)
		{
			System.out.println("Minimum Spots should be 5");
			spots=5;
		}
		int n=spots/5;
		int arr[]=new int[5];
		int sum=0;
		for(int i=0;i<5;i++)
		{
			sum=sum+n;
			arr[i]=sum;
		}
		if(count==0)
		{
			
			
			for(int i=1;i<=floor;i++)
			{
				
				
				for(int j=1;j<=spots;j++)
				{
					
				Spot emptyObj=new Spot();
					emptyObj.setSpotNumber(j);
					emptyObj.setFloor(i);
				
				   spotMap=spotSetMap.get(i);
					if(spotMap==null)
					{
						spotMap=new HashMap<>();
						spotSetMap.put(i,spotMap);
					}
				
					
					if(j<=arr[0])
					{
						
						
						newList=spotMap.get("Compact");
						if(newList==null)
						{
							newList=new ArrayList<>();
							spotMap.put("Compact",newList);
						}

						emptyObj.setVehicleType("Compact");
						
						newList.add(emptyObj);

					}
					
					else if(j<=arr[1])
					{
						newList=spotMap.get("Large");
						if(newList==null)
						{
							newList=new ArrayList<>();
							spotMap.put("Large",newList);
						}

						emptyObj.setVehicleType("Large");
	
						newList.add(emptyObj);

					}
					
					else if(j<=arr[2])
					{
						newList=spotMap.get("Handicapped");
						if(newList==null)
						{
							newList=new ArrayList<>();
							spotMap.put("Handicapped",newList);
						}

						emptyObj.setVehicleType("Handicapped");
						newList.add(emptyObj);

					}
					
					else if(j<=arr[3])
					{
						
						newList=spotMap.get("Motor Cycle");
						if(newList==null)
						{
							newList=new ArrayList<>();
							spotMap.put("Motor Cycle",newList);
						}
						emptyObj.setVehicleType("Motor Cycle");
						newList.add(emptyObj);
					}
					
					else if(j<=spots)
					{
						newList=spotMap.get("Electric Vehicle");
						if(newList==null)
						{
							newList=new ArrayList<>();
							spotMap.put("Electric Vehicle",newList);
						}
						emptyObj.setVehicleType("Electric Vehicle");
						newList.add(emptyObj);
					}
					
					
				}	
			}
			count++;
			//System.out.println(spotSetMap);
		}
		
	}	
	
	public List<Spot> removeEmpty(int i,int floor,String vehicleType) throws Exception
	{
		spotMap=spotSetMap.get(floor);
		newList=spotMap.get(vehicleType);
		newList.remove(i);
		//System.out.println(newList);
		return newList;
	}
	
	public Map<Integer,Map<String,List<Spot>>> getEmptyMap1() throws Exception
	{
		return spotSetMap;
	} 
	
	public Map<String,VehicleDetails> setVehicle(String vehicleNumber,VehicleDetails vehicleObj) throws Exception
	{
		vehicleMap.put(vehicleNumber,vehicleObj);
		return vehicleMap;
	}
	
	public VehicleDetails getVehicleDetails(String vehicleNumber) throws Exception
	{
		VehicleDetails vehicleObj=vehicleMap.get(vehicleNumber);
		return vehicleObj;
	}
	
	public CustomerDetails getCustomer(int customerId) throws Exception
	{
		CustomerDetails customerObj=customerMap.get(customerId);
		return customerObj;
	}
	
	public double getPayableAmount(long entryTime,long exitTime) throws Exception
	{
		double payable=0.0;
		long entry=entryTime/(1000);
		long exit=exitTime/(1000);
		
		long diff=0;
		diff=Math.abs(entry-exit);
		long value=diff/3;
		System.out.println(value);

		double payableAmount=0.0;
		for(long i=0;i<value;i++)
		{
			if(i==0)
			{
				payable=4.0;
			}
			if(i==1 || i==2)
			{
				payable+=3.5;
			}
			if(i>2)
			{
				payable+=2.5;
			}
		}
		return payable;
	}
	
	public List<Spot> getFilledDetails(int tokenId) throws Exception
	{
		filledList=filledMap.get(tokenId);
		return filledList;
	}
	public List<Spot> getEmptyDetails(int floor,String vehicleType) throws Exception
	{
		spotMap=spotSetMap.get(floor);
		newList=spotMap.get(vehicleType);
		return newList;
	}
	public List<Spot> setFilledDetails(int tokenId,Spot filledObj) throws Exception
	{
		filledList=filledMap.get(tokenId);
		if(filledList==null)
		{
			filledList=new ArrayList<>();
			filledMap.put(tokenId,filledList);
		}
		filledList.add(filledObj);
		return filledList;
	}
	public List<Spot> setEmptyDetails1(Spot emptyObj,int floor,String vehicleType) throws Exception
	{
		spotMap=spotSetMap.get(floor);
		newList=spotMap.get(vehicleType);
		newList.add(emptyObj);
		return newList;
	}
	public List<Spot> removeFilled(int i,int tokenId)
	{
		filledList=filledMap.get(tokenId);
		filledList.remove(i);
		return filledList;
	}
	
	public Map<Integer,CustomerDetails> setCustomer(int tokenId,CustomerDetails customerObj) throws Exception
	{
		customerMap.put(tokenId,customerObj);
		return customerMap;
	}
	
	public Map<Integer,ParkingDetails> setSlot(int tokenId,ParkingDetails parkingObj) throws Exception
	{
		parkingMap.put(tokenId,parkingObj);
		return parkingMap;
	}
	
	public ParkingDetails getParkingDetails(int tokenId) throws Exception
	{
		ParkingDetails parkingObj=parkingMap.get(tokenId);
		return parkingObj;
	}
	
	/*public Map<Integer,PaymentGateway> processPayment(int tokenId,PaymentGateway paymentObj)
	{
		paymentMap.put(tokenId,paymentObj);
		return paymentMap;
	}*/
}
