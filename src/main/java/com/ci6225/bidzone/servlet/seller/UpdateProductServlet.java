/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.servlet.seller;

import com.ci6225.bidzone.ejb.ProductBean;
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
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {

    @EJB
    ProductBean productBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int id = Integer.parseInt(request.getParameter("id"));
            User user = (User) request.getSession().getAttribute("user");
            productBean.updateProduct(id, name, description, quantity, unitPrice, user.getUserId(), null, null);
            request.setAttribute("successMessage", "Product Updated Successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("./seller/prodcut_list.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
