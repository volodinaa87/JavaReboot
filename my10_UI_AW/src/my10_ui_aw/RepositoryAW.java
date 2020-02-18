/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my10_ui_aw;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class RepositoryAW {

    public String connectionString = "jdbc:sqlserver://yand.dyndns.org:1433;databaseName=AdventureWorks";
    public String user = "northwind";
    public String pwd = "northwind";

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Connection cn = DriverManager.getConnection(connectionString, user, pwd)) {
            String sql = "select ProductID,Name,ProductNumber,ListPrice from Production.Product";
            Statement stat = cn.createStatement();
            try (ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt("ProductID"),
                            rs.getString("Name"),
                            rs.getString("ProductNumber"),
                            rs.getDouble("ListPrice")));
                
                }
            }
        }

        return products;
    }
    
    public List<Product> getProducts(String filter) throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Connection cn = DriverManager.getConnection(connectionString, user, pwd)) {
            String sql = "select ProductID,Name,ProductNumber,ListPrice from Production.Product "
                    + "where Name like ?";
            
            PreparedStatement prstat = cn.prepareStatement(sql);
            prstat.setString(1, filter + "%");
            try (ResultSet rs = prstat.executeQuery()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt("ProductID"),
                            rs.getString("Name"),
                            rs.getString("ProductNumber"),
                            rs.getDouble("ListPrice")));
                
                }
            }
        }

        return products;
    }
}
