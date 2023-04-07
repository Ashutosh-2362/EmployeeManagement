package com.app.empapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	static Connection con = null;
	public static Connection getConnection() {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/cj_3_5";
			String username = "root";
			String password = "";
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
