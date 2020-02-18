/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.List;
import my10_ui_aw.Product;
import my10_ui_aw.RepositoryAW;

/**
 *
 * @author alex
 */
public class TestRepositoryAW {

    public static void main(String[] args) throws SQLException {
        RepositoryAW repository = new RepositoryAW();
        List<Product> prod = repository.getAllProducts();
        System.out.println(prod.size());
        prod = repository.getProducts("A");
        System.out.println(prod.size());
    }

}
