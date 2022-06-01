<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER ADDITION</title>
<link rel="stylesheet" type="text/css" href="Admin.css">
</head>
<body>
	<jsp:include page="CommonOptions.jsp"/>
	<div class="id3" style="margin-top:-300px;">
	<form action="AddCustomer" class="new" method="post" name="customer">
<fieldset class="green">
	<h2>Customer Addition</h2>
	<label for="name">CustomerStatus</label>
	<input type="text" id="name" name="custStatus" required><br><br>
	<label for="name">CustomerName:</label>
	<input type="text" id="name" name="custName" required><br><br>
	<label for="name">CustomerAddress:</label>
	<input type="text" id="name" name="address" required><br><br>
	<label for="name">CustomerMobileNumber:</label>
	<input type="number" id="name" name="mobNo" required><br><br>
	<input type="button" name="" value="Reset">
	<button>Finish</button>
</fieldset>	
</form>
</div>
</body>
</html>