package Vehicle;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vehicles")
public class VehiclesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the category parameter from the request
		String category = request.getParameter("category");

		List<Vehicle> vehicleList;
		if (category != null && !category.isEmpty()) {
			// Fetch vehicles by category if the parameter is provided
			vehicleList = VehicleService.getVehiclesByCategory(category);
		} else {
			// Fetch all vehicles if no category parameter is given
			vehicleList = VehicleService.getAllVehicles();
		}

		// Set the vehicle list as a request attribute
		request.setAttribute("vehicles", vehicleList);

		// Forward to the JSP page
		request.getRequestDispatcher("/jsp/Vehicles.jsp").forward(request, response);
	}
}
