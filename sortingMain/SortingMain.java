package sortingMain;
import sortingLogic.*;
import java.util.*;

public class SortingMain
{
	Scanner scan=new Scanner(System.in);
	SortingLogic logicObj=new SortingLogic();
	
	private void selectionSort()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();
		}
		logicObj.selectionSort(arr,num);
	}
	
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		SortingMain mainObj=new SortingMain();
		
		int count=scan.nextInt();
		scan.nextLine();
		
		switch(count)
		{
			
			case 1:
				mainObj.selectionSort();
				break;
		}
	}
}
