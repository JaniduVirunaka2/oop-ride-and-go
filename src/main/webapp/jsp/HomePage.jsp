<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Vehicle Rental System</title>

<!--link the external css file-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />

</head>


<body>
	<!-- Header -->
	<%@ include file="header.jsp"%>


	<!-- Hero section -->
	<section class="hero">
		<div>
			<!--<img src="../UI/images/sitelogo.jpg" alt="sitelogo" /> -->
			<h1>Ride&Go</h1>
			<p>Choose from a wide selection of vehicles to rent</p>
		</div>

		<script>
			var images = [ "../images/home_page_image1.jpg",
					"../images/home_page_image2.jpg",
					"../images/home_page_image3.jpeg",
					"../images/home_page_image6.jpg",
					"../images/home_page_image5.jpg",
					"../images/home_page_image7.jpg", ];
			var currentIndex = 0;
			var hero = document.querySelector(".hero");

			function changeHeroBackground() {
				hero.style.backgroundImage = 'url("' + images[currentIndex]
						+ '")';
				currentIndex = (currentIndex + 1) % images.length;
			}

			// Change background every 3 seconds
			setInterval(changeHeroBackground, 3000);
		</script>
	</section>

	<!-- Main content -->
	<div class="container" id="vehicles">
		<h2>Choose Vehicle Category</h2>
		<div class="vehicles">
			<!-- car category -->
			<div class="vehicle-card">
				<img src="../images/car.png" alt="Car" />

				<h3>Car</h3>
				<p>Comfortable and affordable cars for city driving.</p>
				<!-- Button to view vehicles -->
				<button
					onclick="window.location.href='${pageContext.request.contextPath}/vehicles?category=Car'">View
					Cars</button>
			</div>

			<!-- Bike category -->
			<div class="vehicle-card">
				<img src="../images/bike2.png" alt="Motorcycle" />
				<h3>MotorBike</h3>
				<p>Ride through traffic easily with our motorbikes.</p>

				<button
					onclick="window.location.href='${pageContext.request.contextPath}/vehicles?category=Bike'">View
					Bikes</button>
			</div>

			<!-- Van category -->
			<div class="vehicle-card">
				<img src="../images/van.png" alt="Van" />

				<h3>Van</h3>
				<p>Spacious vans for group travel or moving large items.</p>
				<button
					onclick="window.location.href='${pageContext.request.contextPath}/vehicles?category=Van'">View
					Vans</button>
			</div>

			<!-- jeep category -->
			<div class="vehicle-card">
				<img src="../images/jeep.png" alt="Jeep" />

				<h3>SUV</h3>
				<p>Well built jeeps for your Offroad adventures.</p>
				<button
					onclick="window.location.href='${pageContext.request.contextPath}/vehicles?category=Jeep'">View
					Jeeps</button>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<%@ include file="footer.jsp"%>
<body>

</body>
</html>