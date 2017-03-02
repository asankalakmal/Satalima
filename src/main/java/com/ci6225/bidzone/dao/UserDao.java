package com.ci6225.bidzone.dao;

import com.ci6225.bidzone.pojo.User;
import com.ci6225.bidzone.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {

	/*public List<User> getAllUserList() throws Exception{
		String selectStatement = "select * " + "from user";  
		List<User> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("UserID"));
				user.setFirstName(rs.getString("FirstName"));
				userList.add(user);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return userList;
	}*/
	
	public User getUserByUsernamePassword(String username, String password) throws Exception{
		String selectStatement = "select * from user where Usercode=? and Password=?";  
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
                            user = new User();
                            user.setUsercode(rs.getString("usercode"));
                            user.setFirstName(rs.getString("First_Name"));
                            user.setLastName(rs.getString("Last_Name"));
                            user.setEmail(rs.getString("email"));
                            user.setPhone(rs.getString("phone"));
                            user.setCountry(rs.getString("country"));
                            user.setUserType(rs.getInt("user_type_id"));
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return user;
	}
	

public User getUserByUsername(String username) throws Exception{
	String selectStatement = "select * from user where Usercode=?";  
	User user = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(selectStatement);    
		ps.setString(1, username);
		rs = ps.executeQuery();

		if (rs.next()) {
			user = new User();
			//user.setId(rs.getInt("userID"));
			user.setUsercode(rs.getString("usercode"));
			user.setFirstName(rs.getString("First_Name"));
			user.setLastName(rs.getString("Last_Name"));
                        user.setEmail(rs.getString("email"));
                        user.setPhone(rs.getString("phone"));
                        user.setCountry(rs.getString("country"));
			user.setUserType(rs.getInt("user_type_id"));
		} 
	}
	finally{
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
	return user;
}

public void addUser(String userCode, String firstName, String lastName, String email, String phone, String country, int userType, String password, byte[] salt) throws Exception{
	String insertStatement = "INSERT INTO user (usercode, first_name, last_name, email,phone,country,user_type_id,Password,salt,account_status,create_time,created_by,update_time,updated_by)"
                + " VALUES (?,?,?,?,?,?,?,?,?,1,NOW(),?,NOW(),?)"; 
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = ConnectionUtil.createConnection();
		ps = con.prepareStatement(insertStatement);    
		ps.setString(1, userCode);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setString(6, country);
                ps.setInt(7, userType);
                ps.setString(8, password);
                ps.setBytes(9, salt);
                ps.setString(10, userCode);
                ps.setString(11, userCode);
		ps.executeUpdate();
	}
	finally{
		if(ps != null) ps.close();
		if(con != null) con.close();
	}
}

}