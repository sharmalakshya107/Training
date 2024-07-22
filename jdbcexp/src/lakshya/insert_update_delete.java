package lakshya;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insert_update_delete {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakshya","root","");
			Statement statement = connection.createStatement();
			String query = "insert into login (name,pass) values('laks60','rty90')";
			int i=statement.executeUpdate(query);
			int y=statement.executeUpdate("update login set pass='aryanC' where name ='laks60'");
			int x=statement.executeUpdate("delete from login where Email is NULL");
if(i>0&y>0&x>0)
{
	System.out.println(true);
}
else
{
	System.out.println(false);
		}	
ResultSet resultSet=statement.executeQuery("Select * from login");
			while(resultSet.next()) {
				//int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String pass = resultSet.getString("pass");
				System.out.println( name + " " + pass);
			}
		} catch(SQLException e) {
			// TODD Auto-generated catch block
			e.printStackTrace();
		}
	}
}