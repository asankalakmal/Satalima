/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6225.bidzone.dao;

import com.ci6225.bidzone.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Ureka
 */
public class ProductDao {
    public void addProduct(String name, String description, String userCode) throws Exception{
	String insertStatement = "INSERT INTO product (name, description, create_time, created_by, update_time, updated_by)"
                + " VALUES (?,?,NOW(),?,NOW(),?)"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(insertStatement);    
		ps.setString(1, name);
		ps.setString(2, description);
		ps.setString(3, userCode);
                ps.setString(4, userCode);
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
}
}
