package Company;

import java.util.List;

public interface RoleDao {
//Crude Operation
	void createTable();
	void insert(Role role);
	void update(Role role);
	void delete(Role role);
	
	//list for adding into table
	List<Role> getRoles();
}
