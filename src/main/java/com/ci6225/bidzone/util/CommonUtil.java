/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.util;

import java.util.Date;

/**
 *
 * @author Ureka
 */
public class CommonUtil {

    public static String imageNameGenerate(String oldName, int userId) {
        Date date = new Date();
        long time = date.getTime();
        return userId + "." + time + "." + oldName;
    }
}
