package Favorite;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Vehicle.Vehicle;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int userId = getUserIdFromCookies(request.getCookies()); // Retrieve userId from cookies
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

        if ("add".equals(action)) {
            boolean isAdded = FavoriteService.addFavorite(userId, vehicleId);
            if (isAdded) {
                response.sendRedirect(request.getContextPath() + "/jsp/vehicles.jsp"); // Redirect after adding
            } else {
                // Handle error
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
        int userId = getUserIdFromCookies(request.getCookies()); // Retrieve userId from cookies
        List<Vehicle> favorites = FavoriteService.getFavorites(userId);
        request.setAttribute("favorites", favorites);
        request.getRequestDispatcher("/jsp/favorites.jsp").forward(request, response);
    }

    private int getUserIdFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    return Integer.parseInt(cookie.getValue()); // Convert cookie value to int
                }
            }
        }
        return -1; // Return -1 if userId cookie is not found
    }
}
