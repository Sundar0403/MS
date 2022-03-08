<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="account.AccountDetails" %>
<%@page import="logic.BankLogic" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAILS</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
</head>
<body>
<jsp:include page="CommonOptions.jsp"/>
<center><h2>ACCOUNT DETAILS</h2></center>
<table bgcolor="white">
		<tr class="main">

			<th>AccountId</th>
			<th>AccountNumber</th>
			<th>AccountStatus</th>
			<th>AccountBalance</th>
			<th>BranchName</th>
		</tr>

		<%
		Map<Integer, AccountDetails> newMap = (Map<Integer, AccountDetails>) request
				.getAttribute("accountMap");
		

		for (Integer key : newMap.keySet()) {
	
				        AccountDetails accountObj=newMap.get(key);
		%>
			<tr>
			<td><%out.print(accountObj.getAccountId()); %></td>
			<td><%out.print(accountObj.getAccountNumber()); %></td>
			<td><%out.print(accountObj.isAccountStatus()); %></td>
			<td><%out.print(accountObj.getAccountBalance()); %></td>
			<td><%out.print(accountObj.getBranchName()); %></td>
			</tr>
		<%
			        }
		
		%>
	</table>
</body>
</html>