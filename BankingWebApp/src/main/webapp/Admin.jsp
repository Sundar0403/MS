<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
<link rel="stylesheet" type="text/css" href="Admin.css">
</head>
<body>
<div>
<h1><marquee>Welcome to Login Page!!!!</marquee></h1>
</div>
<div class="id">
<form action="LoginServlet" method="post" name="loginForm">
<fieldset class="blue">
	<h2>Login</h2>
	<label for="name">UserName :</label>
	<input type="number" id="name" name="username" required>
	<br><label for="name">Password :</label>
	<input type="password" id="name" name="password" required><br><br>
	<input type="button" name="" value="Reset">
	<button>Login</button>
</fieldset>	
</form>
</div>
</body>
</html>