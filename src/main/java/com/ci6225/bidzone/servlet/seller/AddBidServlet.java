/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.servlet.seller;

import com.ci6225.bidzone.ejb.BidBean;
import com.ci6225.bidzone.ejb.ProductBean;
import com.ci6225.bidzone.pojo.User;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet("/AddBidAvailability")
public class AddBidServlet extends HttpServlet{
    @EJB
    BidBean bidBean;
    private final static String DATE_FORMAT = "YYYY-MM-DD HH";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBidServlet() {
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
		 
                DateFormat format = new SimpleDateFormat(DATE_FORMAT);               
		String description = request.getParameter("description");		
		try {
                    int productId = Integer.parseInt(request.getParameter("productId")); 
                    Date startTime = format.parse(request.getParameter("startTime"));
                    Date endTime = format.parse(request.getParameter("endTime"));
                    double minAmount = Double.parseDouble(request.getParameter("minAmount"));
                    User user = (User) request.getSession().getAttribute("user");
                    bidBean.addBid(productId, startTime, endTime, minAmount, user.getUserId());
                    
                    request.setAttribute("successMessage", "Product Bid Availablity Added Successfully.");
                    RequestDispatcher rd = request.getRequestDispatcher("./seller/prodcut_list.jsp");
                    rd.forward(request, response);						
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./");
		}

	}
}
