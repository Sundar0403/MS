<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="TransferAmount.css">
</head>
<body>
	<h2>Transfer Amount</h2>
	<form action="TransferServlet" method="post">
		<fieldset>
		<label for="name">CustomerId:</label>
		<input type="number" id="name" name="custId" required><br><br>
		<label for="name">AccountId:</label>
		<select id="from" name="from">
			<option value="01">01</option>
			<option value="02">02</option>
		</select><br><br>
		
		<label for="toname">To AccountId:</label>
		<select id="to" name="to">
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
		</select><br><br>
		<label for="Enter">Transfer Amount:</label>
		<input type="number" name="amount" id="Enter" min="100" max="100000" required><br><br>
		<button>Submit</button>
		</fieldset>
	</form>
</body>
</html>