/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my10_ui_aw;

/**
 *
 * @author alex
 */
public class Product {

    public Product(int id,String productNumber, String productName, double price) {
        this.id = id;
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
    }
    
    private String productNumber;

    /**
     * Get the value of productNumber
     *
     * @return the value of productNumber
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * Set the value of productNumber
     *
     * @param productNumber new value of productNumber
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    private double price;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }
private String productName;

    /**
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

}
