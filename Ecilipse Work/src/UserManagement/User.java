package UserManagement;

public class User {

	//Declaring fields
	private int id;
	private String userName;
	private String password;
	private String mobile;
	private Role role;
	
	//Making the fields public
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	//Creating constructors
	public User(int id, String userName, String password, String mobile, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
	}
	
	
	
}
