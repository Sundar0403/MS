package value;
import java.util.*;
import run.*;
import excep.*;

public class ArrayListFunc
{

	StringFunc strObj=new StringFunc();
	public void listCheck(List inputList) throws CustomException
	{
		if(inputList==null)
		{
			throw new CustomException(" List Can't be Null ");
		}
	}
	
	
	public void listIndexCheck(List inputList,int index) throws Exception
	{
	        listCheck(inputList);
		int size=getSize(inputList);
		if(index>=size||index<0)
		{
			throw new Exception(" Index Value Should Not Greater than ArrayList Size ");
		}
	}
	
	
	public void listPositionCheck(List inputList,int startPos,int endPos) throws Exception
	{
	        listCheck(inputList);
		int size=getSize(inputList);
		if(startPos>endPos||startPos>size||endPos>size)
		{
			throw new Exception(" Start and End Position Should not Exceed the Size of the ArrayList ");
		}
	}
	
	
	public int getSize(List newList) throws Exception
	{
		listCheck(newList);
		int size=newList.size();
		return size;
	}
	
	
	public List createList()
	{
		List list=new ArrayList();
		return list;
	}
	
	
	public List addElementsInList(List inputList,Object objArray[]) throws Exception // 2,3,4th
	{
		listCheck(inputList);
		inputList.addAll(Arrays.asList(objArray));
		return inputList;
	}
	
	
	public List addAllInList(List inputList) throws Exception //5th
	{
		listCheck(inputList);
		return inputList;
	}
	
	
	public int getIndexOfString(List inputList,String inputString) throws Exception //6th
	{
		listCheck(inputList);
		int index=inputList.indexOf(inputString);
		return index;
	}
	
	
	public void iteratorGetStrings(List inputList) throws Exception //7th
	{
		listCheck(inputList);
		Iterator iteration=inputList.iterator();
		for(;iteration.hasNext();)
		{
			System.out.println(iteration.next());
		}
	}
	
	
	public Object findStringInList(List inputList,int index) throws Exception  //8th
	{
		listIndexCheck(inputList,index);
		Object outputString=inputList.get(index);
		return outputString;
	}
	
	
	public int firstIndexForDuplicate(List inputList,String inputString) throws Exception //9th
	{
		int index=getIndexOfString(inputList,inputString);
		return index;
	}
	
	
	public int lastIndexForDuplicate(List inputList,String inputString) throws Exception //10th
	{
		listCheck(inputList);
		int lastIndex=inputList.lastIndexOf(inputString);
		return lastIndex;
	}
	
	
	public List replaceElementsInList(List inputList,String inputString,int index)throws Exception //10th
	{
		listIndexCheck(inputList,index);
		inputList.set(index,inputString);
		return inputList;
	}
	
	
	public List oneListToAnother(List inputList,int startPos,int endPos)throws Exception  //11th
	{
		listPositionCheck(inputList,startPos,endPos);
		List newList=(List)inputList.subList(startPos,endPos);
		return newList;
	}
	
	
	public List mergeList(List inputList,List addList)throws Exception //12th & 13th
	{
		listCheck(inputList);
		listCheck(addList);
		inputList.addAll(addList);
		return inputList;
	}
	
	
	public List removeFromList(List inputList,Object decimal)throws Exception //14th
	{
		listCheck(inputList);
		inputList.remove(decimal);
		return inputList;
	}
	
	
	public List removeElementFromList(List inputList,int index)throws Exception //15th
	{
		listIndexCheck(inputList,index);
		inputList.remove(index);
		return inputList;
	}
	
	
	public List findDuplicateInList(List inputList,List addList)throws Exception //17th
	{
		listCheck(inputList);
		inputList.retainAll(addList);
		return inputList;
	}
	
	
	public List removeDuplicateInList(List inputList,List addList)throws Exception //18th
	{
		listCheck(inputList);
		inputList.removeAll(addList);
		return inputList;
	}
	
	
	public List clearArrayList(List inputList)throws Exception  //19th
	{
		listCheck(inputList);
		inputList.clear();
		return inputList;
	}
	
	
	public boolean checkStringInList(List inputList,String inputString)throws Exception //20th
	{
		listCheck(inputList);
		return inputList.contains(inputString);
	}


}




