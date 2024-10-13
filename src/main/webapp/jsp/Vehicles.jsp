<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Car Rental</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <script>
        function addToFavorites(vehicleId) {
            const userId = getUserIdFromCookies(); // Get userId from cookies

            if (!userId) {
                alert('Please log in to add favorites.');
                return;
            }

            const formData = new FormData();
            formData.append('action', 'add');
            formData.append('vehicleId', vehicleId);

            fetch('${pageContext.request.contextPath}/favorites', {
                method: 'POST',
                body: formData
            }).then(response => {
                if (response.ok) {
                    location.reload(); // Refresh the page
                } else {
                    alert('Failed to add to favorites');
                }
            });
        }

        function getUserIdFromCookies() {
            const cookies = document.cookie.split(';');
            for (let cookie of cookies) {
                const [name, value] = cookie.trim().split('=');
                if (name === 'userId') {
                    return value; // Return userId
                }
            }
            return null; // Return null if userId is not found
        }
    </script>
</head>
<body>
    <!-- Header -->
    <%@ include file="header.jsp" %>

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
                    <img src="${vehicle.image}" alt="${vehicle.vehicleBrand} ${vehicle.vehicleModel}" />
                    <h3>${vehicle.vehicleBrand} ${vehicle.vehicleModel}</h3>
                    <p>Color: ${vehicle.color}</p>
                    <p>Seats: ${vehicle.seatNo}</p>
                    <p>Milage: ${vehicle.milage} km/l</p>
                    <p>Category: ${vehicle.category}</p>
                    <!-- Rent button for each vehicle -->
                    <button onclick="window.location.href='${pageContext.request.contextPath}/rentVehicle?vehicleId=${vehicle.vehicleID}'">Rent</button>
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
    <%@ include file="footer.jsp" %>
</body>
</html>
