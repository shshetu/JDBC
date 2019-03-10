package UserManagement;

import java.util.List;

public interface UserDao {

	//Create table
	void createTable();
	
	//Crude Operation
	void insert(User user);
	void update(User user);
	void delete(User user);
	
	//User type to Search
	User getUserById(int id);
	User getUserByName(String username);
	
	///List type data to add in the table
	List<User> getUsers();
}
