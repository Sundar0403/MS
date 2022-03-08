<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="account.AccountDetails" %>
    <%@page import="java.util.Map" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAILS</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
</head>
<body>
<h1>Customer Page</h1>

<jsp:include page="Customer.jsp"/>
<table style="background-color:white;">
<tr class="main">
	<th>CustomerId</th>
	<th>AccountId</th>
	<th>AccountNumber</th>
	<th>AccountStatus</th>
	<th>AccountBalance</th>
	<th>BranchName</th>
</tr>


<%Map<Integer,AccountDetails>inputMap=(Map<Integer,AccountDetails>)request.getAttribute("CustomerAccountDetails"); 
		for(Object key:inputMap.keySet())
		{
			AccountDetails accountObj=inputMap.get(key);
	%>
		<tr>
			<td><%out.print(accountObj.getCustomerId()); %></td>
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