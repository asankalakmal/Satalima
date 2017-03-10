package com.ci6225.bidzone.servlet;

import com.ci6225.bidzone.ejb.UserBean;
import com.ci6225.bidzone.pojo.User;
import com.ci6225.bidzone.util.Constants;
import com.ci6225.bidzone.validation.FormValidation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    UserBean userBean;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        FormValidation validation = new FormValidation();
        boolean isValid = validation.validateLogin(username, password);
        List<String> errorList =  new ArrayList<String>();
        try {
            if (isValid) {
                User user = userBean.login(username, password);
                if (user == null) {
                    errorList.add("Invalid username or password.");
                    request.setAttribute("errorMessage", errorList);
                    request.setAttribute("username", username);
                    RequestDispatcher rd = request.getRequestDispatcher("/register");
                    rd.forward(request, response);
                } else {
                    request.getSession().setAttribute("user", user);
                    if (user.getUserType() == Constants.ADMIN_ROLE) {
                        response.sendRedirect("./");
                    } else if (user.getUserType() == Constants.SELLER_ROLE) {
                        response.sendRedirect("./jsp/seller/add_product.jsp");
                    } else {
                        response.sendRedirect("./");
                    }

                }
            } else {
                errorList.addAll(validation.getErrorMessages());
                request.setAttribute("errorMessage", errorList);
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("/register");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }
    }

}
