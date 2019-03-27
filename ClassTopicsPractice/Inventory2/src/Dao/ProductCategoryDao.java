/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.ProductCategory;
import java.util.List;

/**
 *
 * @author shshe
 */
public interface ProductCategoryDao {
    //crude operation

    void createTable();

    void insert(ProductCategory pc);

    void update(ProductCategory pc);

    void delete(ProductCategory pc);

    //Validation
    ProductCategory getProductCategoryById(int id);

    ProductCategory getProductCategoryByCategoryName(String productCategoryName);

    ///collect data from the database 
    List<ProductCategory> getProductCategory();

}
