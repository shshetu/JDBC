package SalesMgmt;

public class ConnectionTest {
public static void main(String[] args) {
	CustomDBConnection.getConnection();
        RoleDao r = new RoleDaoImp();
        r.createTable();
}
}
