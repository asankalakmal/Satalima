/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.servlet.seller;

import com.ci6225.bidzone.ejb.ProductBean;
import com.ci6225.bidzone.pojo.User;
import com.ci6225.bidzone.validation.FormValidation;
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
@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

    @EJB
    ProductBean productBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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

        String name = null;
        String description = null;
        String unitPrice = null;
        String quantity = null;
        FileItem imageItem = null;

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("") + "/productImages";

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            //processProblem = true;
            //processError = "System Error (code: news-001).";
            //System.out.println(processError);
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5000 * 1024);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(5000 * 1024);

        try {
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    if (item.getFieldName().equals("productImage") && !item.getString().equals("")) {
                        imageItem = item;
                    }
                    System.out.println(item.getFieldName());
                } else {
                    System.out.println(item.getFieldName() + " " + item.getString());
                    if (item.getFieldName().equals("name")) {
                        name = item.getString();
                    } else if (item.getFieldName().equals("description")) {
                        description = item.getString();
                    } else if (item.getFieldName().equals("unitPrice")) {
                        unitPrice = item.getString();
                    } else if (item.getFieldName().equals("quantity")) {
                        quantity = item.getString();
                    }
                }
            }

        } catch (FileUploadException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        
        FormValidation validation = new FormValidation();
        if(!validation.validateAddProduct(name, description, quantity, unitPrice, imageItem)) {
            request.setAttribute("errorMessage", "Product Adding Error.");
            request.setAttribute("errorList", validation.getErrorMessages());
            RequestDispatcher rd = request.getRequestDispatcher("./");
            rd.forward(request, response);
        }

        try {
            User user = (User) request.getSession().getAttribute("user");
            productBean.addProduct(name, description, user.getUserId(), Integer.parseInt(quantity), Float.parseFloat(unitPrice), imageItem, uploadFolder);
            request.setAttribute("successMessage", "Product Added Successfully.");
            RequestDispatcher rd = request.getRequestDispatcher("./");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./");
        }

    }
}
