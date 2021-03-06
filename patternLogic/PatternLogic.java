package patternLogic;
import java.util.*;

public class PatternLogic
{
	public void rightTrianglePattern(int num)
	{
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void rightPascalTrianglePattern(int num)
	{
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int k=num-2;k>=0;k--)
		{
			for(int l=0;l<=k;l++)
			{
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public void numberPattern(int num)
	{
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(j+1);
				System.out.print(" ");
			}
			
			System.out.println();
			
		}
	}
	public void zPattern(int num)
	{
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				if(i==0||i==num-1)
				{
					System.out.print("*");
					System.out.print(" ");
				}
				else
				{
					System.out.print(" ");
				}
				if(i>0||i<num-1)
				{
					if(i+j==num-1)
					{
						System.out.print("*");
						System.out.print(" ");
					}
				}	
			}
			
			System.out.println();
		}
	}
	public void leftTrianglePattern(int num)
	{
		int count=num-1;
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				if(j>=count)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			
			System.out.println();
			count--;
		}
	}
	public void pyramidPattern(int num)
	{
		int count=num-1;
		for(int i=num-1;i>=0;i--)
		{
			for(int j=0;j<num;j++)
			{
				if(j>=count)
				{
					System.out.print("* ");
					count--;
				}
				else
				{
					System.out.print(" ");
				}	
			}
			System.out.println();
		}
	}
}

