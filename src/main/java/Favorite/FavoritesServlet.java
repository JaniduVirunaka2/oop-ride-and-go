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
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userId") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
			return;
		}

		int userId = (Integer) session.getAttribute("userId");

		boolean result = false;
		if ("add".equalsIgnoreCase(action)) {
			result = addFavorite(userId, vehicleId);
		} else if ("remove".equalsIgnoreCase(action)) {
			result = removeFavorite(userId, vehicleId);
		}

		if (result) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to update favorites");
		}
	}

	private boolean addFavorite(int userId, int vehicleId) {
		return FavoriteService.addFavorite(userId, vehicleId);
	}

	private boolean removeFavorite(int userId, int vehicleId) {
		return FavoriteService.removeFavorite(userId, vehicleId);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("userId") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
			return;
		}

		int userId = (Integer) session.getAttribute("userId");
		List<Vehicle> favorites = FavoriteService.getFavorites(userId);
		request.setAttribute("favorites", favorites);
		request.getRequestDispatcher("/jsp/favorites.jsp").forward(request, response);
	}
}
