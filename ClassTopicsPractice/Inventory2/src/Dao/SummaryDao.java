/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.Summary;
import java.util.List;

/**
 *
 * @author User
 */
public interface SummaryDao {
    ///crude operation
    void createTable();
    void insert(Summary summary);
    void update(Summary summary);
    void delete(Summary summary);
    
    Summary getSummaryByProductCode(String productCode);
    List<Summary> getList();
}
