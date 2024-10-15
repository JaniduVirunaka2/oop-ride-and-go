<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Account</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user_acc.css" />
</head>
<body>
	<%@ include file="/jsp/header.jsp"%>
	<div class="container">
		<h1>User Profile</h1>
		<div class="account-info">
			<div class="profile-pic"></div>
			<div class="user-details">
				<h2>Name: ${user.name}</h2>
				<p>Username: ${user.userName}</p>
				<p>Email: ${user.email}</p>
			</div>
		</div>

		<div class="contact-info">
			<h3>Contact Details</h3>
			<p>Phone: ${user.phone}</p>
		</div>

		<div class="settings">
			<h3>Account Settings</h3>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/logout'"
				class="login-btn">Logout</button>
			<form action="${pageContext.request.contextPath}/deleteUser"
				method="post">
				<button type="submit">Delete Profile</button>
			</form>
		</div>
	</div>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>
