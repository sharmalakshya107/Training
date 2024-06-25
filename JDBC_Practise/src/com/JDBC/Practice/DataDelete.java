package com.JDBC.Practice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DataDelete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fdb","root","1234");
			Statement statement = connection.createStatement();
			String query = "Delete from stdData where id = 02";
			int rowEffect = statement.executeUpdate(query);
			if (rowEffect  > 0)
				System.out.println("Data Deleted Successfully !");
			else
				System.out.println("Data Deletion Unsuccessfull !");
		} catch(SQLException e) {
			// TODD Auto-generated catch block
			e.printStackTrace();
		}
	}
}
