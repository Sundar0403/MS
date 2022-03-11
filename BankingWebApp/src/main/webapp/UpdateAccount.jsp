<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="account.AccountDetails" %>
    <%@page import="java.util.Map" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCOUNT UPDATION</title>
<link rel="stylesheet" type="text/css" href="Admin.css">
</head>
<body>
	<jsp:include page="CommonOptions.jsp"/>
	<div class="id3">
	<form action="UpdateAccount" class="new" method="post" name="customer">
<fieldset class="green">
	<h2>ACCOUNT UPDATION</h2>
	<%
	
		AccountDetails accountObj=(AccountDetails)request.getAttribute("AccountDetails");
	%>
	
	<label for="name">CustomerId:</label>
	<input type="number" id="name" name="customerId" readOnly value="<%out.print(accountObj.getCustomerId());%>"  required><br><br>
	<label for="name">AccountId:</label>
	<input type="text" id="name" name="accountId" readOnly value="<%out.print(accountObj.getAccountId());%>"  required><br><br>
	<label for="name">AccountNo:</label><br>
	<input type="number" id="name" name="accountNo" value="<%out.print(accountObj.getAccountNumber());%>"  required><br><br>
	<label for="name">AccountBranch:</label><br>
	<select name="branch">
	<%
		List<String> branch=(List<String>)request.getAttribute("branch");
		for(int i=0;i<branch.size();i++)
		{
	%>
		<option value="<%out.print(branch.get(i)); %>"><% out.print(branch.get(i));%></option>
		
	<%
		}
	%>	
	
	</select><br><br>
	<label for="name">AccountBalance:</label>
	<input type="number" id="name" name="balance" readOnly value="<% out.print(accountObj.getAccountBalance());%>" required><br><br>
	<input type="button" name="" value="Reset">
	<button>Finish</button>
	
</fieldset>	
</form>
</div>
</body>
</html>