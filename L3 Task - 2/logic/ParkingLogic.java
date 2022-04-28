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
	private int customerId=0;
	CacheLayer cacheObj=new CacheLayer();
	
	public int getTokenId()
	{
		return ++tokenId;
	}
	
	public int getCustomerId()
	{
		return ++customerId;
	}
	
	public Map<Integer,CustomerDetails> setCustomer(int tokenId,CustomerDetails customerObj) throws Exception
	{
		Map<Integer,CustomerDetails> customerMap=cacheObj.setCustomer(tokenId,customerObj);
		return customerMap;
	}
	
	public List<EmptySpot> getEmptyDetails(int floor,String vehicleType) throws Exception
	{
		List<EmptySpot> newList=cacheObj.getEmptyDetails(floor,vehicleType);
		return newList;
	}
	
	public List<FilledSpot> getFilledDetails(int floor,String vehicleType) throws Exception
	{
		List<FilledSpot> newList=cacheObj.getFilledDetails(floor,vehicleType);
		return newList;
	}
	
	public List<FilledSpot> setFilledDetails(FilledSpot filledObj,int floor,String vehicleType) throws Exception
	{
		List<FilledSpot> filledList=cacheObj.setFilledDetails(filledObj,floor,vehicleType);
		return filledList;
	}
	
	public List<EmptySpot> setEmptyDetails(EmptySpot emptyObj,int floor,String vehicleType) throws Exception
	{
		List<EmptySpot> emptyList=cacheObj.setEmptyDetails1(emptyObj,floor,vehicleType);
		return emptyList;
	}
	
	/*public void setEmptyDetails(List<EmptySpot> emptyList)
	{
		cacheObj.setEmptyDetails(emptyList);
	}*/
	
	public Map<Integer,ParkingDetails> setSlot(int tokenId,ParkingDetails parkingObj) throws Exception
	{
		Map<Integer,ParkingDetails> parkingMap=cacheObj.setSlot(tokenId,parkingObj);
		return parkingMap;
	}
	
	public List<FilledSpot> removeFilled(int i,int floor,String vehicleType) throws Exception
	{
		List<FilledSpot> newList=cacheObj.removeFilled(i,floor,vehicleType);
		return newList;
	}
	
	public List<EmptySpot> removeEmpty(int i,int floor,String vehicleType) throws Exception
	{
		List<EmptySpot> newList=cacheObj.removeEmpty(i,floor,vehicleType);
		return newList;
	}
	
	public Map<Integer,Map<String,List<EmptySpot>>> getEmptyMapDetails() throws Exception
	{
		Map<Integer,Map<String,List<EmptySpot>>> newMap=cacheObj.getEmptyMap1();
		return newMap;
	} 
	
	public double getPayableAmount(long entryTime,long exitTime) throws Exception
	{
		double payable=cacheObj.getPayableAmount(entryTime,exitTime);
		return payable;
	}
	
	public ParkingDetails getParkingDetails(int tokenId) throws Exception
	{
		ParkingDetails parkingObj=cacheObj.getParkingDetails(tokenId);
		return parkingObj;
	}
	
	public Map<Integer,PaymentGateway> processPayment(int tokenId,PaymentGateway paymentObj) throws Exception
	{
		Map<Integer,PaymentGateway> paymentMap=cacheObj.processPayment(tokenId,paymentObj);
		return paymentMap;
	}
}
