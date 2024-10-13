<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Your Favorites</title>
</head>
<body>
	<h1>Your Favorite Vehicles</h1>
	<div class="favorites">
		<c:forEach var="vehicle" items="${favorites}">
			<div class="vehicle-card">
				<img src="${vehicle.image}"
					alt="${vehicle.vehicleBrand} ${vehicle.vehicleModel}" />
				<h3>${vehicle.vehicleBrand}${vehicle.vehicleModel}</h3>
				<p>Color: ${vehicle.color}</p>
				<p>Seats: ${vehicle.seatNo}</p>
				<p>Milage: ${vehicle.milage} km/l</p>
				<button
					onclick="removeFromFavorites(${userId}, ${vehicle.vehicleID})">Remove</button>
			</div>
		</c:forEach>
	</div>
	<c:if test="${empty favorites}">
		<p>No favorite vehicles found.</p>
	</c:if>

	<script>
        function removeFromFavorites(userId, vehicleId) {
            const formData = new FormData();
            formData.append('action', 'remove');
            formData.append('vehicleId', vehicleId);

            fetch('${pageContext.request.contextPath}/favorites', {
                method: 'POST',
                body: formData
            }).then(response => {
                if (response.ok) {
                    location.reload(); // Refresh the page
                } else {
                    alert('Failed to remove from favorites');
                }
            });
        }
    </script>
</body>
</html>
