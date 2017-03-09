/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.util;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Ureka
 */
public class CommonUtil {

    public static String imageNameGenerate(String oldName) {
        Date date = new Date();
        long time = date.getTime();
        return time + "." + oldName;
    }
    
    public static boolean isSetDirectory(String dir) {
        
        if(dir == null || dir.trim().equals("")) {
            return false;
        }
        
        File files = new File(dir);
        if (!files.exists()) {
            if (!files.mkdirs()) {
                return true;
            } 
        }
        return true;
    }
}
