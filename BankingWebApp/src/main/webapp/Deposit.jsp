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
<title>DEPOSIT</title>
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
	<center><h2>Deposit Amount</h2></center>
	<form class="true" action="Deposit" method="post">
		<fieldset>
		
		
		<label for="name1" style="background-color:white;">AccountId:</label>
		<input type="number" id="name1" name="actId"><br><br>
		
		<br><label for="Enter" style="background-color:white;">Deposit Amount:</label>
		<input type="number" id="Enter" min="100" max="100000" name="depositAmount"><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>