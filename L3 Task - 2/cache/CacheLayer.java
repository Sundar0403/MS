package cache;
import customer.*;
import empty.*;
import filled.*;
import slot.*;
import payment.*;
import java.util.*;

public class CacheLayer
{
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<Integer,PaymentGateway> paymentMap=new HashMap<>();
	Scanner scan=new Scanner(System.in);
	
	List<FilledSpot> filledList=new ArrayList<>();
	Map<String,List<EmptySpot>> emptyMap=new HashMap<>();
	Map<Integer,Map<String,List<EmptySpot>>> emptySetMap=new HashMap<>();
	int count=0;
	List<EmptySpot> newList=new ArrayList<>();
	public CacheLayer()
	{
		System.out.println("Enter the Number of Floors :");
		int floor=scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the Number of Spots :");
		int spots=scan.nextInt();
		scan.nextLine();
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
					
				EmptySpot emptyObj=new EmptySpot();
					emptyObj.setSpotNumber(j);
					emptyObj.setFloor(i);
				
				   emptyMap=emptySetMap.get(i);
					if(emptyMap==null)
					{
						emptyMap=new HashMap<>();
						emptySetMap.put(i,emptyMap);
					}
				
					
					if(j<=arr[0])
					{
						
						
						newList=emptyMap.get("Compact");
						if(newList==null)
						{
							newList=new ArrayList<>();
							emptyMap.put("Compact",newList);
						}

						emptyObj.setVehicleType("Compact");
						
						newList.add(emptyObj);

					}
					
					else if(j<=arr[1])
					{
						newList=emptyMap.get("Large");
						if(newList==null)
						{
							newList=new ArrayList<>();
							emptyMap.put("Large",newList);
						}

						emptyObj.setVehicleType("Large");
	
						newList.add(emptyObj);

					}
					
					else if(j<=arr[2])
					{
						newList=emptyMap.get("Handicapped");
						if(newList==null)
						{
							newList=new ArrayList<>();
							emptyMap.put("Handicapped",newList);
						}

						emptyObj.setVehicleType("Handicapped");
						newList.add(emptyObj);

					}
					
					else if(j<=arr[3])
					{
						
						newList=emptyMap.get("Motor Cycle");
						if(newList==null)
						{
							newList=new ArrayList<>();
							emptyMap.put("Motor Cycle",newList);
						}
						emptyObj.setVehicleType("Motor Cycle");
						newList.add(emptyObj);
					}
					
					else if(j<=spots)
					{
						newList=emptyMap.get("Electric Vehicle");
						if(newList==null)
						{
							newList=new ArrayList<>();
							emptyMap.put("Electric Vehicle",newList);
						}
						emptyObj.setVehicleType("Electric Vehicle");
						newList.add(emptyObj);
					}
					
					
				}	
			}
			count++;
			System.out.println(emptySetMap);
		}
		
	}	
	
	public List<EmptySpot> removeEmpty(int i,int floor,String vehicleType)
	{
		emptyMap=emptySetMap.get(floor);
		newList=emptyMap.get(vehicleType);
		newList.remove(i);
		System.out.println(newList);
		return newList;
	}
	
	public Map<Integer,Map<String,List<EmptySpot>>> getEmptyMap1()
	{
		return emptySetMap;
	} 
	
	public double getPayableAmount(long entryTime,long exitTime)
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
	
	public List<FilledSpot> getFilledDetails()
	{
		return filledList;
	}
	public List<EmptySpot> getEmptyDetails()
	{
		return newList;
	}
	public List<FilledSpot> setFilledDetails(FilledSpot filledObj)
	{
		filledList.add(filledObj);
		return filledList;
	}
	public List<EmptySpot> setEmptyDetails1(EmptySpot emptyObj)
	{
		newList.add(emptyObj);
		return newList;
	}
	public List<FilledSpot> removeFilled(FilledSpot filled)
	{
		filledList.remove(filled);
		return filledList;
	}
	
	public Map<Integer,CustomerDetails> setCustomer(int tokenId,CustomerDetails customerObj)
	{
		customerMap.put(tokenId,customerObj);
		return customerMap;
	}
	
	public Map<Integer,ParkingDetails> setSlot(int tokenId,ParkingDetails parkingObj)
	{
		parkingMap.put(tokenId,parkingObj);
		return parkingMap;
	}
	
	public ParkingDetails getParkingDetails(int tokenId)
	{
		ParkingDetails parkingObj=parkingMap.get(tokenId);
		return parkingObj;
	}
	
	public Map<Integer,PaymentGateway> processPayment(int tokenId,PaymentGateway paymentObj)
	{
		paymentMap.put(tokenId,paymentObj);
		return paymentMap;
	}
}
