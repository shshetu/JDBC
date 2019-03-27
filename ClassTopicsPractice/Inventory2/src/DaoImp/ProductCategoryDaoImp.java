/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.ProductCategoryDao;
import Pojo.ProductCategory;
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
public class ProductCategoryDaoImp implements ProductCategoryDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists productcategory(id int(5) auto_increment primary key,cat_name varchar(30) unique)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("productcategory table is created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(ProductCategory pc) {
        String sql = "insert into productcategory(cat_name) values(?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, pc.getCatName());
            pstm.executeUpdate();
            System.out.println("Data is inserted into productcategory table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ProductCategory pc) {
        String sql = "update productcategory set cat_name = ? where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, pc.getCatName());
            pstm.setInt(2, pc.getId());
            pstm.executeUpdate();
            System.out.println("Data is updated into productcategory table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(ProductCategory pc) {

        String sql = "delete from productcategory where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pc.getId());
            pstm.executeUpdate();
            System.out.println("Data is deleted from productcategory table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        ProductCategory pc = null;
        String sq1 = "select * from productcategory where id= ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sq1);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pc = new ProductCategory(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    @Override
    public ProductCategory getProductCategoryByCategoryName(String productCategoryName) {

        ProductCategory pc = null;
        String sq1 = "select * from productcategory where cat_name= ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sq1);
            pstm.setString(1, productCategoryName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pc = new ProductCategory(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    @Override
    public List<ProductCategory> getProductCategory() {
        List<ProductCategory> list = new ArrayList<>();
        String sq1 = "select * from productcategory";
        try {
            PreparedStatement pstm = conn.prepareStatement(sq1);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory(rs.getInt(1), rs.getString(2));
                list.add(pc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
