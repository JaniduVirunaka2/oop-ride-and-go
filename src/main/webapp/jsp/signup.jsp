<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign up Form</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css" />
  </head>
  <body>
  <%@ include file="/jsp/header.jsp" %>
	  <div class="div-body">
	    <div class="signup-container">
	      <h2>Create Your Account</h2>
	      <%-- Display error message if present --%>
   			 <c:if test="${not empty errorMessage}">
        		<p style="color: red;">${errorMessage}</p>
   			 </c:if>

   		 <%-- Display success message if present --%>
    		<c:if test="${not empty successMessage}">
       			 <p style="color: green;">${successMessage}</p>
   			 </c:if>
   			 
	      <form action="${pageContext.request.contextPath}/signup" method="post">
	        <div class="form-group">
	          <label for="name">Name:</label>
	          <input type="text" id="name" name="name" placeholder="Enter your name" required/>
	        </div>
	        <div class="form-group">
	          <label for="email">Email:</label>
	          <input type="email" id="email" name="email" placeholder="Enter your email" required />
	        </div>
	        <div class="form-group">
	          <label for="phone">Phone:</label>
	          <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required />
	        </div>
	        <div class="form-group">
	          <label for="username">Username:</label>
	          <input type="text" id="username" name="username" placeholder="Choose a username"  required />
	        </div>
	        <div class="form-group">
	          <label for="password">Password:</label>
	          <input type="password" id="password" name="password" placeholder="Choose a password" required/>
	        </div>
	        <div class="form-group">
	          <label for="repassword">Re-enter Password:</label>
	          <input type="password"id="repassword" name="repassword" placeholder="Re-enter your password" required/>
	        </div>
	        <div class="form-group">
	          <button type="submit">Sign Up</button>
	        </div>
	        <p class="login-link">
	          Already have an account? <a href="login.jsp">Log in here</a>.
	        </p>
	      </form>
	    </div>
    </div>
    
    <%@ include file="/jsp/footer.jsp" %>
  </body>
</html>
