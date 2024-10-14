<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_footer.css" />
</head>
<body>

<header>
    <nav class="navbar">
        <!-- Site logo on the left -->
        <img
            src="../images/sitelogo.jpg"
            alt="Site Logo"
            width="80"
            height="80"
        />

        <!-- Navigation links and Search bar -->
        <div class="nav-container">
            <!-- Navigation links -->
            <ul class="nav-links">
                <li><a href="jsp/HomePage.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/vehicles?category=">Vehicles</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </div>

        <!-- Login and Sign Up buttons -->
        <div class="auth-buttons">
            <button
                onclick="window.location.href='${pageContext.request.contextPath}/jsp/login.jsp'"
                class="login-btn"
            >
                Login
            </button>
            <button
                onclick="window.location.href='${pageContext.request.contextPath}/jsp/signup.jsp'"
                class="signup-btn"
            >
                Sign Up
            </button>
        </div>
    </nav>
</header>
</body>
</html>
