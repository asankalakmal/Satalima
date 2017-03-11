/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.util;

import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Ureka
 */
@WebListener
public class Config implements ServletContextListener {
    
    public static String imagePath = Properties.getProperty("ACTUAL_IMAGE_PATH");
    
    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
        System.out.println("STATING THE WEB APP!!!");
        String webPath = event.getServletContext().getRealPath("/");
        System.out.println("STATING THE WEB: WEB PATH: "+webPath);
        System.out.println("STATING THE WEB: ACTUAL PATH: "+imagePath);
        try{
            CommonUtil.createInternetShortcut("productImages", webPath, imagePath);
            System.out.println("STATING THE WEB: Image Linked Successfully");
        } catch(IOException ex) {
            System.out.println("STATING THE WEB: ERROR Image Linked UNSuccessfull");
            //System.out.println(ex);
        }
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }
}