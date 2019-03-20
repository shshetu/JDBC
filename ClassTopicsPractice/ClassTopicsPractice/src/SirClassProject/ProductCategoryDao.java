/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SirClassProject;

/**
 *
 * @author User
 */
public interface ProductCategoryDao {
 
    ///Crude Operation
    void createTable();
    void save(ProductCategory pc);
    void delete(ProductCategory pc);
    void update(ProductCategory pc);
    
            
    
}
