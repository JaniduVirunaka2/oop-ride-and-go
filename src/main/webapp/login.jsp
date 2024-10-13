<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
  </head>
  <body>
    <%@ include file="/jsp/header.jsp" %>


    <div class="login-container">
      <form class="login-form">
        <h3>Login</h3>
    
        <label for="username">
        <p>Username :</p>
        </label>
        <input type="text" name="username" placeholder="Enter your username"/>

        <!-- Password input field -->
        <label for="password"><p>Password:</p></label>
        <input type="password" name="password" placeholder="Enter your password"/>

        <!-- Log In button in the center of the form -->
        <button type="submit">Login</button>
      </form>
    </div>

    <!-- Footer Section -->
    <%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
