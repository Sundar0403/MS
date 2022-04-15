package matrixLogic;
import java.util.*;

public class MatrixLogic
{
	public void replaceZeros(int arr[][])
	{
		int newCount=0;
		int count=0;
		int value=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[i][j]==1)
				{
					count++;
				}
			}
			if(newCount<count)
			{
				newCount=count;
				value=i;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(i==value)
				{
					arr[i][j]=0;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int isSuperSimilar(int n, int m, int mat[][], int x)
    {
        // code here
       for(int i=0;i<n;i+=2)
       {
           for(int j=0;j<m;j++)
           {
                if(mat[i][j]!=mat[i][(j+x)%m])
                {
                    return 0;
                }
           }    
       }
       
       x=m-x;
       x=Math.abs(x);
       for(int i=1;i<n;i+=2)
       {
           for(int j=0;j<m;j++)
           {
                if(mat[i][j]!=mat[i][(j+x)%m])
                {        
                    return 0;
                }
           }    
       }
       return 1;
        
    }

	public void diagonalSorting(int arr[][])
	{
		int newArr[][]=new int[arr.length][arr.length];
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
				{
					arr[i][j]=count;
					count++;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
