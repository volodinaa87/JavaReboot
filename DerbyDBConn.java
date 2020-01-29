/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbderby;

import java.sql.*;

/**
 *
 * @author admin
 */
public class DerbyDBConn {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        System.out.println("Hello, world!!!");
        try (//        Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app")) {
            String sql = "SELECT * FROM PRODUCT";
            Statement stat = cn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()) {
                System.out.println(rs.getString("DESCRIPTION") + " " +
                        rs.getBigDecimal("PURCHASE_COST").toString());
            }
            
            rs.close();
            
            // добавьте код, который разумно выводит таблицу CUSTOMER
            sql = "SELECT * FROM CUSTOMER";
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("NAME") + " " +
                        rs.getString("PHONE"));
            }
        }
    }
    
}
