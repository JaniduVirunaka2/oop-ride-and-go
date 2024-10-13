<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Car</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  </head>
  <body>
    <!-- Header -->
    <%@ include file = "header.jsp" %>

    <!-- Hero section -->
    <section class="hero">
      <div>
        <!--<img src="../UI/images/sitelogo.jpg" alt="sitelogo" /> -->
    
        <h1>DON'T RENT A CAR.<br>
            RENT THE CAR</h1>
      </div>
    </section>

    <!-- Main content -->
    <div class="container" id="vehicles">
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
	                <button onclick="window.location.href='#'">View details</button>
	            </div>
	        </c:forEach>
	    </div>
	    </div>


    <!-- Footer -->
    <%@ include file = "footer.jsp" %>
  </body>
</html>
