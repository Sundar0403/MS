package logic;
import cache.*;
import customer.*;
import slot.*;
import payment.*;
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
	
	public Map<Integer,ParkingDetails> setSlot(int tokenId,ParkingDetails parkingObj)
	{
		Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
		parkingMap=cacheObj.setSlot(tokenId,parkingObj);
		return parkingMap;
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
