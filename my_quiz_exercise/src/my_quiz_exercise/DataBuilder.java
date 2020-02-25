/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_quiz_exercise;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 * generate data from db for pricelist generator
 */
public class DataBuilder {

    public List<Product> getFullPriceList() throws SQLException {

        List<Product> results = new ArrayList<>();
        DAO daoCred = new DAO();

        try (Connection conn = DriverManager.getConnection(daoCred.getDbURL(), daoCred.getUser(), daoCred.getPwd())) {
            String sqlQuery = "SELECT pps.Name as \"SubCategory\" "
                    + ",pp.Name as \"ProductName\" "
                    + ",pp.ProductNumber as \"ProductNumber\" "
                    + ",pp.ListPrice as \"Price\" "
                    + "from Production.product pp "
                    + "join Production.ProductSubcategory pps on pp.ProductSubcategoryID = pps.ProductSubcategoryID "
                    + "and pp.ProductSubcategoryID is not null;";
            PreparedStatement prep = conn.prepareStatement(sqlQuery);

            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    Product ps = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                    results.add(ps);
                }

            } catch (SQLException ex) {
                Logger.getLogger(DataBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;

    }

}

//SELECT pps.Name as "SubCategory"
//,pp.Name as "ProductName"
//,pp.ProductNumber as "ProductNumber"
//,pp.ListPrice as "Price"
//from Production.product pp
//join Production.ProductSubcategory pps on pp.ProductSubcategoryID = pps.ProductSubcategoryID
//and pp.ProductSubcategoryID is not null;