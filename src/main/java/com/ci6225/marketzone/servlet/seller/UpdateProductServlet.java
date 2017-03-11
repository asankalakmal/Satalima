/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.seller;

import com.ci6225.marketzone.ejb.ProductBean;
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
            String unitPrice = request.getParameter("unitPrice");
            String quantity = request.getParameter("quantity");
            int id = Integer.parseInt(request.getParameter("id"));
            User user = (User) request.getSession().getAttribute("user");
            
            FormValidation validation = new FormValidation();
            List<String> messageList =  new ArrayList<String>();
            if(validation.validateupdateProduct(name, description, quantity, unitPrice)) {
                productBean.updateProduct(id, name, description, Integer.parseInt(quantity), Float.parseFloat(unitPrice), user.getUserId(), null, null);
                messageList.add("Product Updated Successfully.");
                request.setAttribute("successMessage", messageList);
                RequestDispatcher rd = request.getRequestDispatcher("./ViewProductList");
                rd.forward(request, response);
            } else {
                messageList.addAll(validation.getErrorMessages());
                request.setAttribute("errorMessage", messageList);
                request.setAttribute("name", name);
                request.setAttribute("description", description);
                request.setAttribute("unitPrice", unitPrice);
                request.setAttribute("quantity", quantity);
                request.setAttribute("id", id);
                RequestDispatcher rd = request.getRequestDispatcher("./ViewProductDetail?productId="+id);
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
