<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_footer.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Optionally include Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

	<header>
		<nav class="navbar">
			<!-- Site logo on the left -->
			<img src="../images/sitelogo.jpg" alt="Site Logo" width="80"
				height="80" />

			<!-- Navigation links and Search bar -->
			<div class="nav-container">
				<!-- Navigation links -->
				<ul class="nav-links">
					<li><a href="jsp/HomePage.jsp">Home</a></li>
					<li><a
						href="${pageContext.request.contextPath}/vehicles?category=">Vehicles</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>

			<!-- Authentication buttons or Welcome message -->
			<div class="auth-buttons">
				<c:choose>
					<c:when test="${not empty sessionScope.username}">
						<p style="color: #ffffff; padding-right: 20px;">Welcome,
							${sessionScope.username}!</p>
						<div class="profile-icon">
							<a href="${pageContext.request.contextPath}/userAccount"> <!-- Profile icon, can be an image or a Font Awesome icon -->
								<i class="fas fa-user-circle"
								style="font-size: 26px; color: #ffffff; padding: 10px;"></i>
							</a>

						</div>
					</c:when>
					<c:otherwise>
						<button
							onclick="window.location.href='${pageContext.request.contextPath}/jsp/login.jsp'"
							class="login-btn">Login</button>
						<button
							onclick="window.location.href='${pageContext.request.contextPath}/jsp/signup.jsp'"
							class="signup-btn">Sign Up</button>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</header>
</body>
</html>
