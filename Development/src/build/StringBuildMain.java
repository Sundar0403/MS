package build;
import run.*;
import logic.*;
import java.util.*;
import excep.*;


public class StringBuildMain
{
    
    StringBuildFunc obj=new StringBuildFunc();
    StringFunc buildObj=new StringFunc();
    Scanner scan=new Scanner(System.in);
    
    private void buildString(StringBuilder newBuilder)
    {
    	String string1=scan.nextLine();
        try
        {
        	System.out.println("The Length of StringBuilder : "+obj.getLength(newBuilder));
        	System.out.println("Final String : "+obj.buildString(string1,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildAppend(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Number of Strings");
        int num=0;
        try
        {
        	num=scan.nextInt();
        }
        catch(Exception e)
        {
               System.out.println("Invalid Type Format");
               e.printStackTrace();
        }
        scan.nextLine();
        System.out.println("Enter the String :");
        String firstString=scan.nextLine();
        try
        {
        	System.out.println(" First String : "+obj.buildAppendFirst(firstString,newBuilder)+" Length of the StringBuilder : "+obj.getLength(newBuilder));
               String string12[]=new String[num];
               for(int i=0;i<num;i++)
               {
               	string12[i]=scan.nextLine();
               }
               System.out.println("Enter the Character :");
               char charact=scan.next().charAt(0);
               System.out.println("Final String : "+obj.buildAppendLast(string12,charact,firstString,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildInsert(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings :");
        String string2=scan.nextLine();
        String string4=scan.nextLine();
        System.out.println("Enter the Character to be Inserted : ");
        String insertingChar=scan.nextLine();
        try
        {	
        	newBuilder=obj.buildAppendFirst(string2,newBuilder);
        	System.out.println("Intial String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("Final String : "+obj.buildAfterInsert(newBuilder,string4,insertingChar)+" Length : "+obj.getLength(newBuilder));
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
    private void buildDelete(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings :");
        String string5=scan.nextLine();
        String string6=scan.nextLine();
        System.out.println("Enter the Characters to be Inserted : ");
        String delChar=scan.nextLine();
        System.out.println("Enter the Number : ");
        int number=scan.nextInt();
        try
        {	
        	newBuilder=obj.buildAppendFirst(string5,newBuilder);
    		newBuilder=obj.buildAppendFirst(delChar,newBuilder);
    		newBuilder=obj.buildAppendFirst(string6,newBuilder);
        	System.out.println("Intial String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("Final String : "+obj.buildAfterDelete(string5,number,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildReplace(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings:");
        String string7=scan.nextLine();
        String string8=scan.nextLine();
        String string9=scan.nextLine();
        System.out.println("Enter the Characters to be Inserted:");
        String firstChar=scan.nextLine();
        String replaceChar=scan.nextLine();
        try
        {
        	newBuilder=obj.buildAppendFirst(string7,newBuilder);
        	newBuilder=obj.buildAppendFirst(firstChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string8,newBuilder);
        	newBuilder=obj.buildAppendFirst(firstChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string9,newBuilder);
        	System.out.println("Intial String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("Final String : "+obj.buildAfterReplace(firstChar,replaceChar,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildReverse(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings:");
        String string10=scan.nextLine();
        String string11=scan.nextLine();
        String string13=scan.nextLine();
        System.out.println("Enter the Characters to be Inserted : ");
        String insertChar=scan.nextLine();
        try
        {	
        	newBuilder=obj.buildAppendFirst(string10,newBuilder);
        	newBuilder=obj.buildAppendFirst(insertChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string11,newBuilder);
        	newBuilder=obj.buildAppendFirst(insertChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string13,newBuilder);
        	System.out.println("Intial String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("Final String : "+obj.buildAfterReverse(newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void add(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings");
        String string14=scan.nextLine();
        String string15=scan.nextLine();
        System.out.println("Enter the Position to Insert : ");
        int posStart=scan.nextInt();
        int posEnd=scan.nextInt();
        try
        {
        	newBuilder=obj.buildAppendFirst(string14,newBuilder);
        	System.out.println("Final String : "+obj.buildAdd(string15,posStart,posEnd,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildReducer(StringBuilder newBuilder)
    {
    	System.out.println("Enter the String : ");
        String string16=scan.nextLine();
        System.out.println("Enter the Position to Delete : ");
        int delPosStart=scan.nextInt();
        int delPosEnd=scan.nextInt();
        try
        {
        	newBuilder=obj.buildAppendFirst(string16,newBuilder);
        	System.out.println("Final String : "+obj.buildReduce(delPosStart,delPosEnd,newBuilder)+" Length : "+obj.getLength(newBuilder));
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
    private void buildFirstIndex(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings : ");
        String string17=scan.nextLine();
        String string18=scan.nextLine();
        String string19=scan.nextLine();
        System.out.println("Enter the Character to be Inserted : ");
        String indexCharacter=scan.nextLine();
        try
        {
        	newBuilder=obj.buildAppendFirst(string17,newBuilder);
        	newBuilder=obj.buildAppendFirst(indexCharacter,newBuilder);
        	newBuilder=obj.buildAppendFirst(string18,newBuilder);
        	newBuilder=obj.buildAppendFirst(indexCharacter,newBuilder);
        	newBuilder=obj.buildAppendFirst(string19,newBuilder);
        	System.out.println("Final String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("The Index of the Character is : "+obj.buildFindIndex(indexCharacter,newBuilder));
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
    private void buildLastIndex(StringBuilder newBuilder)
    {
    	System.out.println("Enter the Strings : ");
        String string20=scan.nextLine();
        String string21=scan.nextLine();
        String string22=scan.nextLine();
        System.out.println("Enter the Character to be Inserted : ");
        String lastIndexChar=scan.nextLine();
        try
        {
        	newBuilder=obj.buildAppendFirst(string20,newBuilder);
        	newBuilder=obj.buildAppendFirst(lastIndexChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string21,newBuilder);
        	newBuilder=obj.buildAppendFirst(lastIndexChar,newBuilder);
        	newBuilder=obj.buildAppendFirst(string22,newBuilder);
        	System.out.println("Final String : "+newBuilder+" Length : "+obj.getLength(newBuilder));
        	System.out.println("The Last Index of the Character is : "+obj.buildAfterFindLastIndex(lastIndexChar,newBuilder));
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
    public static void main(String args[])
    {
        StringBuildFunc obj=new StringBuildFunc();
        StringBuildMain mainObj=new StringBuildMain();
        StringFunc buildObj=new StringFunc();
        Scanner scan=new Scanner(System.in);
        StringBuilder newBuilder=obj.createBuilder();
        System.out.println("Enter Your Choice");
        int choice=0;
        try
        {
            choice=scan.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Invalid Choice");
        }
        switch(choice)
        {
        	case 1:
        	
        		mainObj.buildString(newBuilder);
        		break;	
        	case 2:
        		
                	mainObj.buildAppend(newBuilder);
                	break;
                case 3:

        		mainObj.buildInsert(newBuilder);	
        		break;
        	case 4:

        		mainObj.buildDelete(newBuilder);	
        		break;
        	case 5:

        		mainObj.buildReplace(newBuilder);	
        		break;
        	case 6:

        		mainObj.buildReverse(newBuilder);	
        		break;
        	case 7:
        	
        		mainObj.add(newBuilder);	
        		break;
        	case 8:

        		mainObj.buildReducer(newBuilder);	
        		break;
        	case 9:

        		mainObj.buildFirstIndex(newBuilder);	
        		break;
        	case 10:

        		mainObj.buildLastIndex(newBuilder);									
        		break;
        }		
    }
}


