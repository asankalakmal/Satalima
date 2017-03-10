package com.ci6225.bidzone.servlet;

import com.ci6225.bidzone.ejb.UserBean;
import com.ci6225.bidzone.pojo.User;
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

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    UserBean userBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode = request.getParameter("userCode");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String country = request.getParameter("country");
        String userType = request.getParameter("userType");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        FormValidation validation = new FormValidation();
        boolean isValid = validation.validateSignup(userType, userCode, firstName, lastName,
                email, phone, country, password, confirmPassword);
        List<String> messageList =  new ArrayList<String>();
        try {
            if (isValid) {
                User user = userBean.userExist(userCode);
                if (user == null) {
                    messageList.add("Signup Successful.");
                    userBean.addUser(userCode, firstName, lastName, email, phone, country, Integer.parseInt(userType), password);
                    request.setAttribute("successMessage", messageList);
                    RequestDispatcher rd = request.getRequestDispatcher("./jsp/register.jsp");
                    rd.forward(request, response);
                } else {
                    messageList.add("User name already exist.");
                    request.setAttribute("errorMessage", messageList);
                    setInputParam(request, userCode, firstName, lastName, email, phone, country, userType);
                    RequestDispatcher rd = request.getRequestDispatcher("./jsp/register.jsp");
                    rd.forward(request, response);
                }
            } else {
                messageList.addAll(validation.getErrorMessages());
                request.setAttribute("errorMessage", messageList);
                setInputParam(request, userCode, firstName, lastName, email, phone, country, userType);
                RequestDispatcher rd = request.getRequestDispatcher("./jsp/register.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
    
    private void setInputParam(HttpServletRequest request, String userCode, String firstName, String lastName, String email, String phone, String country, String userType) {
        request.setAttribute("userCode", userCode);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("country", country);
        request.setAttribute("userType", userType);
    }

}
