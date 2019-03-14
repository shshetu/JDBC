package Company;

public class Role {
//Create fields
	private int id;
	private String role_name;
	
	
	//Making the fields public
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	//Create Consturctors
	public Role(int id, String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}
	
}
