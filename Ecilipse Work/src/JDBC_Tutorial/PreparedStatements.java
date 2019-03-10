package JDBC_Tutorial;
import java.sql.*;
public class PreparedStatements {
	
public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	try {
		//create connection
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
		//create statement
		String sql = "select * from employees where salary>? and department=?";
		pstm = conn.prepareStatement(sql);
		
		//set the parameters
		pstm.setInt(1, 80000);
		pstm.setString(2, "marketing");
		
		//execute the query
		rs = pstm.executeQuery();
		//display
		while(rs.next()) {
			System.out.print(rs.getInt("salary")+" " +rs.getString("department"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
