package com.JSP.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
			String name;
			String password;
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fdb","root","1234");
				Statement statement = connection.createStatement();
				String query = "select * from stdData";
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					name = resultSet.getString("name");
					password = resultSet.getString("password");
				}
				System.out.println("Data successfully Retrieved !");
			} catch(SQLException e) {
				e.printStackTrace();
			}
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			pw.println("Form Submit Successfully");
			String message = "Error! 404";
			pw.printf("Name is " + name);
			res.sendRedirect("/Test2");
			if(name == "xyz" && password == "123" ) {
				RequestDispatcher rd = req.getRequestDispatcher("/Test2");
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("/Test");
				res.setContentType("text/html");
				pw.println(message);
			}
		
	}
		
};
