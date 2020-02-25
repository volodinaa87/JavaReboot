/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_quiz_exercise;

/**
 *
 * @author alex
 */
public class Product {

    private String productCategory;
    private String productName;
    private String productNumber;
    private double price;

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

}
