<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="pojo.CustomerDetails" %>
    <%@page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER UPDATION</title>
<link rel="stylesheet" type="text/css" href="Admin.css">
</head>
<body>
	<jsp:include page="CommonOptions.jsp"/>
	<div class="id3">
	<form action="UpdateCustomer" class="new" method="post" name="customer">
<fieldset class="green">
	<h2>Customer Updation</h2>
	<%
	
		CustomerDetails custObj=(CustomerDetails)request.getAttribute("customerDetails");
	%>
	
	<label for="name">CustomerId:</label>
	<input type="number" id="name" name="custId" readOnly value="<%out.print(custObj.getCustomerId());%>"  required><br><br>
	<label for="name">CustomerName:</label>
	<input type="text" id="name" name="custName" value="<%out.print(custObj.getCustomerName());%>"  required><br><br>
	<label for="name">CustomerAddress:</label>
	<input type="text" id="name" name="address" value="<% out.print(custObj.getCustomerAddress());%>"  required><br><br>
	<label for="name">CustomerMobileNumber:</label>
	<input type="number" id="name" name="mobNo" value="<% out.print(custObj.getMobileNumber());%>" required><br><br>
	<input type="button" name="" value="Reset">
	<button>Finish</button>
	
</fieldset>	
</form>
</div>
</body>
</html>