package UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

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

		isTrue = UserDBUtil.validate(userName.trim(), password.trim());

		if (isTrue) {
			List<User> userDetails = UserDBUtil.getUser(userName);
			request.setAttribute("userDetails", userDetails);

			int userId = userDetails.get(0).getId(); // Assuming userDetails list is not empty

			// Set userId in session
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

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
