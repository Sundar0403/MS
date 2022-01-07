package main;
import run.*;
import java.util.*;
import value.*;
import excep.*;

public class ArrayListMain
{
    ArrayListFunc arrayObj=new ArrayListFunc();
    StringFunc stringObj=new StringFunc();
    Scanner scan=new Scanner(System.in);
    
    private void stringInList(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int elements=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String newArray[]=new String[elements];
        	for(int i=0;i<elements;i++)
        	{
        		newArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,newArray);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        		
    }
    private void integerInList(List inputList)
    {
    	try
        {
        	System.out.println("Enter the Number of Elements : ");
        	int values=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Integer Values to be Added in the List : ");
        	Integer integerArray[]=new Integer[values];
        	for(int j=0;j<values;j++)
        	{
        		integerArray[j]=scan.nextInt();
        	}
        	inputList=arrayObj.addElementsInList(inputList,integerArray);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void objectInList(List inputList)
    {
    	try
        {
        	System.out.println("Enter the Number of Elements : ");
        	int entity=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Objects to be Added in the List : ");
        	Object objectArray[]=new Object[entity];
        	for(int k=0;k<entity;k++)
        	{
        		objectArray[k]=arrayObj;
        	}
        	inputList=arrayObj.addElementsInList(inputList,objectArray);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void allInList(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int size=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String addString[]=new String[size];
        	for(int l=0;l<size;l++)
        	{
        		addString[l]=scan.nextLine();
        	}
        	System.out.println("Enter the Integers to be Added in the List : ");
        	Integer addInteger[]=new Integer[size];
        	for(int m=0;m<size;m++)
        	{
        		addInteger[m]=scan.nextInt();
        	}
        	System.out.println("Enter the Objects to be Added in the List : ");
        	Object addObject[]=new Object[size];
        	for(int n=0;n<size;n++)
        	{
        		addObject[n]=stringObj;
        	}
        	scan.nextLine();
        	inputList=arrayObj.addElementsInList(inputList,addString);
        	inputList=arrayObj.addElementsInList(inputList,addInteger);
        	inputList=arrayObj.addElementsInList(inputList,addObject);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void indexOfString(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
      		int length=scan.nextInt();
  		scan.nextLine();
      		System.out.println("Enter the Strings to be Added in the List : ");
       	String strArray[]=new String[length];
        	for(int a=0;a<length;a++)
        	{
       		strArray[a]=scan.nextLine();
        	}
        	String indexString=scan.nextLine();
        	inputList=arrayObj.addElementsInList(inputList,strArray);
        	System.out.println("Index of the Given String is : "+arrayObj.getIndexOfString(inputList,indexString));
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void iteration(List inputList)
    {
    	stringInList(inputList);
    }
    private void stringInIndex(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int limits=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String stringFindArray[]=new String[limits];
        	for(int i=0;i<limits;i++)
        	{
        		stringFindArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,stringFindArray);
        	System.out.println(" Enter the Index to add the Element : ");
        	int index=scan.nextInt();
        	scan.nextLine();
        	System.out.println("The String in Index No."+index+" is : "+arrayObj.findStringInList(inputList,index));
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
      	catch(Exception e)
      	{
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void indexOfDuplicate(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int listSize=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String duplicateArray[]=new String[listSize];
        	for(int c=0;c<listSize;c++)
        	{
        		duplicateArray[c]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,duplicateArray);
        	String duplicateString=scan.nextLine();
        	System.out.println("The First Index of the Duplicate Element is : "+arrayObj.firstIndexForDuplicate(inputList,duplicateString));
        	System.out.println("The Last Index of the Duplicate ELement is : "+arrayObj.lastIndexForDuplicate(inputList,duplicateString));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void insertString(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int limit=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String stringInsertArray[]=new String[limit];
        	for(int i=0;i<limit;i++)
        	{
        		stringInsertArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,stringInsertArray);
        	System.out.println(" Enter the Index to add the Element : ");
        	int index=scan.nextInt();
        	scan.nextLine();
        	System.out.println(" Enter the String to Insert ");
        	String insertString=scan.nextLine();
        	arrayObj.replaceElementsInList(inputList,insertString,index);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void transferList(List inputList)
    {
    	try
        {
        	List outputList=arrayObj.createList();
        	System.out.println(" Enter the Number of Elements : ");
        	int arrIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String strArray[]=new String[arrIndex];
        	for(int i=0;i<arrIndex;i++)
        	{
        		strArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,strArray);
        	int start=scan.nextInt();
        	int end=scan.nextInt();
        	scan.nextLine();
        	outputList=arrayObj.oneListToAnother(inputList,start,end);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(outputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(outputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void merge(List inputList)
    {
    	try
        {
        	List addList=arrayObj.createList();
        	System.out.println(" Enter the Number of Elements List 1 : ");
        	int firstListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strFirstArray[]=new String[firstListIndex];
        	for(int i=0;i<firstListIndex;i++)
        	{
        		strFirstArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,strFirstArray);
        	System.out.println(" Enter the Number of Elements List 2 : ");
        	int secondListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strSecondArray[]=new String[secondListIndex];
        	for(int j=0;j<secondListIndex;j++)
        	{
        		strSecondArray[j]=scan.nextLine();
        	}
        	addList=arrayObj.addElementsInList(addList,strSecondArray);
        	System.out.println("The List Elements are ");
        	addList=arrayObj.mergeList(inputList,addList);
        	arrayObj.iteratorGetStrings(addList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(addList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    } 
    private void mergeInList(List inputList)
    {
    	try
        {
        	List addList=arrayObj.createList();
        	System.out.println(" Enter the Number of Elements List 1 : ");
        	int firstListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strFirstArray[]=new String[firstListIndex];
        	for(int i=0;i<firstListIndex;i++)
        	{
        		strFirstArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,strFirstArray);
        	System.out.println(" Enter the Number of Elements List 2 : ");
        	int secondListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strSecondArray[]=new String[secondListIndex];
        	for(int j=0;j<secondListIndex;j++)
        	{
        		strSecondArray[j]=scan.nextLine();
        	}
        	addList=arrayObj.addElementsInList(addList,strSecondArray);
        	System.out.println("The List Elements are ");
        	addList=arrayObj.mergeList(addList,inputList);
        	arrayObj.iteratorGetStrings(addList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(addList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void remove(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int value=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Decimal Values to be Added in the List : ");
        	Object inputArray[]=new Object[value];
        	for(int i=0;i<value;i++)
        	{
        		inputArray[i]=scan.nextDouble();
        	}
        	inputList=arrayObj.addElementsInList(inputList,inputArray);
        	System.out.println("Enter the Value to be Removed : ");
        	double removeValue=scan.nextDouble();
        	scan.nextLine();
        	inputList=arrayObj.removeFromList(inputList,removeValue);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        	}
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void removeFromIndex(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int value=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Decimal Values to be Added in the List : ");
        	Object inputArray[]=new Object[value];
        	for(int i=0;i<value;i++)
        	{
        		inputArray[i]=scan.nextDouble();
        	}
        	inputList=arrayObj.addElementsInList(inputList,inputArray);
        	System.out.println("Enter the Index Value to be Removed : ");
        	int index=scan.nextInt();
        	scan.nextLine();
        	inputList=arrayObj.removeElementFromList(inputList,index);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void removeDuplicate(List inputList)
    {
    	try
        {
        	List checkList=arrayObj.createList();
        	System.out.println(" Enter the Number of Elements List 1 : ");
        	int firstListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strFirstArray[]=new String[firstListIndex];
        	for(int i=0;i<firstListIndex;i++)
        	{
        		strFirstArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,strFirstArray);
        	System.out.println(" Enter the Number of Elements List 2 : ");
        	int secondListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strSecondArray[]=new String[secondListIndex];
        	for(int j=0;j<secondListIndex;j++)
        	{
        		strSecondArray[j]=scan.nextLine();
        	}
        	checkList=arrayObj.addElementsInList(checkList,strSecondArray);
        	System.out.println("The List Elements are ");
        	inputList=arrayObj.removeDuplicateInList(inputList,checkList);
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void findDuplicate(List inputList)
    {
    	try
        {
        	List checkList=arrayObj.createList();
        	System.out.println(" Enter the Number of Elements List 1 : ");
        	int firstListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strFirstArray[]=new String[firstListIndex];
        	for(int i=0;i<firstListIndex;i++)
        	{
        		strFirstArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,strFirstArray);
        	System.out.println(" Enter the Number of Elements List 2 : ");
        	int secondListIndex=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List 1 : ");
        	String strSecondArray[]=new String[secondListIndex];
        	for(int j=0;j<secondListIndex;j++)
        	{
        		strSecondArray[j]=scan.nextLine();
        	}
        	checkList=arrayObj.addElementsInList(checkList,strSecondArray);
        	System.out.println("The List Elements are ");
        	inputList=arrayObj.findDuplicateInList(inputList,checkList);
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void clear(List inputList)
    {
    	try
        {
        	System.out.println("Enter the Number of Elements : ");
        	int values=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Integer Values to be Added in the List : ");
        	Object longArray[]=new Object[values];
        	for(int j=0;j<values;j++)
        	{
        		longArray[j]=scan.nextLong();
        	}
        	inputList=arrayObj.addElementsInList(inputList,longArray);
        	inputList=arrayObj.clearArrayList(inputList);
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    private void checkString(List inputList)
    {
    	try
        {
        	System.out.println(" Enter the Number of Elements : ");
        	int elements=scan.nextInt();
        	scan.nextLine();
        	System.out.println("Enter the Strings to be Added in the List : ");
        	String newArray[]=new String[elements];
        	for(int i=0;i<elements;i++)
        	{
        		newArray[i]=scan.nextLine();
        	}
        	inputList=arrayObj.addElementsInList(inputList,newArray);
        	System.out.println("Enter the String to Insert : ");
        	String inputString=scan.nextLine();
        	System.out.println(" The Given String is Present in the String : "+arrayObj.checkStringInList(inputList,inputString));
        	System.out.println("The List Elements are ");
        	arrayObj.iteratorGetStrings(inputList);
        	System.out.println("The Length of the List is : "+arrayObj.getSize(inputList));
        }
        catch(CustomException e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println(" Exception Occured : "+e.getMessage());
        }
    }
    public static void main(String as[])
    {
    	ArrayListFunc arrayObj=new ArrayListFunc();
    	ArrayListMain mainObj=new ArrayListMain();
    	StringFunc stringObj=new StringFunc();
        Scanner scan=new Scanner(System.in);
        List inputList=arrayObj.createList();
        System.out.println(" Enter The Task To Execute ");
        int choice=0;
        try
        {
        	choice=scan.nextInt();
        	scan.nextLine();
        }
        catch(Exception e)
        {
        	System.out.println(" Invalid Choice ");
        }
        
        switch(choice)
        {
        	case 1:
        		scan.nextLine();
        		try
        		{
        			List newList=arrayObj.createList();
        			System.out.println("The Length of the List is : "+arrayObj.getSize(newList));
        		}
        		catch(Exception e)
        		{
        			System.out.println(" Exception Occured : "+e.getMessage());
        		}
        	case 2:
        		
        		mainObj.stringInList(inputList);
        		break;
        	
        	case 3:
        		
        		mainObj.integerInList(inputList);
        		break;
        	
        	case 4:
        		
        		mainObj.objectInList(inputList);
        		break;	
        		
        	case 5:
        		
        		mainObj.allInList(inputList);
        		break;
        		
        	case 6:
        		
        		mainObj.indexOfString(inputList);
        		break;
        		
        	case 7:
        		
        		mainObj.iteration(inputList);
        		break;
        		
        	case 8:
        		
        		mainObj.stringInIndex(inputList);
        		break;
        	
        	case 9:
        		
        		mainObj.indexOfDuplicate(inputList);
        		break;
        		
        	case 10:
        		
        		mainObj.insertString(inputList);
        		break;
        		
        	case 11:
        		
        		mainObj.transferList(inputList);
        		break;
        		
        	case 12:
        		
        		mainObj.merge(inputList);
        		break;
        		
        	case 13:
        		
        		mainObj.mergeInList(inputList);
        		break;
        		
        	case 14:
        		
        		mainObj.remove(inputList);
        		break;	
        		
        	case 15:

        		mainObj.removeFromIndex(inputList);
        		break;
        		
        	case 16:
        		
        		mainObj.removeDuplicate(inputList);
        		break;
        		
        	case 17:
        		
        		mainObj.findDuplicate(inputList);
        		break;
        		
        	case 18:
      
        		mainObj.clear(inputList);
        		break;
        		
        	case 19:
        		
        		mainObj.checkString(inputList);
        		break;																		
        }
    }
}






