package com.JDBC.Practice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DataUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fdb","root","1234");
			Statement statement = connection.createStatement();
			String query = "update stdData set City = 'Ajmer' where id = 03";
			int rowEffect = statement.executeUpdate(query);
			if (rowEffect  > 0)
				System.out.println("Data Updated Successfully !");
			else
				System.out.println("Data Updation Unsuccessfull !");
		} catch(SQLException e) {
			// TODD Auto-generated catch block
			e.printStackTrace();
		}
	}
}
