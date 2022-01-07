package test;
import run.*;
import java.util.*;
import java.io.*;
import excep.*;

public class StringMain
{
    
    StringFunc obj=new StringFunc();
    InputStreamReader is=new InputStreamReader(System.in);
    BufferedReader b=new BufferedReader(is);
    Scanner sc=new Scanner(System.in);
    
    private void getCharArray(String string1)
    {
    	System.out.println("Enter the Given String");
        try
        {
               char cha[]=obj.stringToCharArray(string1);
               int len=obj.getLength(string1);
               for(int a=0;a<len;a++)
               {
                	System.out.println(cha[a]);
               }
         }
         catch(CustomException e)
         {
         	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
         }
         catch(Exception e)
         {
                System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
         }
    }
    private void getCharPosition(String string1)
    {
    	System.out.println("Enter the String");
        try
        {
        	char ch3=sc.next().charAt(0);
		System.out.println("Character Position is : "+obj.getCharPos(string1,ch3));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void getCharOccurence(String string1)
    {
    	System.out.println("Enter the New String");
        try
        {
        	System.out.println("Enter the Character");
                char character1=sc.next().charAt(0);
                System.out.println("The Number of Occurences are :" + obj.charOccurence(string1,character1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void getGreatPosition(String string1)
    {
    	System.out.println("Enter the New String");
        try
        {
        	System.out.println("Enter the Character");
               char character2=sc.next().charAt(0);
               System.out.println("The Greatest Position is :" + obj.charGreatestPos(string1,character2));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void subString(String string1)
    {
    	System.out.println("Enter the New String");
        int num10=0;
        try
        {
        	System.out.println("Enter a Number");
                num10=Integer.parseInt(b.readLine());
        }
        catch(Exception e)
        {
                System.out.println("Invalid Type Format");
        }
        try
        {
                System.out.println("The Required String is "+ obj.stringSubStr1(string1,num10));
        }
        catch(CustomException e)
        {
        	 System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
        catch(Exception e)
        {
                 System.out.println("Exception Occured : "+e.getMessage());
                 e.printStackTrace();
        }
    }
    private void printFirstThreeCharacters(String string1)
    {
    	System.out.println("Enter the New String");
        int num11=0;
        try
        {
        	num11=Integer.parseInt(b.readLine());
        }
        catch(Exception e)
        {
        	System.out.println("Invalid Type Format");
        }
        try
        {
        	System.out.println("The Required String is "+ obj.stringSubStr2(string1,num11));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
    }
    private void replace(String string1)
    {
    	System.out.println("Enter the Strings");
        String string2=sc.nextLine();
        int num21=0;
        int num22=0;
                
        try
        {
               num21=Integer.parseInt(b.readLine());
               num22=Integer.parseInt(b.readLine());
        }
        catch(Exception e)
        {
               System.out.println("Invalid Type Format");
        }
        try
        {
               System.out.println(""+obj.stringReplace(string1,string2,num21,num22));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
                System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
    }
    private void stringStart(String string1)
    {
    	System.out.println("Enter the Strings");
        String string2=sc.nextLine();
        try
        {
        	System.out.println("The Given String is Starts With : " +obj.startString(string1,string2));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void stringEnd(String string1)
    {
    	System.out.println("Enter the Strings");
        String string2=sc.nextLine();
	try
        {
        	System.out.println("The Given String is Ends With : "+obj.endString(string1,string2));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured :"+e.getMessage());
               e.printStackTrace();
        }
    }
    private void upperCase(String string1)
    {
    	System.out.println("Enter the Lowercase String");
        try
        {
        	System.out.println("The Uppercase Converted String is :" +obj.stringUpperCase(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void lowerCase(String string1)
    {
    	System.out.println("Enter the Uppercase String");
        try
        {
        	System.out.println("The Lowercase Converted String is :" +obj.stringLowerCase(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
               System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void reverse(String string1)
    {
    	System.out.println("Enter the Name");
        try
        {
        	System.out.println("The Reverse of the Name is : "+obj.stringReverse(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
    }
    private void multipleString(String string1)
    {
    	System.out.println("Enter the Strings :");
	try
        {
        	System.out.println(obj.multiString(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
    }
    private void concat(String string1)
    {
    	System.out.println("Enter the string");
 	try
        {
        	System.out.println(obj.stringConcat(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
               e.printStackTrace();
        }
    }
    private void stringArray(String string1)
    {
    	System.out.println("Enter the String");
        try
        {
        	String strr[]=obj.stringArray(string1);
               for(int c=0;c<strr.length;c++)
               {
               	System.out.println(strr[c]);
               }
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
                e.printStackTrace();
        }
    }
    private void charInsert(String string1)
    {
    	System.out.println("Enter the Number of Strings");
        int number3=0;
        try
        {
        	number3=Integer.parseInt(b.readLine());
        }
        catch(Exception e)
        {
        	System.out.println("Invalid Type Format");
        }
        String string12[]=new String[number3];
                
        for(int k=0;k<number3;k++)
        {
        	string12[k]=sc.nextLine();
        }
        System.out.println("Enter the Character to be Inserted :");
        String character=sc.nextLine();
        try
        {
        	System.out.println(obj.stringMerge(string12,character));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured :"+e.getMessage());
                e.printStackTrace();
        }
    }
    private void equal(String string1)
    {
    	System.out.println("Enter the Strings");
        String string2=sc.nextLine();
        try
        {
        	System.out.println("The Given Two Strings are Equal : "+obj.equalsSensitive(string1,string2));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured"+e.getMessage());
        	e.printStackTrace();
        }
    }
    private void equalIgnoreCase(String string1)
    {
    	System.out.println("Enter the Strings");
        String string2=sc.nextLine();
        try
        {
        	System.out.println("The Given Two Strings are Equal : "+obj.equalsInSensitive(string1,string2));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured"+e.getMessage());
        	e.printStackTrace();
        }
    }
    private void trim(String string1)
    {
    	System.out.println("Enter the New String");
        try
        {
        	System.out.println(""+obj.stringTrim(string1));
        }
        catch(CustomException e)
        {
        	System.out.println("Exception Occured : "+e.getMessage());
        	e.printStackTrace();
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occured :"+e.getMessage());
               e.printStackTrace();
        }
    }
    public static void main(String args[]) throws IOException
    {
    
        StringFunc obj=new StringFunc();
        StringMain mainObj=new StringMain();
        InputStreamReader is=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(is);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Choice");
        int choice=0;
        try
        {
            choice=Integer.parseInt(b.readLine());
        }
        catch(Exception e)
        {
            System.out.println("Invalid Choice");
        }
        String string1=b.readLine();
        switch (choice)
        {
            case 1:

                   for(String str : args)
                   	System.out.println("The Length of the Given String is: "+str.length());
                   break;

            case 2:

                   mainObj.getCharArray(string1);
                   break;

            case 3:

                   mainObj.getCharPosition(string1);
                   break;

            case 4:

                   mainObj.getCharOccurence(string1);
                   break;

            case 5:

                   mainObj.getGreatPosition(string1);
                   break;

            case 6:

                   mainObj.subString(string1);
                   break;

            case 7:

                   mainObj.printFirstThreeCharacters(string1);
                   break;

            case 8:

                   mainObj.replace(string1);
                   break;

            case 9:

                   mainObj.stringStart(string1);
                   break;

            case 10:

                   mainObj.stringEnd(string1);
                   break;

            case 11:

                   mainObj.upperCase(string1);
                   break;

            case 12:

                   mainObj.lowerCase(string1);
                   break;

            case 13:

                   mainObj.reverse(string1);
                   break;

            case 14:

                   mainObj.multipleString(string1);
                   break;

            case 15:

                   mainObj.concat(string1);
		   break;
		
            case 16:

                   mainObj.stringArray(string1);
                   break;

            case 17:

                   mainObj.charInsert(string1);
                   break;

            case 18:

                   mainObj.equal(string1);
                   break;

            case 19:

                   mainObj.equalIgnoreCase(string1);
                   break;

            case 20:

                   mainObj.trim(string1);
                   break;	
        }
        sc.close();
        b.close();
         
    }        
}
