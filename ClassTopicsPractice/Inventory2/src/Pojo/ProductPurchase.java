/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.sql.Date;

/**
 *
 * @author shshe
 */
public class ProductPurchase {
    private int id;
    private String productName;
    private String productCode;
    private double unitPrice;
    private int quantity;
    private double totalPrice;
    private Date date;
    private ProductCategory productCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductPurchase(int id, String productName, String productCode, double unitPrice, int quantity, double totalPrice, Date date, ProductCategory productCategory) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.productCategory = productCategory;
    }

    public ProductPurchase(String productName, String productCode, double unitPrice, int quantity, double totalPrice, Date date, ProductCategory productCategory) {
        this.productName = productName;
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.productCategory = productCategory;
    }

    public ProductPurchase(int id) {
        this.id = id;
    }
    
}
