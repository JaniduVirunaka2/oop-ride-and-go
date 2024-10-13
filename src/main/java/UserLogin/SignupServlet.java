package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isSuccess;

        // Insert the user details
        isSuccess = UserDBUtil.insertuser(name, email, phone, username.trim(), password.trim());

        if (isSuccess) {
            RequestDispatcher dis = request.getRequestDispatcher("jsp/LoginPage.jsp");
            dis.forward(request, response);
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Failed to register. Please try again.');");
            out.println("location='signup.jsp';");
            out.println("</script>");
        }
    }
}

