package JDBC_Tutorial;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class InsertDataIntoMySQLDatabase {
public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String pass = "1234";
try {
	//2. Create Connection
	Connection myconn = DriverManager.getConnection(url,user,pass);
	//3. Create Statement
	Statement stmt = myconn.createStatement();
	
	//4. Execute Statement
	String sql = "insert into employees(last_name,first_name,email) values('Brown','David','david.brown@foo.com')";
	stmt.executeUpdate(sql);
	System.out.println("insert completed!");
} catch (Exception e) {
e.printStackTrace();
}
	
}
	
	
}
