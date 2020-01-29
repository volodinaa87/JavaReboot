/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmssql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBMSSQLconn {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        try {
            String dbLink = "jdbc:sqlserver://yand.dyndns.org\\AdventureWorks:1433;databaseName=AdventureWorks";
            Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind");
            System.out.println(cn.getClientInfo());
            
            String sqlQuery = "select pp.ProductPhotoID, pp.LargePhotoFileName from Production.ProductPhoto as pp";
            Statement st = cn.createStatement();
            try (ResultSet rs = st.executeQuery(sqlQuery)) {
                while (rs.next()) {
                    String productPhotoID = rs.getString("ProductPhotoID");
                    String largePhotoFileNamename = rs.getString("LargePhotoFileName");
//                    String prodNum = rs.getString("ProductNumber");
//                    System.out.printf("ProductID=%s \t\t\t Name=%s \t\t\t ProductNumber=%s\n ",productPhotoID,largePhotoFileNamename,prodNum);
                    System.out.printf("ProductPhotoID=%s \t\t\t largePhotoFileNamename=%s \n ",productPhotoID,largePhotoFileNamename);
//System.out.println("ProdID: " + prodID + " \tName: " + name + " \tProductNumber: " + prodNum);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBMSSQLconn.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
