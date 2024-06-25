package com.Servlet.Update;

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

public class UpdateForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String firstName = req.getParameter("fn");
        String lastName = req.getParameter("ln");
        String clgId = req.getParameter("clgId");
        String rollNo = req.getParameter("rllno");
        String course = req.getParameter("crse");
        String subject = req.getParameter("sbj");
        String year = req.getParameter("yr");

        Connection connection = null;
        PreparedStatement selectStmt = null;
        PreparedStatement updateStmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stddata");

            String selectQuery = "SELECT rollNo FROM students WHERE rollNo = ?";
            selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setString(1, rollNo);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE students SET firstName = ?, lastName = ?, clgId = ?, course = ?, subject = ?, year = ? WHERE rollNo = ?";
                updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setString(1, firstName);
                updateStmt.setString(2, lastName);
                updateStmt.setString(3, clgId);
                updateStmt.setString(4, course);
                updateStmt.setString(5, subject);
                updateStmt.setString(6, year);
                updateStmt.setString(7, rollNo);

                int rowEffect = updateStmt.executeUpdate();
                if (rowEffect > 0) {
                    res.sendRedirect("delete.html");
                } else {
                    pw.println("Data Updation is Failed for Roll No: " + rollNo);
                }
            } else {
                pw.println("Roll No: " + rollNo + " is mis-matched");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (selectStmt != null) {
                    selectStmt.close();
                }
                if (updateStmt != null) {
                    updateStmt.close();
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
