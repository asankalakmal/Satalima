/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.OrderDao;
import com.ci6225.bidzone.pojo.ShoppingCart;
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
}
