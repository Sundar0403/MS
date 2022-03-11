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
<% if(session.getAttribute("customerId")==null)
{
	RequestDispatcher reqDispatch=request.getRequestDispatcher("Login.jsp");
	reqDispatch.forward(request,response);
}%>
<jsp:include page="CommonOptions.jsp"/>
	<center><h2>Transfer Amount</h2></center>
	<form class="true" action="TransferServlet" method="post">
		<fieldset>
		
		<label for="name" style="background-color:white;">From AccountId</label>
		<input type="number" id="name" name="fromActId" required><br><br>
		
		<label for="name1" style="background-color:white;">To AccountId:</label>
		<input type="number" id="name1" name="toActId" required><br><br>
		
		<br><label for="Enter" style="background-color:white;">Transfer Amount:</label>
		<input type="number" id="Enter" min="100" max="100000" name="transferAmount" required><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>