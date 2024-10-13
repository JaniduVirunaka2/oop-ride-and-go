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
            out.println("<script type='text/javascript'>");
            out.println("alert('Passwords do not match!');");
            out.println("location='signup.jsp';"); // Redirect back to signup page
            out.println("</script>");
            return;
        }

        // Call to UserDBUtil to register the user
        boolean isRegistered = UserDBUtil.insertUser(name, email, phone, username, password);
        
        if (isRegistered) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Registration successful! Please log in.');");
            out.println("location='login.jsp';"); // Redirect to login page
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Registration failed! Please try again.');");
            out.println("location='signup.jsp';"); // Redirect back to signup page
            out.println("</script>");
        }
    }
}
