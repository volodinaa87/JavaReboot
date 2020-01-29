/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DbAccess {

    /**
     * @param args the command line arguments     * @throws java.sql.SQLException
     */
    public static void main(String[] args) {
        try {
            String dbLink = "jdbc:ucanaccess://F:/Программирование/REBOOT_Java_Sberbank/Java_Level_2/AccessForJava/AWSales.accdb";
            Connection cn = DriverManager.getConnection(dbLink, "", "");
            System.out.println(cn.getClientInfo());
            
            String sqlQuery = "select ProductID,Name,ProductNumber from products where rownum <15 order by 1";
            Statement st = cn.createStatement();
            try (ResultSet rs = st.executeQuery(sqlQuery)) {
                while (rs.next()) {
                    String prodID = rs.getString("ProductID");
                    String name = rs.getString("Name");
                    String prodNum = rs.getString("ProductNumber");
                    System.out.printf("ProductID=%s \t\t\t Name=%s \t\t\t ProductNumber=%s\n ",prodID,name,prodNum);
//System.out.println("ProdID: " + prodID + " \tName: " + name + " \tProductNumber: " + prodNum);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
