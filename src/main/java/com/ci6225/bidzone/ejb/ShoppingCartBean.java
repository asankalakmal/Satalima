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
import javax.ejb.Stateful;

/**
 *
 * @author Ureka
 */
@Stateful
public class ShoppingCartBean implements ShoppingCartBeanLocal{
    private List<Product> productList = new ArrayList<>();
    private List<CartItem> cartItems = new ArrayList<>();
    private Product detailProduct;
    
    public List<Product> searchProducts() throws Exception{
        ShoppingCartDao dao = new ShoppingCartDao();
        productList = dao.getAvailableProductList();
        return productList;
    }
    
    public Product getProductDetail(){
        
        return detailProduct;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Product getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(Product detailProduct) {
        this.detailProduct = detailProduct;
    }
    
}
