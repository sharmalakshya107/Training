package com.JDBC.Practice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DataEntry {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fdb","root","1234");
				Statement statement = connection.createStatement();
				String query = "insert into stdData (id,name,city) values (04,'Kuldeep','Delhi')";
				int rowEffect = statement.executeUpdate(query);
				if (rowEffect  > 0)
					System.out.println("Data Inserted Successfully");
				else
					System.out.println("Data Entry Unsuccessfull !");
			} catch(SQLException e) {
					// TODD Auto-generated catch block
					e.printStackTrace();
			  }
	}
}
