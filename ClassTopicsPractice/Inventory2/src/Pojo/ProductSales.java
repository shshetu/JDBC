/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.sql.Date;

/**
 *
 * @author User
 */
public class ProductSales {

    private int id;
    private String productName;
    private String productCode;
    private int salesQuantity;
    private double unitPrice;
    private Date salesDate;
    private double totalPrice;
    private ProductPurchase productPurchase;

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

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductPurchase getProductPurchase() {
        return productPurchase;
    }

    public void setProductPurchase(ProductPurchase productPurchase) {
        this.productPurchase = productPurchase;
    }

    public ProductSales(int id, String productName, String productCode, int salesQuantity, double unitPrice, Date salesDate, double totalPrice, ProductPurchase productPurchase) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.salesQuantity = salesQuantity;
        this.unitPrice = unitPrice;
        this.salesDate = salesDate;
        this.totalPrice = totalPrice;
        this.productPurchase = productPurchase;
    }

    public ProductSales(String productName, String productCode, int salesQuantity, double unitPrice, Date salesDate, double totalPrice, ProductPurchase productPurchase) {
        this.productName = productName;
        this.productCode = productCode;
        this.salesQuantity = salesQuantity;
        this.unitPrice = unitPrice;
        this.salesDate = salesDate;
        this.totalPrice = totalPrice;
        this.productPurchase = productPurchase;
    }

}
