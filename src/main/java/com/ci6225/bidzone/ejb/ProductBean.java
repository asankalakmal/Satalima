/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.ProductDao;
import com.ci6225.bidzone.dao.UserDao;
import com.ci6225.bidzone.pojo.Product;
import com.ci6225.bidzone.util.PasswordUtil;
import javax.ejb.Stateless;

/**
 *
 * @author Ureka
 */
@Stateless
public class ProductBean {
    public void addProduct(String name, String description, int userId, int quantity, double unitPrice) throws Exception{
		ProductDao productDao = new ProductDao();
                Product product = new Product(name, description, quantity, unitPrice, userId);
                productDao.addProduct(product, userId);
    }
    
    public void updateProduct(int id, String name, String description, int quantity, double unitPrice, int userId) throws Exception{
		ProductDao productDao = new ProductDao();
                Product product = new Product(id, name, description, quantity, unitPrice, userId);
                productDao.updateProduct(product, userId);
    }
    
     
}
