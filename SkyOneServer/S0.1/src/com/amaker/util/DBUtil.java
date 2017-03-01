package com.amaker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.amaker.res.MyError;


public class DBUtil {
	
	//Get DataBase connection by properties file
	public Connection getConnection(){
		
		Properties properties = new Properties();
		
		String driver = null;
		String url = null;
		String name = null;
		String password = null;
		
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			
			//Set value
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			name = properties.getProperty("username");
			password = properties.getProperty("password");
			
			//Load driver
			Class.forName(driver);
			
			return DriverManager.getConnection(url, name, password);
			
		} catch (Exception e) {
			System.out.println(MyError.DATABASE_CONN_ERROR);
			e.printStackTrace();
		}
		return null;
	}
	
	public void CloseConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
