/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.cart;

import com.ci6225.marketzone.ejb.ProductBean;
import com.ci6225.marketzone.ejb.ShoppingCartBeanLocal;
import com.ci6225.marketzone.pojo.User;
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
@WebServlet("/RemoveCartItem")
public class RemoveCartItemServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
                    ShoppingCartBeanLocal shoppingCartBean = (ShoppingCartBeanLocal) request.getSession().getAttribute("shoppingCartBean");
                    
                    int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
                    shoppingCartBean.removeItem(itemIndex);
                    request.setAttribute("cart", shoppingCartBean.getCart());
                    RequestDispatcher rd = request.getRequestDispatcher("./jsp/cart/cart_items.jsp");
                    rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}

	}
}
