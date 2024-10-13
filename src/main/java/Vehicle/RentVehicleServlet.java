package Vehicle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rentVehicle")
public class RentVehicleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get the vehicle ID from the request
        String vehicleIdStr = request.getParameter("vehicleId");

        if (vehicleIdStr != null && !vehicleIdStr.isEmpty()) {
            try {
                int vehicleId = Integer.parseInt(vehicleIdStr);
                
                // Call the service to rent the vehicle
                boolean isAvailable = VehicleService.rentVehicle(vehicleId);
                
             // In RentVehicleServlet.java
                if (isAvailable) {
                    response.sendRedirect(request.getContextPath() + "/jsp/rentConfirmation.jsp"); // Correct path
                } else {
                    response.sendRedirect(request.getContextPath() + "/jsp/rentError.jsp"); // Correct path
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/rentError.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/rentError.jsp");
        }
    }
}
