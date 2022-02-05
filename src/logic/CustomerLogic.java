package logic;

import java.util.*;

public class CustomerLogic {
	int id=0;
	int actId=1000;
	static Map<Object,Object> inputMap=new HashMap<>();
	
	public List inputList()
	{
		List inputList=new ArrayList();
		return inputList;
	}
	public Object getId()
	{
		++id;
		return id;
	}
	
	public Object getAccountId()
	{
		++actId;
		return actId;
	}
	
	public Map<Object,Object> getMap(Object id,Object pojo)
	{
		inputMap.put(id,pojo);
		return inputMap;
	}
	public Object getIdDetails(Object id)
	{
		return inputMap.get(id);
	}
	/*public Map<Object,Object> getDetails()
	{
		Map<Object,Object> userMap=inputMap();
		
	}*/
}
