/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.ProductDao;
import com.ci6225.bidzone.dao.UserDao;
import com.ci6225.bidzone.util.PasswordUtil;
import javax.ejb.Stateless;

/**
 *
 * @author Ureka
 */
@Stateless
public class ProductBean {
    public void addProduct(String name, String description, String userCode) throws Exception{
		ProductDao productDao = new ProductDao();
                productDao.addProduct(name, description, userCode);
    }
    
     
}
