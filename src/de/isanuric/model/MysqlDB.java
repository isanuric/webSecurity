package de.isanuric.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlDB {
	
	private static final String DB_URL   = "jdbc:mysql://localhost:3306/DB03";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "einis";
	private static final String SQL      = "select * from login where uname=? and upass=?";
	
	public boolean checkUserLoginInfo(String uname, String upass) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection       = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareStatement(SQL);
			
			statement.setString(1, uname);
			statement.setString(2, upass);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return false;
	}

}
