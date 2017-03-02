package com.ci6225.bidzone.servlet;

import com.ci6225.bidzone.pojo.User;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		try {
			                 User user = userService.login(username, password);
			if(user == null){
				request.setAttribute("errorMessage", "Invalid username or password.");
				RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
                rd.forward(request, response);
			}else{
				request.getSession().setAttribute("user", user);
				response.sendRedirect("./IssueListServlet");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}*/
	}

}
