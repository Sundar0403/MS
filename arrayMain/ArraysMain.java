package arrayMain;
import arraysLogic.*;
import java.util.*;

public class ArraysMain
{
	Scanner scan=new Scanner(System.in);
	ArraysLogic logicObj=new ArraysLogic();
	private void printArray()
	{
		
		scan.nextLine();
		int count=0;
		int arr[]=new int[15];
		for(int i=0;i<15;i++)
		{
			arr[i]=scan.nextInt();
				
		}
		logicObj.printArrays(arr);
	}
	private void closestSumArray()
	{
		
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num,;i++)
		{
			arr[i]=scan.nextInt();
				
		}
		logicObj.closestSumArray(arr,num);
	}
	private void rotateArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.rotateArrays(arr,num);
	}
	private void countArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.countArray(arr,num);
	}
	
	private void closestArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		//logicObj.closestArray(arr,num);
	}
	
	private void perfectNumber()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.perfectNumber(num);
	}

	private void digitSumArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.digitSumArray(arr,num);
	}
	private void misMatchArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		String arr[]=new String[num];
		String arr2[]=new String[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextLine();	
		}
		for(int j=0;j<num;j++)
		{
			arr2[j]=scan.nextLine();
		}
		logicObj.misMatchArray(arr,arr2,num);
	}
	public static void main(String args[])
	{
		ArraysMain mainObj=new ArraysMain();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your Choice:");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice)
		{
			
			case 4:
				mainObj.rotateArray();
				break;		
				
			case 5:
				mainObj.misMatchArray();
				break;	
				
			case 9:
				mainObj.countArray();
				break;
				
			case 16:
				mainObj.perfectNumber();
				break;		
				
			case 18:
				mainObj.digitSumArray();
				break;	
			
			case 20:
				mainObj.printArray();
				break;
		}
	}
}	
