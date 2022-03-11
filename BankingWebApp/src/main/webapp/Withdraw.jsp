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
<title>WITHDRAW</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
<style>
form.true
{
	margin-left:800px;
	background-color:white;
}
</style>
</head>
<body>
<jsp:include page="CommonOptions.jsp"/>
	<center><h2>Withdraw Amount</h2></center>
	<form class="true" action="WithdrawServlet" method="post">
		<fieldset>
		
		
		<label for="name1" style="background-color:white;">AccountId:</label>
		<select name="actId" >
		
		<%Map<Integer,Map<Integer,AccountDetails>> customerAccountMap=(Map<Integer,Map<Integer,AccountDetails>>)request.getAttribute("Account"); 
		 out.print(customerAccountMap);
			
			for(int key:customerAccountMap.keySet())
			{
				Map<Integer,AccountDetails> accountMap=customerAccountMap.get(key);
				
				for(int innerKey:accountMap.keySet())
				{
					AccountDetails accountObj=accountMap.get(innerKey);
					if(accountObj.isAccountStatus()==true)
					{	
		
		%>
		
		<option value="<%out.print(accountObj.getAccountId()); %>"><%out.print(accountObj.getAccountId()); %></option>
		
		<%
					}
				}
			}
		
		%>
		
		</select><br><br>
		
		<br><label for="Enter" style="background-color:white;" required>Withdraw Amount:</label>
		<input type="number" id="Enter" name="withdrawAmount"><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>