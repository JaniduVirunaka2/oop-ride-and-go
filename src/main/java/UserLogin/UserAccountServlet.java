package UserLogin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userAccount")
public class UserAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get the existing session
        if (session != null) {
            String username = (String) session.getAttribute("username");
            

            if (username == null) {
                response.sendRedirect("jsp/login.jsp"); // Redirect to login if user is not logged in
                return;
            }

            // Retrieve user details from the database
            List<User> userDetails = UserDBUtil.getUser(username);

            if (userDetails != null && !userDetails.isEmpty()) {
                // Set user details as a request attribute
                request.setAttribute("user", userDetails.get(0));
                // Forward to UserAccount.jsp
                request.getRequestDispatcher("/jsp/UserAccount.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if session is null
        }
    }
}
