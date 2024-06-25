package com.JDBC.Practice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetrieving {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fdb","root","1234");
			Statement statement = connection.createStatement();
			String query = "select * from stdData";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String city = resultSet.getString("city");
				System.out.println(id + " " + name + " " + city);
			}
			System.out.println("Data successfully Retrieved !");
		} catch(SQLException e) {
			// TODD Auto-generated catch block
			e.printStackTrace();
		}
	}
}
