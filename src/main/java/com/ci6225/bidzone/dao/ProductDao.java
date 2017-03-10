/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.dao;

import com.ci6225.bidzone.pojo.Product;
import com.ci6225.bidzone.pojo.Seller;
import com.ci6225.bidzone.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ureka
 */
public class ProductDao {
    public void addProduct(Product product, int userId) throws Exception{
	String insertStatement = "INSERT INTO product (name, description, seller_id, unit_price, quantity, "
                + "create_time, created_by, update_time, updated_by)"
                + " VALUES (?,?,?,?,?,NOW(),?,NOW(),?)"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(insertStatement);    
		ps.setString(1, product.getName());
		ps.setString(2, product.getDescription());
                ps.setInt(3, userId);
                ps.setDouble(4, product.getUnitPrice());
                ps.setInt(5, product.getQuantity());
		ps.setInt(6, userId);
                ps.setInt(7, userId);
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
    }
    
     public void updateProduct(Product product, int userId) throws Exception{
	String updateStatement = "UPDATE product set name=?, description=?, unit_price=?, quantity=?,"
                + " update_time=NOW(), updated_by=? where id = ?"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(updateStatement);    
		ps.setString(1, product.getName());
		ps.setString(2, product.getDescription());
                ps.setDouble(3, product.getUnitPrice());
		ps.setInt(4, product.getQuantity());
                ps.setInt(5, userId);
                ps.setInt(6, product.getId());
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
        
    }
     
     public List<Product> getProductListBySellerId(int sellerId) throws Exception{
         List<Product> productList = new ArrayList<>();
         String selectStatement = "select * from product where seller_id = ? and delete_flag='F'";  
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
                                String name = rs.getString("name");
                                String description = rs.getString("description");
                                int quantity = rs.getInt("quantity");
                                float unitPrice = rs.getFloat("unit_price");
                                Product product = new Product(id, name, description, quantity, unitPrice, null);
                                Seller seller = new Seller(sellerId);
                                product.setSeller(seller);
                                productList.add(product);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return productList;
     }
     
     public Product getProduct(int productId) throws Exception{
         String selectStatement = "select * from product where id=";  
		Connection con = null;
		PreparedStatement ps = null;
		       ResultSet rs = null;
                       Product product=null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
                        ps.setInt(1, productId);
			rs = ps.executeQuery();
                        

			while (rs.next()) {
				int id = rs.getInt("id");
                                String name = rs.getString("name");
                                String description = rs.getString("description");
                                int quantity = rs.getInt("quantity");
                                float unitPrice = rs.getFloat("unit_price");
                                 product = new Product(id, name, description, quantity, unitPrice, null);
                                
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return product;
     }
}
