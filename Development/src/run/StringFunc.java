package run;
import java.util.*;
import excep.*;

public class StringFunc
    {
        public void stringCheck(String inputString) throws CustomException
        {
            if(inputString==null||inputString.isEmpty())
            {
                throw new CustomException("String Can't be Null or Empty");
            }
        }
        public void stringArrayCheck(String inputString[]) throws CustomException
        {
            for(String checkString:inputString)
            {
                stringCheck(checkString);
            }
        }
        public void numCheck(int number,int length) throws CustomException
        {
        	if(number<0||number>length)
        	{
        		throw new CustomException("Number Can't be Less Than 0 or Out of Range");
        	}
        }
        public int getLength(String inputString) throws CustomException
        {
        		stringCheck(inputString);
        		int len=inputString.length();
        		return len;	
        }
        public char[] stringToCharArray(String inputString) throws CustomException
        {
            stringCheck(inputString);
            char character[]=inputString.toCharArray();
            return character;
        }
     
        public int getCharPos(String inputString,char character) throws CustomException
        {
            stringCheck(inputString);
            int index=inputString.indexOf(character);
            return index;
        }
        public int charOccurence(String inputString,char letter) throws CustomException
        {
            int length=getLength(inputString);
            char character[]=stringToCharArray(inputString);
            int count=0;
            for(int i=0;i<length;i++)
            {
                if(letter==character[i])
                {
                    count++;
                }
            }
            return count;
        }
        public int charGreatestPos(String inputString,char character) throws CustomException
        {
            stringCheck(inputString);
            int index=inputString.lastIndexOf(character);
            return index;
        }
        public String stringSubStr1(String inputString,int position) throws CustomException
        {
            int length=getLength(inputString);
            numCheck(position,length);
            String subString=inputString.substring(length-position);
            return subString;
        }
        public String stringSubStr2(String inputString,int position) throws CustomException
        {
            stringCheck(inputString);
            int length=getLength(inputString);
            numCheck(position,length);
            String subString=inputString.substring(0,position);
            return subString;
        }
        public String stringReplace(String inputString,String addString,int startPosition,int endPosition) throws CustomException
        {
            int length=getLength(inputString);
            numCheck(startPosition,length);
            numCheck(endPosition,length);
            stringCheck(inputString);
            addString=inputString.substring(0,startPosition)+addString+inputString.substring(endPosition);
            return addString;
        }    
        public boolean startString(String inputString,String checkString) throws CustomException
        {
            stringCheck(inputString);
            stringCheck(checkString);
            boolean boo=inputString.startsWith(checkString);
            return boo;
        }
        public boolean endString(String inputString,String checkString) throws CustomException
        {
            stringCheck(inputString);
            stringCheck(inputString);
            boolean boo=inputString.endsWith(checkString);
            return boo;
        }
        public String stringUpperCase(String inputString) throws CustomException
        {
            stringCheck(inputString);
            inputString=inputString.toUpperCase();
            return inputString;
        }
        public String stringLowerCase(String inputString) throws CustomException
        {
            stringCheck(inputString);
            inputString=inputString.toLowerCase();
            return inputString;
        }
        public String stringReverse(String inputString) throws CustomException
        {
            int length=getLength(inputString);
            String outputString="";
            for(int i=length-1;i>=0;i--)
            {
                outputString=outputString+inputString.charAt(i);
            }
            return outputString;
        }
        public String multiString(String inputString) throws CustomException
        {
            stringCheck(inputString);
            return inputString;
        }
        public String stringConcat(String inputString) throws CustomException
        {
            stringCheck(inputString);
            String outputString=inputString.replaceAll(" ","");
            return outputString;
        }
        public String[] stringArray(String inputString) throws CustomException
        {
            stringCheck(inputString);
            String[] arrayString=inputString.split(" ");
            return arrayString;
        }
        public String stringMerge(String inputString[],String character) throws CustomException
        {
            stringArrayCheck(inputString);
	    String outputString = "";
            outputString = String.join(character, inputString);		
            return outputString; 
        }
        public boolean equalsSensitive(String mainString,String compareString) throws CustomException
        {
            stringCheck(mainString);
            stringCheck(compareString);
            boolean boo=mainString.equals(compareString);
            return boo;
        }
        public boolean equalsInSensitive(String mainString,String compareString) throws CustomException
        {
            stringCheck(mainString);
            stringCheck(compareString);
            boolean boo=mainString.equalsIgnoreCase(compareString);
            return boo;
        }
        public String stringTrim(String inputString) throws CustomException
        {
            stringCheck(inputString);
            inputString=inputString.trim();
            return inputString;
        }
}
