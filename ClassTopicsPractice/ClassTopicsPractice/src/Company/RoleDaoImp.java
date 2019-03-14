package Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImp implements RoleDao{
	Connection conn = CustomDBConnection.getConnection();
	@Override
	public void createTable() {
		//Make the query
		String sql = "create table if not exists employees(id int(20) primary key auto_increment,role_name varchar(20))";
		//Create Statement
	try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.execute();
		//Give a message : operation successful
		System.out.println("employees table created successfully!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void insert(Role role) {
		// TODO Auto-generated method stub
		//make the query
		String sql = "insert into employees(role_name) values=?";
		//Create statement
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
		//Execute the query
			pstm.setString(1, role.getRole_name());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> getRoles() {
		// We get all the values from the database
		List<Role> list = new ArrayList<Role>();
		//make the query
		String sql = "select * from employees";
		//Create statement
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			//Send the Data to the Role class using ResultSet
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				//pass data to the role object using ResultSet
				Role role = new Role(rs.getInt(1), rs.getString(2));
				list.add(role);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
