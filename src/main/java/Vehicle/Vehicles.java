package Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicles")
public class Vehicles extends HttpServlet {
    private VehicleService vehicleService = new VehicleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        request.setAttribute("vehicles", vehicleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Vehicles.jsp");
        dispatcher.forward(request, response);
    }
}
