/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.ProductSalesDao;
import Pojo.ProductSales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ProductSalesDaoImp implements ProductSalesDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists productsales(id int(11) auto_increment primary key,product_name varchar(20),product_code varchar(20),sales_qty int(20),unit_price double(20),total_price double(20),sales_date date,ppur_id int(11),foreign key(ppur_id) references productpurchase(id))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("productsales table created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(ProductSales ps) {
        String sql = "insert into productsales(product_name,product_code,sales_qty,unit_price,total_price,sales_date,ppur_id) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ps.getProductName());
            pstm.setString(2, ps.getProductCode());
            pstm.setInt(3, ps.getSalesQuantity());
            pstm.setDouble(4, ps.getUnitPrice());
            pstm.setDouble(5, ps.getTotalPrice());
            pstm.setDate(6, ps.getSalesDate());
            pstm.setInt(7, ps.getProductPurchase().getId());

            pstm.executeUpdate();
            System.out.println("Data is inserted into productsales table!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ProductSales ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ProductSales ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductSales getProductSalesById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductSales getProductSalesByProductCode(String productCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductSales> getProductSales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
