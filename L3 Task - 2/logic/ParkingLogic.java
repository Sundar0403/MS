package logic;
import cache.*;
import empty.*;
import customer.*;
import slot.*;
import payment.*;
import filled.*;
import java.util.*;

public class ParkingLogic
{
	private int tokenId=0;
	CacheLayer cacheObj=new CacheLayer();
	
	public int getTokenId()
	{
		return ++tokenId;
	}
	
	public Map<Integer,CustomerDetails> setCustomer(int tokenId,CustomerDetails customerObj)
	{
		Map<Integer,CustomerDetails> customerMap=new HashMap<>();
		customerMap=cacheObj.setCustomer(tokenId,customerObj);
		return customerMap;
	}
	
	public List<EmptySpot> getEmptyDetails()
	{
		List<EmptySpot> newList=new ArrayList<>();
		newList=cacheObj.getEmptyDetails();
		return newList;
	}
	
	public List<FilledSpot> getFilledDetails()
	{
		List<FilledSpot> newList=new ArrayList<>();
		newList=cacheObj.getFilledDetails();
		return newList;
	}
	
	public List<FilledSpot> setFilledDetails(FilledSpot filledObj)
	{
		List<FilledSpot> filledList=new ArrayList<>();
		filledList=cacheObj.setFilledDetails(filledObj);
		return filledList;
	}
	
	public List<EmptySpot> setEmptyDetails(EmptySpot emptyObj)
	{
		List<EmptySpot> emptyList=new ArrayList<>();
		emptyList=cacheObj.setEmptyDetails1(emptyObj);
		return emptyList;
	}
	
	/*public void setEmptyDetails(List<EmptySpot> emptyList)
	{
		cacheObj.setEmptyDetails(emptyList);
	}*/
	
	public Map<Integer,ParkingDetails> setSlot(int tokenId,ParkingDetails parkingObj)
	{
		Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
		parkingMap=cacheObj.setSlot(tokenId,parkingObj);
		return parkingMap;
	}
	
	public List<FilledSpot> removeFilled(FilledSpot filled)
	{
		List<FilledSpot> newList=new ArrayList<>();
		newList=cacheObj.removeFilled(filled);
		return newList;
	}
	
	public List<EmptySpot> removeEmpty(int i,int floor,String vehicleType)
	{
		List<EmptySpot> newList=new ArrayList<>();
		newList=cacheObj.removeEmpty(i,floor,vehicleType);
		return newList;
	}
	
	public Map<Integer,Map<String,List<EmptySpot>>> getEmptyMapDetails()
	{
		Map<Integer,Map<String,List<EmptySpot>>> newMap=new HashMap<>();
		newMap=cacheObj.getEmptyMap1();
		return newMap;
	} 
	
	public double getPayableAmount(long entryTime,long exitTime)
	{
		double payable=0.0;
		payable=cacheObj.getPayableAmount(entryTime,exitTime);
		return payable;
	}
	
	public ParkingDetails getParkingDetails(int tokenId)
	{
		ParkingDetails parkingObj=new ParkingDetails();
		parkingObj=cacheObj.getParkingDetails(tokenId);
		return parkingObj;
	}
	
	public Map<Integer,PaymentGateway> processPayment(int tokenId,PaymentGateway paymentObj)
	{
		Map<Integer,PaymentGateway> paymentMap=new HashMap<>();
		paymentMap=cacheObj.processPayment(tokenId,paymentObj);
		return paymentMap;
	}
}
