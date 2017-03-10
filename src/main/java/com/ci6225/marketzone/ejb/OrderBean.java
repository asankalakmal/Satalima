/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.ejb;

import com.ci6225.marketzone.dao.OrderDao;
import com.ci6225.marketzone.pojo.ShoppingCart;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Ureka
 */
@Stateless
public class OrderBean {
    public ShoppingCart loadOrder(int orderId) throws Exception{
        OrderDao dao = new OrderDao();
        ShoppingCart cart = dao.loadOrderDetails(orderId);       
        return cart;
    }
    
    public List<ShoppingCart> getOrderList(int userId) throws Exception{
        OrderDao dao = new OrderDao();
        List<ShoppingCart> orderList = dao.getOrderList(userId);
        return orderList;
    }
    
    public List<ShoppingCart> getOrderListForSeller(int userId) throws Exception{
        OrderDao dao = new OrderDao();
        List<ShoppingCart> orderList = dao.getOrderList(userId);
        return orderList;
    }
}
