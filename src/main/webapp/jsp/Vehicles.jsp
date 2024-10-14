<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Car Rental</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
async function addToFavorites(vehicleId) {
    try {
        const formData = new FormData();
        formData.append('action', 'add');
        formData.append('vehicleId', vehicleId);

        // Get the context path from a data attribute in a hidden element
        const contextPath = document.getElementById("contextPathHolder").dataset.contextPath;

        const response = await fetch(`${contextPath}/favorites`, {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            alert('Vehicle added to favorites successfully!');
            location.reload(); // Optionally reload the page to reflect changes
        } else {
            const errorMessage = await response.text();
            console.error('Failed to add to favorites:', errorMessage);
            alert('Failed to add to favorites. Please try again later.');
        }
    } catch (error) {
        console.error('Error adding to favorites:', error);
        alert('Failed to add to favorites. An unexpected error occurred.');
    }
}


    </script>
</head>
<body>
	<!-- Hidden element to store the context path -->
	<div id="contextPathHolder"
		data-context-path="${pageContext.request.contextPath}"
		style="display: none;"></div>

	<!-- Header -->
	<%@ include file="header.jsp"%>

	<!-- Hero Section -->
	<section class="hero">
		<div>
			<h1>
				DON'T RENT A CAR.<br>RENT THE CAR
			</h1>
		</div>
	</section>

	<!-- Main Content -->
	<div class="container" id="vehicles">
		<h2>Available Vehicles</h2>
		<div class="vehicles">
			<!-- Iterate over the list of vehicles -->
			<c:forEach var="vehicle" items="${vehicles}">
				<div class="vehicle-card">
					<img src="${vehicle.image}"
						alt="${vehicle.vehicleBrand} ${vehicle.vehicleModel}" />
					<h3>${vehicle.vehicleBrand}${vehicle.vehicleModel}</h3>
					<p>Color: ${vehicle.color}</p>
					<p>Seats: ${vehicle.seatNo}</p>
					<p>Milage: ${vehicle.milage} km/l</p>
					<p>Category: ${vehicle.category}</p>
					<!-- Rent button for each vehicle -->
					<button
						onclick="window.location.href='${pageContext.request.contextPath}/rentVehicle?vehicleId=${vehicle.vehicleID}'">Rent</button>
					<button onclick="addToFavorites(${vehicle.vehicleID})">Favorite</button>
				</div>
			</c:forEach>

			<!-- If no vehicles are found -->
			<c:if test="${empty vehicles}">
				<p>No vehicles available at the moment.</p>
			</c:if>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body
</html>
