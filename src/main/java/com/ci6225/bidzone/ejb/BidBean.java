/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.BidDao;
import com.ci6225.bidzone.dao.ProductDao;
import com.ci6225.bidzone.pojo.Bid;
import com.ci6225.bidzone.pojo.Product;
import java.util.Date;

/**
 *
 * @author Ureka
 */
public class BidBean {
    public void addBid(int productId, Date startTime, Date endTime, double minAmount, int userId) throws Exception{
		BidDao bidDao = new BidDao();
                Bid bid = new Bid(productId, startTime, endTime, minAmount);
                bidDao.addBid(bid, userId);
                
    }
    
    public void updateBid(int id, int productId, Date startTime, Date endTime, double minAmount, int userId) throws Exception{
		BidDao bidDao = new BidDao();
                Bid bid = new Bid(productId, startTime, endTime, minAmount);
                bidDao.updateBid(bid, userId);
    }
}
