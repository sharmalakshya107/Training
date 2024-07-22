package lakshya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakshya", "root", "");
             Scanner scanner = new Scanner(System.in)) {

           
            System.out.print("Enter the number of users to insert: ");
            int numUsers = scanner.nextInt();
            scanner.nextLine(); 

            String insertQuery = "INSERT INTO login (name, pass) VALUES (?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                for (int i = 0; i < numUsers; i++) {
                    System.out.print("Enter username to insert: ");
                    String nameToInsert = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String passwordToInsert = scanner.nextLine();

                    insertStatement.setString(1, nameToInsert);
                    insertStatement.setString(2, passwordToInsert);
                    int insertResult = insertStatement.executeUpdate();

                    if (insertResult > 0) {
                        System.out.println("Insertion successful for user: " + nameToInsert);
                    } else {
                        System.out.println("Insertion failed for user: " + nameToInsert);
                    }
                }
            }

         
            System.out.print("Enter username to update password: ");
            String nameToUpdate = scanner.nextLine();

            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();

            String updateQuery = "UPDATE login SET pass = ? WHERE name = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newPassword);
                updateStatement.setString(2, nameToUpdate);
                int updateResult = updateStatement.executeUpdate();

                if (updateResult > 0) {
                    System.out.println("Update successful.");
                } else {
                    System.out.println("Update failed. User not found or no changes made.");
                }
            }

       
            String selectQuery = "SELECT * FROM login";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStatement.executeQuery()) {

                while (resultSet.next()) {
                    String username = resultSet.getString("name");
                    String password = resultSet.getString("pass");
                    System.out.println(username + " " + password);
                }
            }

           
            System.out.print("Enter username to delete: ");
            String nameToDelete = scanner.nextLine();

            String deleteQuery = "DELETE FROM login WHERE name = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, nameToDelete);
                int deleteResult = deleteStatement.executeUpdate();

                if (deleteResult > 0) {
                    System.out.println("Deletion successful.");
                } else {
                    System.out.println("Deletion failed. User not found or no changes made.");
                }
            }

        
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStatement.executeQuery()) {

                while (resultSet.next()) {
                    String username = resultSet.getString("name");
                    String password = resultSet.getString("pass");
                    System.out.println(username + " " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
