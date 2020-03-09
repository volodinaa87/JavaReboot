/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my_JSF;

import aw.data.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alex
 */
@Named
public class ProductsBean{


    @Inject
    DataBuilder dbuilder;

    private List<Product> products;
    public List<Product> getProducts() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            return dbuilder.getFullPriceList();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
