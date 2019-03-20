package SalesMgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImp implements RoleDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        // make query
        String sql = "create table if not exists employees(id int(11) primary key auto_increment,role_name varchar(30))";
        // create Statement
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created Successfully!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public RoleDaoImp() {
        super();
    }

    @Override
    public void insert(Role role) {
        //make query
        String sql = "insert into employees(role_name) values(?)";
        //Create Statement
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getName());
            pstm.executeUpdate();
            System.out.println("Data inserted Successfully!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void update(Role role) {
        // TODO Auto-generated method stub
        //make query
        String sql = "update employees set role_name = ? where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getName());
            pstm.setInt(2, role.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Role role) {
        //make query
        String sql = "delete from employees where id=?";
        //Create Statement
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, role.getId());
            pstm.executeUpdate();
            System.out.println("Record deleted successfully!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Role getRolebyId(int id) {
        // TODO Auto-generated method stub
        Role role = null;
        //make query
        String sql = "select * from employees where id=?";
        //create Statement and execute
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role getRolebyName(String roleName) {
        // TODO Auto-generated method stub
        Role role = null;
        //make query
        String sql = "select * from employees where role_name=?";
        //create and execute Statement
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleName);
           ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));
            }  
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return role;
    }

    //Adding value to the table
    @Override
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();
        //make query
        String sql = "select * from employees";
        //Create and execute Statement
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            //Catch data using ResultSet
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
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
