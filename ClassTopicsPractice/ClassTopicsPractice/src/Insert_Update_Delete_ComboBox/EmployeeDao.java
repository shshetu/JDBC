/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert_Update_Delete_ComboBox;

import java.util.List;

/**
 *
 * @author User
 */
public interface EmployeeDao {
    //Crude operation

    void createTable();

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

    //validation
    Employee getEmployeeById(int id);

    Employee getEmployeeByName(String name);

    Employee getEmployeeByRole(String role);

    ///get data from database
    List<Employee> getEmployees();
}
