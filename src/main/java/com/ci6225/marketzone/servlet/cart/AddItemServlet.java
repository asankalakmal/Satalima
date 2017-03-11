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
@WebServlet("/AddItem")
public class AddItemServlet extends HttpServlet {

    ShoppingCartBeanLocal cartBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
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
            String productIndex = request.getParameter("productIndex");
            String quantity = request.getParameter("quantity");
            FormValidation validation = new FormValidation();
            List<String> messageList = new ArrayList<String>();
            if (validation.validateCartAdd(quantity, productIndex)) {
                cartBean = (ShoppingCartBeanLocal) request.getSession().getAttribute("shoppingCartBean");
                cartBean.addItem(Integer.parseInt(productIndex), Integer.parseInt(quantity));
                
                messageList.add("Item Added Successfully.");
                request.setAttribute("successMessage", messageList);
                request.setAttribute("availableProductList", cartBean.getProductList());
                RequestDispatcher rd = request.getRequestDispatcher("./jsp/index.jsp");
                rd.forward(request, response);
            } else {
                messageList.addAll(validation.getErrorMessages());
                request.setAttribute("errorMessage", messageList);
                RequestDispatcher rd = request.getRequestDispatcher("./ViewProduct?productIndex="+productIndex);
                rd.forward(request, response);    
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
