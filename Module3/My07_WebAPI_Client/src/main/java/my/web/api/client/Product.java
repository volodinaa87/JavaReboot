/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

/**
 *
 * @author alex
 */
public class Product {

    private String productCategory;
    private String productName;
    private String productNumber;
    private double price;

    
    public Product() {
    }
    /**
     *
     * @param productCategory
     * @param productName
     * @param productNumber
     * @param price
     */

    public Product(String productCategory, String productName, String productNumber, double price) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productNumber = productNumber;
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{productCategory=").append(productCategory);
        sb.append(", productName=").append(productName);
        sb.append(", productNumber=").append(productNumber);
        sb.append(", price=").append(price);
        sb.append("}");
        return sb.toString();
    }

}
