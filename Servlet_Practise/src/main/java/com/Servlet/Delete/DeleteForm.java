package com.Servlet.Delete;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String rollNo = req.getParameter("rllno");

        Connection connection = null;
        PreparedStatement selectStmt = null;
        PreparedStatement deleteStmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stddata");

            String selectQuery = "SELECT rollNo FROM students WHERE rollNo = ?";
            selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setString(1, rollNo);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String deleteQuery = "DELETE FROM students WHERE rollNo = ?";
                deleteStmt = connection.prepareStatement(deleteQuery);
                deleteStmt.setString(1, rollNo);

                int rowEffect = deleteStmt.executeUpdate();
                if (rowEffect > 0) {
                    res.sendRedirect("index.html");
                } else {
                    pw.println("Data Deletion is failed for Roll No: " + rollNo);
                }
            } else {
                pw.println("Record with Roll No: " + rollNo + " not found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (selectStmt != null) {
                    selectStmt.close();
                }
                if (deleteStmt != null) {
                    deleteStmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
