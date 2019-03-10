package SalesMgmt;

import java.util.List;

public interface RoleDao {
//Crude operation
	void createTable();
	void insert(Role role);
	void update(Role role);
	void delete(Role role);
	
	//For searching data 
	Role getRolebyId(int id);
	Role getRolebyName(String roleName);
	
	//list type data for adding to the table
	List<Role> getRoles();
}
