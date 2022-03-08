<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CommonOptions.css">
</head>
<body>
<form>
	<a href="AddAccount.jsp"><input style="margin-left:1300px;"type="button" class="add" value="Add Account"></a>
	<a href="AddCustomer.jsp"><input style="margin-left:1300px;"type="button" class="add" value="Add Customer"></a>
	<a href="Admin.jsp"><input style="margin-left:1300px;"type="button" class="add" value="Logout"></a>
</form>

		<form action="CustomerServlet" method="post" name="getCustomer"><button>Customer</button></form>
		<br><form action="AccountServlet" method="post" name="getCustomer"><button>Account</button></form>
		<br><a href="Deposit.jsp"><input type="button" value="Deposit"></a><br>
		<br><a href="Withdraw.jsp"><input type="button" value="Withdraw"></a><br>
		<br><a href="TransferAmount.jsp"><input type="button" value="Transfer"></a><br>
		<br><a href="Update.jsp"><input type="button" value="Update"></a>

</body>
</html>