package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Favorite.FavoriteService;

import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");
	    HttpSession session = request.getSession(false); // Get the existing session without creating a new one
	    
	    if (session != null) {
	        Integer userId = (Integer) session.getAttribute("userId");
	        if (userId == null) {
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
	            return;
	        }

	        try {
	            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

	            if ("add".equals(action)) {
	                boolean isAdded = FavoriteService.addFavorite(userId, vehicleId);
	                if (isAdded) {
	                    response.setStatus(HttpServletResponse.SC_OK);
	                } else {
	                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Vehicle already in favorites");
	                }
	            } else if ("remove".equals(action)) {
	                boolean isRemoved = FavoriteService.removeFavorite(userId, vehicleId);
	                if (isRemoved) {
	                    response.setStatus(HttpServletResponse.SC_OK);
	                } else {
	                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to remove from favorites");
	                }
	            } else {
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	            }
	        } catch (NumberFormatException e) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid vehicle ID");
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
	        }
	    } else {
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session not found");
	    }
	}

}
