package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomDBConnection {
	//declare in variables
 static String  DB_NAME="jdbc:mysql://localhost:3306/company";
 static String  USER = "root";
 static String  PASS = "1234";
 static Connection conn = null;
	//Call the Connection 
public static Connection getConnection() {
	try {
//		conn = DriverManager.getConnection(DB_NAME,USER,PASS);
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","1234");
            System.out.println("Successfully Connected to the Database!");
        } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}
   
}
