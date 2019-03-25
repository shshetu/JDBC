/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.ProductPurchaseDao;
import Pojo.ProductCategory;
import Pojo.ProductPurchase;
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
 * @author shshe
 */
public class ProductPurchaseDaoImp implements ProductPurchaseDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists productpurchase(id int(11) auto_increment primary key,product_name varchar(50),product_code varchar(30),unit_price double,quantity int(11),total_price double,purchase_date date,p_cat_id int(5),foreign key(p_cat_id) references productcategory(id))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("productpurchase table created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductPurchaseDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(ProductPurchase pc) {
        String sql ="insert into productpurchase(product_name,product_code,unit_price,quantity,total_price,purchase_date,p_cat_id) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,pc.getProductName());
            pstm.setString(2,pc.getProductCode());
            pstm.setDouble(3,pc.getUnitPrice());
            pstm.setInt(4,pc.getQuantity());
            pstm.setDouble(5,pc.getTotalPrice());
            pstm.setDate(6,pc.getDate());
            pstm.setInt(7,pc.getProductCategory().getId());
            pstm.executeUpdate();
            System.out.println("Data is inserted successfully in productpurchase table!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductPurchaseDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ProductPurchase pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ProductPurchase pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductPurchase getProductPurchaseByProductPurchaseId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductPurchase getProductPurchaseByProductPurchaseName(String productCategoryName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductPurchase> getProductPurchase() {
        List<ProductPurchase> list = new ArrayList<>();
        String sql = "select * from productpurchase";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            ProductPurchase ps = new ProductPurchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),rs.getDouble(6), new ProductCategory(rs.getInt(7)));
            list.add(ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductPurchaseDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

}
