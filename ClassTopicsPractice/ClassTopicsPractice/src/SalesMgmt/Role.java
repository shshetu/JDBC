package SalesMgmt;

public class Role {
//Declaring fields
	private int id;
	private String role_name;
	
	public Role(int id, String name) {
		super();
		this.id = id;
		this.role_name = name;
	}

	public Role() {
		super();
	}

    public Role(String role_name) {
        this.role_name = role_name;
    }

    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return role_name;
	}

	public void setName(String name) {
		this.role_name = name;
	}
	
}
