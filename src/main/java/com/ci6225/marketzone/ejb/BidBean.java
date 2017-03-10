/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.ejb;

import com.ci6225.marketzone.dao.BidDao;
import com.ci6225.marketzone.dao.ProductDao;
import com.ci6225.marketzone.pojo.Bid;
import com.ci6225.marketzone.pojo.Product;
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
