/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.ShoppingCartDao;
import com.ci6225.bidzone.pojo.CartItem;
import com.ci6225.bidzone.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 *
 * @author Ureka
 */
@Remote
public interface ShoppingCartBeanLocal {
    public List<Product> searchProducts() throws Exception;

    public List<Product> getProductList() ;

    public List<CartItem> getCartItems() ;

    
}
