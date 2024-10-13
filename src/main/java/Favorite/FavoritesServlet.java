package Favorite;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Vehicle.Vehicle;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId"); // Retrieve userId from session

        if (userId == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
            return; // Stop processing if userId is not available
        }

        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

        if ("add".equals(action)) {
            boolean isAdded = FavoriteService.addFavorite(userId, vehicleId);
            if (isAdded) {
                response.sendRedirect(request.getContextPath() + "/jsp/vehicles.jsp"); // Redirect after adding
            } else {
                // Handle error (e.g., vehicle already in favorites)
            }
        } else if ("remove".equals(action)) {
            boolean isRemoved = FavoriteService.removeFavorite(userId, vehicleId);
            if (isRemoved) {
                response.sendRedirect(request.getContextPath() + "/jsp/favorites.jsp"); // Redirect after removing
            } else {
                // Handle error
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId"); // Retrieve userId from session

        if (userId == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
            return; // Stop processing if userId is not available
        }

        List<Vehicle> favorites = FavoriteService.getFavorites(userId);
        request.setAttribute("favorites", favorites);
        request.getRequestDispatcher("/jsp/favorites.jsp").forward(request, response);
    }
}
