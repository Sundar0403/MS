<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="logic.BankLogic"%>
<%@page import="account.AccountDetails"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN HOME PAGE</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
</head>
<body>
	<jsp:include page="CommonOptions.jsp" />

	<center>
		<h2>ACCOUNT DETAILS</h2>
	</center>

	<table bgcolor="white">
		<tr class="main">

			
			<th>AccountId</th>
			<th>AccountNumber</th>
			<th>AccountBalance</th>
			<th>BranchName</th>
			<th>Status Change</th>
		</tr>

		<%
		Map<Integer, Map<Integer, AccountDetails>> newMap = (Map<Integer, Map<Integer, AccountDetails>>) request
				.getAttribute("AccountDetails");
		

		for (Integer key : newMap.keySet()) {
			
			       Map<Integer,AccountDetails> inputMap=newMap.get(key);
			
			 	        for(Integer key1:inputMap.keySet())
			 	        {
			 	        	
				        AccountDetails accountObj=inputMap.get(key1);
				        if(accountObj.isAccountStatus()==true)
				        {
		%>
			<tr>
			
			<td><form action="updateAccount" method="post">
			<button><%out.print(accountObj.getAccountId()); %></button></form></td>
			<td><%out.print(accountObj.getAccountNumber()); %></td>
			<td><%out.print(accountObj.getAccountBalance()); %></td>
			<td><%out.print(accountObj.getBranchName()); %></td>
			<td><form action="Deactivate?customerId=<%=accountObj.getCustomerId()  %>&accountId=<%=accountObj.getAccountId()  %>" method="post" ><button>Deactivate</button></form></td>
			</tr>
		<%
				        }
				       }
		}
		%>
	</table>
</body>
</html>