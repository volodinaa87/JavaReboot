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
public class dbMSSQLhomework {

    public static void main(String[] args) {
        String dbLink = "jdbc:ucanaccess://F:/Программирование/REBOOT_Java_Sberbank/Java_Level_2/AccessForJava/AWSales.accdb";
        try (Connection cn = DriverManager.getConnection(dbLink, "", "");) {
            String filterName = "B%";
            String sqlQuery = "select ProductID,Name,ProductNumber from products where name like ? order by 1";

            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setString(1, filterName);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String prodName = rs.getString("Name");
                    System.out.printf("Name of Products, startsWith(B): %s\n", prodName);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(dbMSSQLhomework.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
