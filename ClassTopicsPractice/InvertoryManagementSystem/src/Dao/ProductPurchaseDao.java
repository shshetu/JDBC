/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.ProductPurchase;
import java.util.List;

/**
 *
 * @author shshe
 */
public interface ProductPurchaseDao {

    //crude operation
    void createTable();

    void insert(ProductPurchase pc);

    void update(ProductPurchase pc);

    void delete(ProductPurchase pc);

    //Validation
    ProductPurchase getProductPurchaseByProductPurchaseId(int id);

    ProductPurchase getProductPurchaseByProductPurchaseName(String productCategoryName);

    ///collect data from the database 
    List<ProductPurchase> getProductPurchase();
}
