package SalesMgmt;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomDBConnection {

public static Connection getConnection() {
	Connection conn = null;
	String dbname = "salesmgmt";
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root","1234");
		System.out.println("Connected to the database: "+dbname);
               
	} catch (Exception e) {
		// TODO: handle exception
	}
	return conn;
}
}
