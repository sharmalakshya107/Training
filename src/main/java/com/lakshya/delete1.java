package com.lakshya;

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

public class delete1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection co;

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakshya", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

   
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
       
       
        pw.print("Form submitted successfully");


        String rollno = req.getParameter("roll-no");

        PreparedStatement st = null;

        try {
            // Corrected update query
            st = co.prepareStatement("delete from college where rollno = ?");
         
            st.setString(1, rollno);

            int deleted = st.executeUpdate();

            if (deleted > 0) {
                pw.print("Updated successfully");
            } else {
                pw.print("No record found with the given roll number");
            }

        } catch (SQLException e) {
            e.printStackTrace(pw);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace(pw);
                }
            }
        }
        res.sendRedirect("index.html");
    }


  
    public void destroy() {
        if (co != null) {
            try {
                co.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
