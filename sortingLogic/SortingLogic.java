package sortingLogic;
import java.util.*;

public class SortingLogic
{
	public void selectionSort(int arr[],int num)
	{
		int min=0;
		int temp=0;
		for(int i=0;i<num;i++)
		{
			min=i;
			for(int j=i+1;j<num;j++)
			{
				if(arr[j]<arr[min])
				{
					temp=arr[j];
					arr[j]=arr[min];
					arr[min]=temp;
				}
			}
			
		}
		for(int i=0;i<num;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
