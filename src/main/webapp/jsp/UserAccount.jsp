<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	
		table, th, td {
  			border: 1px solid black;
		}
	</style>
</head>
<body>

	<table>
	<c:forEach var="us" items="${usDetails}">
	
	<c:set var="id" value="${us.id}"/>
	<c:set var="name" value="${us.name}"/>
	<c:set var="email" value="${us.email}"/>
	<c:set var="phone" value="${us.phone}"/>
	<c:set var="username" value="${us.userName}"/>
	<c:set var="password" value="${us.password}"/>
	
	<tr>
		<td>Customer ID</td>
		<td>${us.id}</td>
	</tr>
	<tr>
		<td>Customer Name</td>
		<td>${us.name}</td>
	</tr>
	<tr>
		<td>Customer Email</td>
		<td>${us.email}</td>
	</tr>
	<tr>
		<td>Customer Phone</td>
		<td>${us.phone}</td>
	</tr>
	<tr>
		<td>Customer User Name</td>
		<td>${us.userName}</td>
	</tr>

	</c:forEach>
	</table>
	
	<c:url value="updatecustomer.jsp" var="usupdate">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="phone" value="${phone}"/>
		<c:param name="uname" value="${username}"/>
		<c:param name="pass" value="${password}"/>
	</c:url>
	
	<a href="${usupdate}">
	<input type="button" name="update" value="Update My Data">
	</a>
	
	<br>
	<c:url value="deletecustomer.jsp" var="usdelete">
		<c:param name="id" value="${id}" />
		<c:param name="name" value="${name}" />
		<c:param name="email" value="${email}" />
		<c:param name="uname" value="${username}" />
		<c:param name="pass" value="${password}" />
	</c:url>
	<a href="${usdelete}">
	<input type="button" name="delete" value="Delete My Account">
	</a>
	
	
	
	
</body>
</html>