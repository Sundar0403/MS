package logic;
import run.*;
import java.util.*;
import excep.*;

public class StringBuildFunc
{	
     StringFunc funcObj=new StringFunc();	
    public void stringBuilderCheck(StringBuilder inputString) throws CustomException
        {
            if(inputString==null)
            {
                throw new CustomException("String Builder Can't be Null");
            }
        }
       public StringBuilder createBuilder()
       {
       	StringBuilder buildString=new StringBuilder();
       	return buildString;
       }
       public int getLength(StringBuilder inputBuilder) throws CustomException
       {
       	stringBuilderCheck(inputBuilder);
       	int length=inputBuilder.length();
       	return length;
       }
    public StringBuilder buildString(String inputString,StringBuilder inputBuilder) throws CustomException
    {
        stringBuilderCheck(inputBuilder);
        funcObj.stringCheck(inputString);
        inputBuilder.append(inputString);
        return inputBuilder;
    }
    public StringBuilder buildAppendFirst(String inputString,StringBuilder inputBuilder) throws CustomException
    {
    	stringBuilderCheck(inputBuilder);
    	funcObj.stringCheck(inputString);
    	inputBuilder.append(inputString);
       return inputBuilder;
    }
    public StringBuilder buildAppendLast(String strArray[],char character,String inputString,StringBuilder inputBuilder) throws CustomException
    {
    	inputBuilder.append(character);
    	for(int i=0;i<strArray.length;i++)
       {
       	inputBuilder.append(strArray[i]);
       	inputBuilder.append(character);	
       }
       inputBuilder.deleteCharAt(inputBuilder.length()-1);
       return inputBuilder;
    }
    public StringBuilder buildAfterInsert(StringBuilder inputBuilder,String inputString,String insertChar) throws CustomException
    {
        stringBuilderCheck(inputBuilder);
        stringBuilderCheck(inputBuilder);
        funcObj.stringCheck(inputString);
        int insertPos=buildFindIndex(insertChar,inputBuilder);
        inputBuilder.insert(insertPos+1, inputString+insertChar);
        return inputBuilder;
    }
    public StringBuilder buildAfterDelete(String inputString,int number,StringBuilder inputBuilder) throws CustomException
    {	
    	stringBuilderCheck(inputBuilder);
    	funcObj.stringCheck(inputString);
    	int length=funcObj.getLength(inputString);    	
    	inputBuilder.delete(0,length+number);
    	return inputBuilder;
    }
    public StringBuilder buildAfterReplace(String firstChar,String replaceChar,StringBuilder inputBuilder) throws CustomException   
    {
        stringBuilderCheck(inputBuilder);
        funcObj.stringCheck(firstChar);
        funcObj.stringCheck(replaceChar);
        String str=inputBuilder.toString();
        str=str.replaceAll(firstChar,replaceChar);
        //return str;
        inputBuilder.delete(0,inputBuilder.length());
        inputBuilder.append(str);
        return inputBuilder;
    }   
    public StringBuilder buildAfterReverse(StringBuilder inputBuilder) throws CustomException
    { 
        stringBuilderCheck(inputBuilder);
        inputBuilder.reverse();
        return inputBuilder;
    }
    public StringBuilder buildAdd(String finalString,int startPos,int endPos,StringBuilder inputBuilder) throws CustomException
    {
        stringBuilderCheck(inputBuilder);
        funcObj.numCheck(startPos,endPos);
	inputBuilder=inputBuilder.replace(startPos,endPos,finalString);
        return inputBuilder;
    }
     public StringBuilder buildReduce(int startPos,int endPos,StringBuilder inputBuilder) throws CustomException
    {
        stringBuilderCheck(inputBuilder);
        funcObj.numCheck(startPos,endPos);
        inputBuilder=inputBuilder.delete(startPos,endPos);
        return inputBuilder;
    }
    public int buildFindIndex(String characterIndex,StringBuilder inputBuilder) throws CustomException
    {
    	stringBuilderCheck(inputBuilder);
        funcObj.stringCheck(characterIndex);
    	int index=inputBuilder.indexOf(characterIndex);
        return index;
    }
    public int buildAfterFindLastIndex(String charLastIndex,StringBuilder inputBuilder) throws CustomException 
    {   
        stringBuilderCheck(inputBuilder);
        funcObj.stringCheck(charLastIndex);
        int lastIndex=inputBuilder.lastIndexOf(charLastIndex);
        return lastIndex;
    }
    
}
