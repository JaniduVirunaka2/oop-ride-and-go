package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isTrue;

        System.out.println("username: " + userName + " password: " + password);

        isTrue = UserDBUtil.validate(userName.trim(), password.trim());
        
        if (isTrue) {
            List<User> userDetails = UserDBUtil.getUser(userName);
            request.setAttribute("userDetails", userDetails);
            
            // Assuming the userDetails list has at least one user and we want the first user's ID
            int userId = userDetails.get(0).getId(); // Modify this based on your User class structure

            // Create a cookie to store userId
            Cookie userCookie = new Cookie("userId", String.valueOf(userId));
            userCookie.setMaxAge(60 * 60 * 24); // Cookie expires in 1 day
            response.addCookie(userCookie); // Add cookie to response

            // Redirect to HomePage.jsp after successful login
            response.sendRedirect(request.getContextPath() + "/jsp/HomePage.jsp");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Your username or password is incorrect');");
            out.println("location='login.jsp';"); // Redirect back to login page
            out.println("</script>");
        }
    }
}
