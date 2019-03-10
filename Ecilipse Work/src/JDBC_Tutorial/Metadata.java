package JDBC_Tutorial;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Metadata {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// create connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");

			// get metadata
			DatabaseMetaData databaseMetaData = conn.getMetaData();

			// Display info about the database

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
