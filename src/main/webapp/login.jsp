<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" href = "static/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
	<title>Login</title>
	<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	</style>
	
</head>
<body>
	<h1>Login Page</h1>
	<form action="login" method="post">
		User Name <input type="text" name="username" placeholder="Enter your username"><br><br>
		Password <input type="password" name="password" placeholder="Enter your password"><br><br>
		<input type="submit" name="submit" value="Login">
	</form>

</body>
</html>