/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.servlet.seller;

import com.ci6225.marketzone.ejb.ProductBean;
import com.ci6225.marketzone.pojo.Product;
import com.ci6225.marketzone.pojo.User;
import com.ci6225.marketzone.validation.FormValidation;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ureka
 */
@WebServlet("/ViewProductDetail")
public class ViewProductDetailServlet extends HttpServlet {

    @EJB
    ProductBean productBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
          int productId = Integer.parseInt(request.getParameter("productId"));
            Product product = productBean.getProduct(productId);
            request.setAttribute("product", product);
            RequestDispatcher rd = request.getRequestDispatcher("./jsp/seller/update_product.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
