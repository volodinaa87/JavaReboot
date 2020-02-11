/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my05_middle_tier;

import java.util.Date;
import java.sql.*;
import java.util.List;

/**
 *
 * @author alex
 */
public class My05_Middle_Tier {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main1(String[] args) throws SQLException {
        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\SB:1433;databaseName=SB";
        try (Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {

            String sqlQuery = "select * from Hackers order by id desc";

            PreparedStatement ps = cn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String prodName = rs.getString(1);
                    String amount = rs.getString(2);
                    System.out.print("ID: " + prodName + "\t");
                    System.out.println("Name: " + amount);
                }

                rs.absolute(4);
                System.out.println(rs.getString(2));
                rs.updateString(2, "<@!Александр Володин!@>");
                rs.updateRow();

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(My05_Middle_Tier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

    }
    
    public static void main(String[] args) throws SQLException {
        //test method
        RepositoryAW repository = new RepositoryAW();
        //constructor not so good
        Date startDate = new Date (100,12,12);
        Date finalDate = new Date (110,12,12);
        List<ProductStatistics> results = repository.getBestSoldProductsInDateRange(startDate, finalDate);
        System.out.println("Size: " + results.size());
        
        for (ProductStatistics ps : results) {
            System.out.print(ps.getProductName() + "\t");
            System.out.println(ps.getSalesAmount());
        }
    }
}
