package com.ci6225.bidzone.servlet;

import com.ci6225.bidzone.ejb.UserBean;
import com.ci6225.bidzone.pojo.User;
import com.ci6225.bidzone.util.Constants;
import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        @EJB
        UserBean userBean;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			                 User user = userBean.login(username, password);
			if(user == null){
				request.setAttribute("errorMessage", "Invalid username or password.");
				RequestDispatcher rd = request.getRequestDispatcher("./register.jsp");
                rd.forward(request, response);
			}else{
				request.getSession().setAttribute("user", user);
                                if(user.getUserType()==Constants.ADMIN_ROLE){
                                    //TODO
                                    response.sendRedirect("./");
                                }else if(user.getUserType()==Constants.SELLER_ROLE){
                                    response.sendRedirect("./buyer/add_product.jsp");
                                }else{
                                    response.sendRedirect("./products");
                                }
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}
	}

}
