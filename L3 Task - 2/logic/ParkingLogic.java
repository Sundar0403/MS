package logic;
import cache.*;
import empty.*;
import customer.*;
import slot.*;
import payment.*;
import filled.*;
import vehicle.*;
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
	
	public List<Spot> getEmptyDetails(int floor,String vehicleType) throws Exception
	{
		List<Spot> newList=cacheObj.getEmptyDetails(floor,vehicleType);
		return newList;
	}
	
	public VehicleDetails getVehicleDetails(String vehicleNumber) throws Exception
	{
		VehicleDetails vehicleObj=cacheObj.getVehicleDetails(vehicleNumber);
		return vehicleObj;
	}
	
	public Map<String,VehicleDetails> setVehicle(String vehicleNumber,VehicleDetails vehicleObj) throws Exception
	{
		Map<String,VehicleDetails> vehicleMap=cacheObj.setVehicle(vehicleNumber,vehicleObj);
		return vehicleMap;
	}
	
	public CustomerDetails getCustomer(int customerId) throws Exception
	{
		CustomerDetails customerObj=cacheObj.getCustomer(customerId);
		return customerObj;
	}
	
	public List<Spot> getFilledDetails(int tokenId) throws Exception
	{
		List<Spot> newList=cacheObj.getFilledDetails(tokenId);
		return newList;
	}
	
	public List<Spot> setFilledDetails(int tokenId,Spot filledObj) throws Exception
	{
		List<Spot> filledList=cacheObj.setFilledDetails(tokenId,filledObj);
		return filledList;
	}
	
	public List<Spot> setEmptyDetails(Spot emptyObj,int floor,String vehicleType) throws Exception
	{
		List<Spot> emptyList=cacheObj.setEmptyDetails1(emptyObj,floor,vehicleType);
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
	
	public List<Spot> removeFilled(int i,int tokenId) throws Exception
	{
		List<Spot> newList=cacheObj.removeFilled(i,tokenId);
		return newList;
	}
	
	public List<Spot> removeEmpty(int i,int floor,String vehicleType) throws Exception
	{
		List<Spot> newList=cacheObj.removeEmpty(i,floor,vehicleType);
		return newList;
	}
	
	public Map<Integer,Map<String,List<Spot>>> getEmptyMapDetails() throws Exception
	{
		Map<Integer,Map<String,List<Spot>>> newMap=cacheObj.getEmptyMap1();
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
	
	/*public Map<Integer,PaymentGateway> processPayment(int tokenId,PaymentGateway paymentObj) throws Exception
	{
		Map<Integer,PaymentGateway> paymentMap=cacheObj.processPayment(tokenId,paymentObj);
		return paymentMap;
	}*/
}
