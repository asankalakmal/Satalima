/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.dao;

import com.ci6225.bidzone.pojo.CartItem;
import com.ci6225.bidzone.pojo.Product;
import com.ci6225.bidzone.pojo.Seller;
import com.ci6225.bidzone.pojo.ShoppingCart;
import com.ci6225.bidzone.util.ConnectionUtil;
import com.ci6225.bidzone.util.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ureka
 */
public class ShoppingCartDao {
    public List<Product> getAvailableProductList() throws Exception{
         List<Product> productList = new ArrayList<>();
         String selectStatement = "select p.* , s.name as seller_name, s.description as seller_description from product p, seller s where p.seller_id = s.id and delete_flag = 'F'";  
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
                                float unitPrice = rs.getFloat("unit_price");
                                String sellerName = rs.getString("seller_name");
                                String sellerDescription = rs.getString("seller_description");
                                Product product = new Product(id, name, description, quantity, unitPrice);
                                Seller seller = new Seller(sellerName, sellerDescription);
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
    
    
    public int insertOrder(ShoppingCart cart, int userId) throws Exception{
        String insertStatement = "INSERT INTO order_detail (user_id, payment_method, status, order_date, total_amount, first_name, " +
                "last_name, email, telephone, address1, address2, city, postal_code, country, comments)"
                + " VALUES (?,?,?,NOW(),?,?,?,?,?,?,?,?,?,?,?)"; 
	Connection con = null;
	PreparedStatement ps = null;
        ResultSet rs = null;
        int orderId = 0;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);    
		ps.setInt(1, userId);
		ps.setInt(2, Constants.PAYMENT_METHOD_CASH);
		ps.setInt(3, Constants.ORDER_STATUS_SUCCESS);
		ps.setFloat(4, cart.getTotalPrice());
		ps.setString(5, cart.getFirstName());
		ps.setString(6, cart.getLastName());
                ps.setString(7, cart.getEmail());
                ps.setString(8, cart.getTelephone());
                ps.setString(9, cart.getAddress1());
                ps.setString(10, cart.getAddress2());
                ps.setString(11, cart.getCity());
                ps.setString(12, cart.getPostalCode());
                ps.setString(13, cart.getCountry());
                ps.setString(14, cart.getComments());
		ps.executeUpdate();
                 rs = ps.getGeneratedKeys();
                 
                if(rs.next()){
                  orderId = rs.getInt(1);  
                }
                
                rs.close();
                ps.close();
                
                StringBuilder insertQuery = new StringBuilder("INSERT INTO order_item (order_id, product_id, quantity, amount, status) VALUES ") ;
                int i = 1;
                for (int j = 0; j < cart.getCartItems().size(); j++) {
                    if(j > 0){
                        insertQuery.append(",");
                    }
                     insertQuery.append("(?,?,?,?,?)");                                  
                }
                ps = con.prepareStatement(insertQuery.toString());
                for (CartItem item : cart.getCartItems()) {
                     ps.setInt(i++, orderId);
                     ps.setInt(i++, item.getProductId());
                     ps.setInt(i++, item.getQuantity());
                     ps.setFloat(i++, item.getAmount());
                     ps.setInt(i++ ,Constants.ITEM_STATUS_NEW);
                }
                ps.executeUpdate();
	}
	finally{
                if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
        return orderId;
    }
}
