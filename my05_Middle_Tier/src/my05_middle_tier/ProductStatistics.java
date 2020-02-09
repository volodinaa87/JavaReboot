/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my05_middle_tier;

/**
 *
 * @author alex
 */
public class ProductStatistics {

    private String productName;
    private double salesAmount;

    public ProductStatistics(String productName, double salesAmount) {
        this.productName = productName;
        this.salesAmount = salesAmount;
    }

    /**
     * Get the value of salesAmount
     *
     * @return the value of salesAmount
     */
    public double getSalesAmount() {
        return salesAmount;
    }

    /**
     * Set the value of salesAmount
     *
     * @param salesAmount new value of salesAmount
     */
    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

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

}
