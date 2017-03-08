/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.dao;

import com.ci6225.bidzone.pojo.Product;
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
public class ShoppingCartDao {
    public List<Product> getAvailableProductList() throws Exception{
         List<Product> productList = new ArrayList<>();
         String selectStatement = "select p.* , s.name from product p, seller s where p.seller_id = s.id and delete_flag = 'F'";  
		Connection con = null;
		PreparedStatement ps = null;
		       ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
                                String name = rs.getString("name");
                                String description = rs.getString("description");
                                int quantity = rs.getInt("quantity");
                                double unitPrice = rs.getDouble("unit_price");
                                String sellerName = rs.getString("name");
                                Product product = new Product(id, name, description, quantity, unitPrice, sellerName);
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
}
