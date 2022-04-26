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
	
	
	List<FilledSpot> filledList=new ArrayList<>();
	Map<String,List<EmptySpot>> emptyMap=new HashMap<>();
	Map<Integer,Map<String,List<EmptySpot>>> emptySetMap=new HashMap<>();
	int count=0;
	List<EmptySpot> newList=new ArrayList<>();
	public CacheLayer()
	{
		if(count==0)
		{
			//newList=new ArrayList<>();
			
			for(int i=1;i<=4;i++)
			{
				
				for(int j=1;j<=10;j++)
				{
					
					newList=new ArrayList<>();
					EmptySpot emptyObj=new EmptySpot();
					if(j<=2)
					{
						emptyMap=new HashMap<>();
						emptyObj.setSpotNumber(j);
						emptyObj.setVehicleType("Compact");
						emptyObj.setFloor(i);
						newList.add(emptyObj);
						emptyMap.put("Compact",newList);
						System.out.println(emptyMap);
						emptySetMap.put(i,emptyMap);
					}
					else if(j<=4)
					{
						emptyMap=new HashMap<>();
						//EmptySpot emptyObj=new EmptySpot();
						emptyObj.setSpotNumber(j);
						emptyObj.setVehicleType("Large");
						emptyObj.setFloor(i);
						newList.add(emptyObj);
						emptyMap.put("Large",newList);
						System.out.println(emptyMap);
						emptySetMap.put(i,emptyMap);
					}
					else if(j<=6)
					{
						//EmptySpot emptyObj=new EmptySpot();
						emptyMap=new HashMap<>();
						emptyObj.setSpotNumber(j);
						emptyObj.setVehicleType("Handicapped");
						emptyObj.setFloor(i);
						newList.add(emptyObj);
						emptyMap.put("Handicapped",newList);
						System.out.println(emptyMap);
						emptySetMap.put(i,emptyMap);
					}
					else if(j<=8)
					{
						//EmptySpot emptyObj=new EmptySpot();
						emptyMap=new HashMap<>();
						emptyObj.setSpotNumber(j);
						emptyObj.setVehicleType("Motor Cycle");
						emptyObj.setFloor(i);
						newList.add(emptyObj);
						emptyMap.put("Motor Cycle",newList);
						System.out.println(emptyMap);
						emptySetMap.put(i,emptyMap);
					}
					else if(j<=10)
					{
						//EmptySpot emptyObj=new EmptySpot();						
						emptyMap=new HashMap<>();
						emptyObj.setSpotNumber(j);
						emptyObj.setVehicleType("Electric Vehicle");
						emptyObj.setFloor(i);
						newList.add(emptyObj);
						emptyMap.put("Electric Vehicle",newList);
						System.out.println(emptyMap);
						emptySetMap.put(i,emptyMap);
					}
					
					
				}
				
				//newList.clear();		
			}
			count++;
			System.out.println(emptySetMap);
		}
		
	}	
	
	public List<EmptySpot> removeEmpty(EmptySpot emptyObj)
	{
		newList.remove(emptyObj);
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
