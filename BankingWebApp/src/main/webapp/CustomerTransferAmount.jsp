<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="logic.BankLogic" %>
    <%@ page import="account.AccountDetails" %>
    <%@ page import="pojo.CustomerDetails" %>
    <%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRANSFER AMOUNT</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
<style>
form.true
{
	margin-left:800px;
	width:300px;
	background-color:white;
}
</style>
</head>
<body>
<% if(session.getAttribute("customerId")==null)
			{
				RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
				reqDispatch.forward(request,response);
			}%>

<jsp:include page="Customer.jsp"/>
	<center><h2>Transfer Amount</h2></center>
	<form class="true" action="CustomerTransferServlet" method="post">
		<fieldset style="background-color:white;">
		
		
		
		
		<label for="name" style="background-color:white;">From AccountId</label>
		<select id="name" name="fromActId">
		
		<% Map<Integer,AccountDetails> accountMap=(Map<Integer,AccountDetails>)request.getAttribute("accountMap");
		
				for(int key:accountMap.keySet())
				{
					
					AccountDetails accountObj=accountMap.get(key);
					if(accountObj.isAccountStatus()==true)
			       	{
		%>
		
			<option value="<% out.print(accountObj.getAccountId());%>"><% out.print(accountObj.getAccountId());%></option>
		
		<%
			       	}
			       	}
		%>
		
		</select><br>
		
		
		<br><label for="name1" style="background-color:white;">To AccountId</label>
		<select id="name1" name="toActId">
		
		
		<%
		Map<Integer, Map<Integer, AccountDetails>> newMap = (Map<Integer, Map<Integer, AccountDetails>>) request.getAttribute("customerAccount");
		

		for (Integer key : newMap.keySet()) {
			
			       Map<Integer,AccountDetails> inputMap=newMap.get(key);
			
			 	        for(Integer key1:inputMap.keySet())
			 	        {
			 	        	
				        AccountDetails account=inputMap.get(key1);
				       	if(account.isAccountStatus()==true)
				       	{	
		%>
		
			<option value="<% out.print(account.getAccountId());%>"><% out.print(account.getAccountId());%></option>
			
		<%
				       	}
			 	        }
		}
			
		%>	
			
		</select><br>
		
		<br><label for="Enter" style="background-color:white;">Transfer Amount:</label>
		<input type="number" id="Enter" min="100" max="100000" name="transferAmount"><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>