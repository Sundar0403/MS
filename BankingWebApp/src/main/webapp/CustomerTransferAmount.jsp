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
	background-color:white;
}
</style>
</head>
<body>
<jsp:include page="Customer.jsp"/>
	<center><h2>Transfer Amount</h2></center>
	<form class="true" action="TransferServlet" method="post">
		<fieldset style="background-color:white;">
		
		<label for="name" style="background-color:white;">From CustomerId</label>
		<input type="number" id="name" name="fromCustId"><br><br>
		
		<label for="name" style="background-color:white;">From AccountId</label>
		<input type="number" id="name" name="fromActId"><br><br>
		
		
		<label for="name1" style="background-color:white;">To CustomerId:</label>
		<input type="number" id="name1" name="toCustId"><br><br>
		
		<label for="name1" style="background-color:white;">To AccountId:</label>
		<input type="number" id="name1" name="toActId"><br><br>
		
		<br><label for="Enter" style="background-color:white;">Transfer Amount:</label>
		<input type="number" id="Enter" min="100" max="100000" name="transferAmount"><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>