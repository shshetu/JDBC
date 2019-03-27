/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.SummaryDao;
import Pojo.ProductPurchase;
import Pojo.Summary;
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
 * @author User
 */
public class SummaryDaoImp implements SummaryDao{
Connection conn = CustomDBConnection.getConnection();
    @Override
    public void createTable() {
        String sql = "create table if not exists summary(id int(20) auto_increment primary key,product_name varchar(20),product_code varchar(20),total_qty int(20),sold_qty int(20),available_qty int(20),pcat_id int(20),foreign key (pcat_id) references productpurchase(id))";
    try {
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        System.out.println("summary table is created successfully!");
    } catch (SQLException ex) {
        Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void insert(Summary summary) {
        String sql = "insert into summary(product_name,product_code,total_qty,sold_qty,available_qty,pcat_id) values(?,?,?,?,?,?)";
    try {
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, summary.getProductName());
        pstm.setString(2, summary.getProductCode());
        pstm.setInt(3, summary.getTotalQty());
        pstm.setInt(4, summary.getSoldQty());
        pstm.setInt(5, summary.getAvailableQty());
        pstm.setInt(6, summary.getProductPurchase().getId());
        System.out.println("Data is inserted successfully into summary table!");
    } catch (SQLException ex) {
        Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Summary summary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Summary summary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Summary getSummaryByProductCode(String productCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Summary> getList() {
        List<Summary> list = new ArrayList<Summary>();
        String sql = "select * from summary";
    try {
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
        Summary summary = new Summary(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), new ProductPurchase(rs.getInt(7)));
        list.add(summary);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
}
