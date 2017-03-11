/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.cart;

import com.ci6225.marketzone.ejb.ProductBean;
import com.ci6225.marketzone.ejb.ShoppingCartBeanLocal;
import com.ci6225.marketzone.pojo.User;
import com.ci6225.marketzone.validation.FormValidation;
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
 *
 * @author Ureka
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrderServlet extends HttpServlet {

    ShoppingCartBeanLocal cartBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
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

        try {
            cartBean = (ShoppingCartBeanLocal) request.getSession().getAttribute("shoppingCartBean");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            String city = request.getParameter("city");
            String postalCode = request.getParameter("postalCode");
            String country = request.getParameter("country");
            String comments = request.getParameter("comments");
            User user = (User) request.getSession().getAttribute("user");

            FormValidation validation = new FormValidation();
            List<String> messageList = new ArrayList<String>();
            if (validation.validateCheckout(firstName, lastName, email, telephone, address1, address2, city, country, postalCode)) {
                int orderId = cartBean.confirmOrder(firstName, lastName, email, telephone, address1, address2, city, postalCode, country, comments, user.getUserId());

                request.getSession().removeAttribute("shoppingCartBean");
                messageList.add("Your order placed successfully.");
                request.setAttribute("successMessage", messageList);
                response.sendRedirect("./ViewOrder?orderId=" + orderId);
            } else {

                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName",lastName);
                request.setAttribute("email",email);
                request.setAttribute("telephone", telephone);
                request.setAttribute("address1", address1);
                request.setAttribute("address2", address2);
                request.setAttribute("city", city);
                request.setAttribute("postalCode", postalCode);
                request.setAttribute("country", country);
                request.setAttribute("comments", comments);
                
                messageList.addAll(validation.getErrorMessages());
                request.setAttribute("errorMessage", messageList);
                RequestDispatcher rd = request.getRequestDispatcher("./checkout");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
