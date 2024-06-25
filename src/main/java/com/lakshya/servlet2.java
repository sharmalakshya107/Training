package com.lakshya;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/submitform")
public class servlet2 extends HttpServlet {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String check = req.getParameter("check");

        if ("on".equals(check)) {
            pw.print("Form submitted successfully");

            String name = req.getParameter("firstname");
            String name2 = req.getParameter("lastname");
            String uniname = req.getParameter("uni-name");
            String colname = req.getParameter("col-name");
            String rollno = req.getParameter("roll-no");
            String gender = req.getParameter("gender");

            PreparedStatement st = null;

            try {
                st = co.prepareStatement("INSERT INTO college (name, lastname, uniname, colname, rollno, gender) VALUES (?, ?, ?, ?, ?, ?)");
                st.setString(1, name);
                st.setString(2, name2);
                st.setString(3, uniname);
                st.setString(4, colname);
                st.setString(5, rollno);
                st.setString(6, gender);

                st.executeUpdate();

                pw.print(name);
                pw.print(name2);
                pw.print(uniname);
                pw.print(colname);
                pw.print(rollno);
                pw.print(gender);

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
            res.sendRedirect("update.html");
        } else {
            pw.print("Form submission failed: checkbox not selected");
        }
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
