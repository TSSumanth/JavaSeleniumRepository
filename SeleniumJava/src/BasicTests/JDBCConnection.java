package BasicTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) {
		JDBCConnection object = new JDBCConnection();
		object.startConnection();

	}
	public void startConnection()
	{
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Tssr1993");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from customers");
			while(result.next())
			{
				String name = result.getString("customer_name");
				System.out.println("name: "+ name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
