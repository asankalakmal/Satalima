/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.cart;

import com.ci6225.marketzone.ejb.ShoppingCartBean;
import com.ci6225.marketzone.ejb.ShoppingCartBeanLocal;
import com.ci6225.marketzone.pojo.CartItem;
import com.ci6225.marketzone.pojo.Product;
import com.ci6225.marketzone.pojo.ShoppingCart;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
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
@WebServlet("/ViewCart" )
public class ViewCartServlet extends HttpServlet{
    //@EJB
    //ShoppingCartBeanLocal shoppingCartBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCartServlet() {
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
                    if(shoppingCartBean == null){
                    InitialContext ic = new InitialContext();
                    shoppingCartBean = (ShoppingCartBeanLocal) ic.lookup("java:global/MarketZone/ShoppingCartBean");
                    request.getSession().setAttribute("shoppingCartBean", shoppingCartBean);
                    }
                       ShoppingCart cart = shoppingCartBean.getCart();
                       request.setAttribute("cart", cart);
                      RequestDispatcher rd = request.getRequestDispatcher("./jsp/cart/cart.jsp");
                    
                rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}

	}
}
