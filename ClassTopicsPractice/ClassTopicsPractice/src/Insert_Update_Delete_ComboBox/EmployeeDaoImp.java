/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert_Update_Delete_ComboBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class EmployeeDaoImp implements EmployeeDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists employee(id int(11) primary key,name varchar(20),role varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("employee table created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insert(Employee employee) {
        String sql = "insert into employee values(?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, employee.getId());
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getRole());
            pstm.executeUpdate();
            System.out.println("Data inserted into employee table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Employee employee) {

        String sql = "update employee set name = ?, role = ? where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, employee.getName());
            pstm.setString(2, employee.getRole());
            pstm.setInt(3, employee.getId());
            pstm.executeUpdate();
            System.out.println("Data Updated into employee table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Employee employee) {

        String sql = "delete from employee where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, employee.getId());
            pstm.executeUpdate();
            System.out.println("Data deleted from  employee table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "select * from employee where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {

        Employee employee = null;
        String sql = "select * from employee where name = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByRole(String role) {

        Employee employee = null;
        String sql = "select * from employee where role = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {

        List<Employee> list = new ArrayList<>();
        String sql = "select * from employee";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Employee> getEmployeesRole() {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT distinct role FROM employee";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setRole(rs.getString(1));
                list.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public List<Employee> getEmployeesbyRole(String role) {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee where role=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(emp);
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
