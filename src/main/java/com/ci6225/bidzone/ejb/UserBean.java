package com.ci6225.bidzone.ejb;

import com.ci6225.bidzone.dao.UserDao;
import com.ci6225.bidzone.pojo.User;
import com.ci6225.bidzone.util.PasswordUtil;
import javax.ejb.Stateless;

@Stateless
public class UserBean {
public User userExist(String username) throws Exception{
		  UserDao userDao = new UserDao();
		User user = userDao.getUserByUsername(username);
		return user;
	}	

	public void addUser(String userCode, String firstName, String lastName, String email, String phone, String country, int userType, String password, String shopName, String description) throws Exception{
		UserDao userDao = new UserDao();
                byte[] salt = PasswordUtil.getSalt();
                String passwordEnc = PasswordUtil.getSecurePassword(password, salt);
		userDao.addUser(userCode, firstName, lastName, email, phone, country, userType, passwordEnc, salt, shopName, description);
	}
        
        public User login(String username, String password) throws Exception{
		UserDao userDao = new UserDao();
		User user = userDao.getUserByUsername(username);
		if(user != null){
			byte[] salt = user.getSalt();
			if(salt != null){
				String hashedPassword = PasswordUtil.getSecurePassword(password, salt);
				if(hashedPassword.equals(user.getPassword())){
					return user;
				}
			}
		}
		return null;
	}
}
