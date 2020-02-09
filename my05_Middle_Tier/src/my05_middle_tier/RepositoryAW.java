/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my05_middle_tier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alex
 */
public class RepositoryAW {

   public List<ProductStatistics> getBestSoldProductsInDateRange(Date startDate, Date finalDate) throws SQLException {

        List<ProductStatistics> results = new ArrayList<>();
        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\AdventureWorks:1433;databaseName=AdventureWorks";
        try (Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {

            String sqlQuery = "select top 10 Name, Sum(LineTotal) as Amount "
                    + "from sales.salesOrderDetail ss  "
                    + "inner join Production.product pp on ss.ProductID = pp.ProductID "
                    + "inner join Sales.SalesOrderHeader ssh on ss.SalesOrderID = ssh.SalesOrderID "
                    + "where ssh.OrderDate between ? and ? "
                    + "group by Name "
                    + "order by Sum(LineTotal) desc";

            PreparedStatement prep = cn.prepareStatement(sqlQuery);

            prep.setDate(1, java.sql.Date.valueOf(startDate.toString()));
            prep.setDate(2, java.sql.Date.valueOf(finalDate.toString()));

            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
//                    ProductStatistics ps = new ProductStatistics();
//                    ps.setProductName(rs.getString("Name"));
//                    ps.setSalesAmount(rs.getDouble("Amount"));
            //сделать констуктор. через него проще и лучше
                    ProductStatistics ps = new ProductStatistics(rs.getString("Name"), rs.getDouble("Amount"));
                    results.add(ps);

                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(RepositoryAW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        return results;

    }

}
