<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
<link rel="stylesheet" type="text/css" href="Admin.css">
<style>
button
{
	background-color:grey;
	color:white;
	border-radius:7px;	
}
button:hover
{
	background-color:red;
	color:black;
	border-radius:7px;	
}
</style>

</head>
<body>
<div>

</div>
<div class="id">
<form action="LoginServlet" method="post" name="loginForm">
<fieldset class="blue">

	<h2>Login</h2>
	<label for="name">UserName :</label>
	<input type="number" id="name" name="username" required>
	<br><label for="name">Password :</label>
	<input type="password" id="password" name="password" required><br><br>
	<button style="margin-left:150px;">Login</button>
</fieldset>	
</form>
</div>
</body>
</html>