/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author User
 */
public class Summary {
 private int id;
 private String productName;
 private String productCode;
  private int totalQty;
 private int soldQty;
 private int availableQty;
 ProductPurchase productPurchase;

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

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public ProductPurchase getProductPurchase() {
        return productPurchase;
    }

    public void setProductPurchase(ProductPurchase productPurchase) {
        this.productPurchase = productPurchase;
    }

    public Summary(int id, String productName, String productCode, int totalQty, int soldQty, int availableQty, ProductPurchase productPurchase) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.productPurchase = productPurchase;
    }

    public Summary(String productName, String productCode, int totalQty, int soldQty, int availableQty, ProductPurchase productPurchase) {
        this.productName = productName;
        this.productCode = productCode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.productPurchase = productPurchase;
    }

    
 
}
