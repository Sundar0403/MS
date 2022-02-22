package implement;
import java.util.Map;

import account.AccountDetails;
import excep.*;
import pojo.CustomerDetails;


public interface ImplementorFunction 
{
	public void createFile(String filePath,String fileName) throws CustomException;
	public void writeFile(String filePath,String fileName) throws CustomException;
	public void readsFile(String filePath,String fileName)throws CustomException;
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerObj,int customerId) throws CustomException;
	public Map<Integer,Map<Integer,AccountDetails>> addAccount(AccountDetails accountObj,int customerId,int accountId) throws CustomException;
}
