/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.util;

import com.ci6225.bidzone.pojo.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asankalakmal
 */
@WebServlet("/Images/*")
public class FileServlet extends HttpServlet {
    
    private static String imagePath = Properties.getProperty("ACTUAL_IMAGE_PATH");
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        try{
            String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
            File file = new File(imagePath+"/", filename);
            response.setHeader("Content-Type", getServletContext().getMimeType(filename));
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            Files.copy(file.toPath(), response.getOutputStream());
        } catch(IOException io) {
            //ERROR PAGE
        }
    }

}
