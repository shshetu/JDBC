package section3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Video10InsertingDataIntoTheDatabase {
public static void main(String[] args) {
	
	///Declare the Classes
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//Declare the variables
	String dbUrl = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String pass = "1234";
	
	try {
		//1.Create Connection
		conn = DriverManager.getConnection(dbUrl,user,pass);
		//2. Create Statement
		stmt = conn.createStatement();
		//3. Execute Statement
		System.out.println("Inserting a new employee to database\n");
		//make a query
		String sql = "insert into employees(last_name,first_name,email,salary,department)"+ 
		"values('Belal','parvez','sdfsd@gmail.com','study',3433443)";
		stmt.executeUpdate(sql);
		
		//4.Process the resultSet
		String sql2 = "select * from employees order by last_name";
		stmt.executeUpdate(sql2);
		while(rs.next()) {
			System.out.println(rs.getString("last_name")+", "+rs.getString("first_name"));
			
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
	
}
