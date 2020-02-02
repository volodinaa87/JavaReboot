/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmssql;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

/**
 *
 * @author admin
 */
public class dbMSSQLhomework_filters {

    public static void main(String[] args) {
        String dbLink = "jdbc:derby://localhost:1527/sample";
        try (Connection cn = DriverManager.getConnection(dbLink, "app", "app");) {
//            System.out.println("Enter filter: " + System.in);
//            Scanner scan = new Scanner (System.in);
//            String filterName = Scanner (in)
//            String filterName = "B%";
            Map param = new HashMap();

            param.put("available", "true");
            param.put("purchase_cost_from", "10");
            param.put("purchase_cost_to", "50");
            param.put("product_id", "988765,975789,986712");
            param.put("manufacturer_id", "19965794,19977775,19989719");
            param.put("order_by", "purchase_cost");
            param.put("order_by_flow", "asc");

            String sqlQuery = "select product_id, manufacturer_id, purchase_cost, available, description "
                    + "from product "
                    + "where "
                    + "available = ? and "
                    + "purchase_cost between ? and ? and "
                    + "product_id in ( ? )"
                    + " and "
                    + "manufacturer_id in (?) "
                    + "order by ? ?;";

            PreparedStatement ps = cn.prepareStatement(sqlQuery);

            ps.setString(1, param.get("available").toString());
            ps.setInt(2, (int) param.get("purchase_cost_from"));
            ps.setInt(3, (int) param.get("purchase_cost_to"));
            ps.setString(4, param.get("product_id").toString());
            ps.setInt(5, (int) param.get("manufacturer_id"));
            ps.setString(6, param.get("order_by").toString());
            ps.setString(7, param.get("order_by_flow").toString());
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String prodName = rs.getString("product_id");
//                    String prodName = rs.getString("Name");
//                    String prodName = rs.getString("Name");
//                    String prodName = rs.getString("Name");
//                    String prodName = rs.getString("Name");
//                    String prodName = rs.getString("Name");
                    System.out.println("Report by Filters:" + prodName);
//                    System.out.printf("Product_ID: %n", prodName);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(dbMSSQLhomework_filters.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
