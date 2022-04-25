package cache;
import customer.*;
import slot.*;
import payment.*;
import java.util.*;

public class CacheLayer
{
	Map<Integer,CustomerDetails> customerMap=new HashMap<>();
	Map<Integer,ParkingDetails> parkingMap=new HashMap<>();
	Map<Integer,PaymentGateway> paymentMap=new HashMap<>();
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
