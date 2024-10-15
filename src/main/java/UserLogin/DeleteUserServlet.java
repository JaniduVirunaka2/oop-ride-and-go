package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the current session
		HttpSession session = request.getSession(false);

		if (session != null) {
			// Retrieve the username from the session
			String username = (String) session.getAttribute("username");

			if (username != null) {
				// Call the method to delete the user from the database
				boolean isDeleted = UserDBUtil.deleteUserByUsername(username);

				if (isDeleted) {
					// Invalidate the session to log the user out
					session.invalidate();
					// Redirect to the homepage or login page after deletion
					response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
				} else {
					// If deletion failed, show an error message
					request.setAttribute("errorMessage", "Failed to delete the account.");
					request.getRequestDispatcher("/jsp/UserAccount.jsp").forward(request, response);
				}
			} else {
				// If no username is found in the session, redirect to login
				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			}
		} else {
			// If no session is found, redirect to login
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}
	}
}
