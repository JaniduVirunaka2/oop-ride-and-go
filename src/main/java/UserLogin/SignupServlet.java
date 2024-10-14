package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	   	
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        // Check if password and repassword match
        if (!password.equals(repassword)) {
            request.setAttribute("errorMessage", "Passwords do not match!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Check if the username is already taken
        if (UserDBUtil.isUsernameTaken(username)) {
            request.setAttribute("errorMessage", "Username is already taken!");
            request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
            return;
        }

        // Attempt to register the user
        boolean isRegistered = UserDBUtil.insertUser(name, email, phone, username, password);

        if (isRegistered) {
            request.setAttribute("successMessage", "Registration successful! Please log in.");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Registration failed! Please try again.");
            request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);

        }
    }
}
