<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HI</title>
<style>
form.red
{
	margin:0px;
	width:150px;
	height:300px;
	
}
</style>
</head>
<body>
<form action="LogoutServlet" method="post" name="logout"><button>Logout</button></form><br>
<form action="CustomerTransfer?customerId=<%= (int)session.getAttribute("customerId")  %>" class="red">
	<fieldset>
	<legend style="color:white;">Option</legend>
	<br><button>Transfer</button></a>
	</fieldset>
</form>		
</body>
</html>