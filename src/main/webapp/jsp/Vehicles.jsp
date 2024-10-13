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
        <!-- car category -->
        <div class="vehicle-card">
          <img src="../images/car2.jpg" alt="Car" />

          <h3>BMW</h3>
          <p></p>
          <button onclick="window.location.href='#'">View details</button>
        </div>

        <!-- Bike category -->
        <div class="vehicle-card">
          <img src="../images/car3.jpg" alt="Car2" />
          <h3>Lotus</h3>
          <p></p>
          <button onclick="window.location.href='#"> View details</button>
        </div>

        <!-- Van category -->
        <div class="vehicle-card">
          <img src="../images/car4.jpg" alt="Car3" />

          <h3>Mercedes benz</h3>
          <p></p>
          <button onclick="window.location.href='#'">View details</button>
        </div>

        <!-- jeep category -->
        <div class="vehicle-card">
          <img src="../images/car5.jpg" alt="Car4" />

          <h3>Lambo</h3>
          <p></p>
          <button onclick="window.location.href='#'">View details</button>
        </div>
      </div>
    </div>


    <!-- Footer -->
    <%@ include file = "footer.jsp" %>
  </body>
</html>
