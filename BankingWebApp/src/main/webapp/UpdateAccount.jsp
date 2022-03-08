<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="account.AccountDetails" %>
    <%@page import="java.util.Map" %>
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
	<form action="UpdateCustomer" class="new" method="post" name="customer">
<fieldset class="green">
	<h2>ACCOUNT UPDATION</h2>
	<%
	
		AccountDetails accountObj=(AccountDetails)request.getAttribute("accountDetails");
	%>
	
	<label for="name">CustomerId:</label>
	<input type="number" id="name" name="custId" readOnly value="<%out.print(accountObj.getCustomerId());%>"  required><br><br>
	<label for="name">AccountId:</label>
	<input type="text" id="name" name="custName" value="<%out.print(accountObj.getAccountId());%>"  required><br><br>
	<label for="name">AccountBranch:</label>
	<input type="text" id="name" name="address" value="<% out.print(accountObj.getBranchName());%>"  required><br><br>
	<label for="name">AccountBalance:</label>
	<input type="number" id="name" name="mobNo" value="<% out.print(accountObj.getAccountBalance());%>" required><br><br>
	<input type="button" name="" value="Reset">
	<button>Finish</button>
	
</fieldset>	
</form>
</div>
</body>
</html>