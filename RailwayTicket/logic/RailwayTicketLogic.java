package logic;
import passenger.*;
import ticket.*;
import cache.*;
import java.util.*;

public class RailwayTicketLogic
{
	CacheLayer cacheObj=new CacheLayer();
	
	private int custId=0;
	
	public int getCustId()
	{
		return ++custId;
	}
	
	public Map<Integer,PassengerDetails> setPassenger(int passengerId,PassengerDetails passengerObj) throws Exception
	{
		Map<Integer,PassengerDetails> passengerMap=cacheObj.setPassenger(passengerId,passengerObj);
		return passengerMap;
	}
}
