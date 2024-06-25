package com.Servlet.Insert;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubmitForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String firstName = req.getParameter("fn");
        String lastName = req.getParameter("ln");
        String gender = req.getParameter("gender");  // Assuming gender parameter is added
        String clgId = req.getParameter("clgId");
        String rollNo = req.getParameter("rllno");
        String course = req.getParameter("crse");
        String subject = req.getParameter("sbj");
        String year = req.getParameter("yr");

        Connection connection = null;
        PreparedStatement insertStmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StdData", "root", "");

            String insertQuery = "INSERT INTO students (firstName, lastName, gender, clgId, rollNo, course, subject, year) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, firstName);
            insertStmt.setString(2, lastName);
            insertStmt.setString(3, gender);
            insertStmt.setString(4, clgId);
            insertStmt.setString(5, rollNo);
            insertStmt.setString(6, course);
            insertStmt.setString(7, subject);
            insertStmt.setString(8, year);

            int rowEffect = insertStmt.executeUpdate();
            if (rowEffect > 0) {
                res.sendRedirect("update.html");
            } else {
                pw.println("Form Submission Failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (insertStmt != null) {
                    insertStmt.close();
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
