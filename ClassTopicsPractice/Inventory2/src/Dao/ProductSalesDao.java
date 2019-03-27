/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.ProductSales;
import java.util.List;

/**
 *
 * @author User
 */
public interface ProductSalesDao {
   //Crude operation
    void createTable();
    void insert(ProductSales ps);
    void update(ProductSales ps);
    void delete(ProductSales ps);

//validation
   ProductSales getProductSalesById(int id);
   ProductSales getProductSalesByProductCode(String productCode);
   
   //Get data from database
   List<ProductSales> getProductSales();
}
