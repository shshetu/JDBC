import java.sql.*;
public class DriverDemo {

	
	public static void main(String[] args) {
		try {
			//1.Create a connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
					//2. Create Statement
					Statement stmt = conn.createStatement();
				//Make query
				String sql = "Select * from employees";
				//Execute Statement
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) 
				
				{
					System.out.println(rs.getString("first_name")+ " "+rs.getString("last_name"));
					
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}


