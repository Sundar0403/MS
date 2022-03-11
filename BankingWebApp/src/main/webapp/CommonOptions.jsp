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
<div>
<form>

	<a href="AddAccount.jsp"><input style="margin-left:1300px;"type="button" class="add" value="Add Account"></a>
	<a href="AddCustomer.jsp"><input style="margin-left:1300px;"type="button" class="add" value="Add Customer"></a></form>
	<form action="LogoutServlet" method="post" name="logout"><button>Logout</button></form><br>


</div>
<div>	
		<form action="CustomerServlet" method="post" name="getCustomer"><button>Customer</button></form>
		<br><form action="AccountServlet" method="post" name="getCustomer"><button>Account</button></form>
		<br><form action="AccountsDeposit" method="post" name="getDeposit"><button>Deposit</button></form>
		<br><form action="AccountsWithdraw" method="post" name="getWithdraw"><button>Withdraw</button></form>
		<br><a href="TransferAmount.jsp"><input type="button" value="Transfer"></a><br>
		<br><form action="DeactivatedAccount" method="post" name="deActivate"><button>Deactive<br> Accounts</button></form>
		<br><form action="DeactivatedCustomer" method="post" name="deActivate"><button>Deactive<br> Customers</button></form>
</div>
</body>
</html>