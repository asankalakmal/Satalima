/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.servlet.cart;

import com.ci6225.bidzone.ejb.ProductBean;
import com.ci6225.bidzone.ejb.ShoppingCartBeanLocal;
import com.ci6225.bidzone.pojo.User;
import java.io.IOException;
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
public class AddItemServlet extends HttpServlet{
    ShoppingCartBeanLocal cartBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
                    int productIndex = Integer.parseInt(request.getParameter("productIndex"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    cartBean = (ShoppingCartBeanLocal) request.getSession().getAttribute("shoppingCartBean");
                    cartBean.addItem(productIndex, quantity);
                    request.setAttribute("successMessage", "Item Added Successfully.");
                    request.setAttribute("availableProductList", cartBean.getProductList());
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/index.jsp");
                rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}

	}
}
