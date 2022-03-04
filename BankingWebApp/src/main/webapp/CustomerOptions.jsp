<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
</head>
<body>
<h1>Customer Page</h1>

<form>
<fieldset>
	<legend>Option</legend>
	<br><a href="TransferAmount.jsp"><input type="button" value="Transfer"></a>
	</fieldset>
</form>
<table style="background-color:white;">
<tr class="main">
	<th>AccountId</th>
	<th>Balance</th>
	<th>Branch</th>
</tr>
<tr class="sub">
	<td>101</td>
	<td>5000.50</td>
	<td>Pallathur</td>
</tr>
<tr class="sub">
	<td>102</td>
	<td>4000.00</td>
	<td>Karaikudi</td>
</tr><tr class="sub">
	<td>103</td>
	<td>1500.00</td>
	<td>Pallathur</td>
</tr><tr class="sub">
	<td>104</td>
	<td>10000.00</td>
	<td>Karaikudi</td>
</tr>	
</table>
</body>
</html>