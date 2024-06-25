package com.JDBC.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;

public class MySqlDataModification {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			
			System.out.print("Enter number of records you want to enter: ");
			int noOfRecord = scanner.nextInt();
			
			while (noOfRecord > 0) {
				System.out.print("Employee Id: ");
				int empId = scanner.nextInt();
				scanner.nextLine(); // Consume the newline left-over
				
				System.out.print("Employee Name: ");
				String empName = scanner.nextLine();
				
				System.out.print("Employee Salary: ");
				String empSalary = scanner.nextLine();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "1234");
					
					String query = "INSERT INTO EmployeeData (empId, empName, empSalary) VALUES (" 
					             + empId + ", '" + empName + "', '" + empSalary + "')";
					
					preparedStatement = connection.prepareStatement(query);
					
					int rowEffect = preparedStatement.executeUpdate();
					
					if (rowEffect > 0) {
						System.out.println("Data Entered Successfully!...\n");
					} else {
						System.out.println("Data Entry Unsuccessful....");
					}
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				noOfRecord--;
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
