/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.marketzone.dao;

import com.ci6225.marketzone.pojo.Bid;
import com.ci6225.marketzone.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ureka
 */
public class BidDao {
    public void addBid(Bid bid, int userId) throws Exception{
	String insertStatement = "INSERT INTO bid (product_id, start_time, end_time, min_amount, "
                + "create_time, created_by, update_time, updated_by)"
                + " VALUES (?,?,?,?,?,NOW(),?,NOW(),?)"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(insertStatement);    
		ps.setInt(1, bid.getProductId());
		ps.setDate(2, new Date(bid.getStartTime().getTime()));
                ps.setDate(3, new Date(bid.getEndTime().getTime()));
                ps.setDouble(4, bid.getMinAmount());
                ps.setInt(5, userId);
                ps.setInt(6, userId);
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
    }
    
     public void updateBid(Bid bid, int userId) throws Exception{
	String updateStatement = "UPDATE bid SET start_time=?, end_time=?, min_amount=?, update_time=NOW(), updated_by=? "
                + "WHERE id=?"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(updateStatement);    
		ps.setDate(1, new Date(bid.getStartTime().getTime()));
		ps.setDate(2, new Date(bid.getEndTime().getTime()));
                ps.setDouble(3, bid.getMinAmount());
                ps.setInt(4, userId);
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
     }
     
     public List<Bid> getBidListBySellerId(int sellerId) throws Exception{
         List<Bid> bidList = new ArrayList<>();
         String selectStatement = "select b.*,p.seller_id from bid b, product p where b.product_id=p.id and p.seller_id=?";  
		Connection con = null;
		PreparedStatement ps = null;
		       ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);  
                        ps.setInt(1, sellerId);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
                                int productId = rs.getInt("product_id");
                                double minAmount = rs.getDouble("min_amoount");
                                Date startTime = rs.getDate("start_time");
                                Date endTime = rs.getDate("end_time");
                                int winnerBidId = rs.getInt("winner_bid_id");
                                Bid bid = new Bid(id, productId, startTime, endTime, minAmount, winnerBidId);
                                bidList.add(bid);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return bidList;
     }
}
