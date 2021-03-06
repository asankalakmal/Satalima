package com.ci6225.marketzone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionUtil {
	public static String url = Properties.getProperty("DATABASE_URL");
	public static String dbdriver = Properties.getProperty("DATABASE_DRIVER");
	public static String username = Properties.getProperty("DATABASE_USERNAME");
	public static String password = Properties.getProperty("DATABASE_PASSWORD");
        public static String connectionPool = Properties.getProperty("CONNECTION_POOL");

	public static Connection createConnection() throws Exception{
		Connection con = null;
		try {
                    Context ctx = new InitialContext();
                    DataSource  ds = (DataSource)ctx.lookup(connectionPool);
                    con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("Exception in ConnectionUtil.createConnection(): " + ex);
			throw new Exception("Couldn't open connection to database: " +
					ex.getMessage());
		}
		return con;
	}
}
