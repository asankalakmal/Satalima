/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.buyer;

import com.ci6225.marketzone.ejb.OrderBean;
import com.ci6225.marketzone.pojo.ShoppingCart;
import com.ci6225.marketzone.pojo.User;
import java.io.IOException;
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
@WebServlet("/ViewOrderHistory")
public class ViewOrderHistoryServlet extends HttpServlet{
    @EJB
    OrderBean orderBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderHistoryServlet() {
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
                    User user = (User) request.getSession().getAttribute("user");
                    List<ShoppingCart> orderList = orderBean.getOrderList(user.getUserId());
                    request.setAttribute("orderList", orderList);
                    RequestDispatcher rd = request.getRequestDispatcher("./jsp/buyer/order_history.jsp");
                    
                rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}

	}
}
