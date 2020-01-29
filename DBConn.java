/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my02_dbconn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hsqldb.lib.InputStreamWrapper;

/**
 *
 * @author 16696866
 */
public class DBConn {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
//    public static void main(String[] args) throws ClassNotFoundException {
//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\16696866\\Work\\ReebootSchoolJava\\msAccessDB\\AWSales.accdb")) {
//            System.out.println(conn.getCatalog());
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    без параметров селект
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
////        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\16696866\\Work\\ReebootSchoolJava\\msAccessDB\\AWSales.accdb")) {
////            System.out.println("Schema: " + conn.getSchema());
//            //update на %
////HashMap <String,String> mapValues = null;
//            String sqlQuery = "select ProductID,name,ProductNumber,ListPrice from products where name like 'Mountain%%48'";
//            Statement stat = conn.createStatement();
//
//            try (ResultSet rs = stat.executeQuery(sqlQuery)) {
////                rs.next();
////int i = 0;
//                while (rs.next()) {
////                    String key = "Name"+ i +": " ;
//                    System.out.print("ProductID: " + rs.getInt("PRODUCTID"));
//                    System.out.print("\t");
//                    System.out.print("Name: " + rs.getString("NAME"));
//                    System.out.print("\t");
//                    System.out.print("ProductNumber: " + rs.getString("PRODUCTNUMBER"));
//                    System.out.print("\t");
//                    System.out.print("ListPrice: " + rs.getDouble("ListPrice"));
//                    System.out.println("");
////                    mapValues.put(key, rs.getString("NAME"));
////                System.out.println("PURCHASE_COST: " + rs.getBigDecimal("PURCHASE_COST"));
//                }
//            }
//
//        } catch (SQLException|NullPointerException ex) {
//            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    селект с фильтром
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
////        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//String filter = "B%";
//        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\16696866\\Work\\ReebootSchoolJava\\msAccessDB\\AWSales.accdb")) {
////            System.out.println("Schema: " + conn.getSchema());
//            //update на %
////HashMap <String,String> mapValues = null;
////            String sqlQuery = "select ProductID,name,ProductNumber,ListPrice from products where name like 'Mountain%[0-3]%48'";
//            String sqlQuery = "select ProductID,name,ProductNumber,ListPrice from products where name like ?";
//
//            PreparedStatement prep = conn.prepareStatement(sqlQuery);
//            prep.setString(1, filter);
//
//            try (ResultSet rs = prep.executeQuery()) {
////                rs.next();
////int i = 0;
//                while (rs.next()) {
////                    String key = "Name"+ i +": " ;
//                    System.out.print("ProductID: " + rs.getInt("PRODUCTID") + "\t");
//                    System.out.print("Name: " + rs.getString("NAME") + "\t");
//                    System.out.print("ProductNumber: " + rs.getString("PRODUCTNUMBER") + "\t");
//                    System.out.print("ListPrice: " + rs.getDouble("ListPrice") + "\n");
////                    mapValues.put(key, rs.getString("NAME"));
////                System.out.println("PURCHASE_COST: " + rs.getBigDecimal("PURCHASE_COST"));
//                }
//            }
//
//        } catch (SQLException | NullPointerException ex) {
//            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//параметризованный с join    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        String filter = "B%";
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\16696866\\Work\\ReebootSchoolJava\\msAccessDB\\AWSales.accdb")) {
//            System.out.println("Schema: " + conn.getSchema());
            //update на %
//HashMap <String,String> mapValues = null;
//            String sqlQuery = "select ProductID,name,ProductNumber,ListPrice from products where name like 'Mountain%[0-3]%48'";
            String sqlQuery = "SELECT c.name as Category, p.name as Product,p.ProductNumber,p.ListPrice "
                    + "from productSubCategories c "
                    + "join products p on p.productSubCategoryID = c.productSubCategoryID "
                    + "order by c.name,p.name asc;";

            PreparedStatement prep = conn.prepareStatement(sqlQuery);
//            prep.setString(1, filter);
            String txt = "";
            String prevCategory = "";
            try (ResultSet rs = prep.executeQuery()) {
//                rs.next();
//int i = 0;
                while (rs.next()) {
//                    String key = "Name"+ i +": " ;
//                    System.out.println(rs.getString(1) + "\t" + 
//                            rs.getString(2) + "\t" + 
//                            rs.getString(3) + "\t" +
//                            rs.getDouble(4));
                    String category = rs.getString(1);
                    String catText = category.equals(prevCategory) ? ";" : (prevCategory = category);
                    txt += catText 
                            + rs.getString(2) + ";"
                            + rs.getString(3) + ";"
                            + rs.getDouble(4) + "\n";

                }
                System.out.println(txt);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Reports\\txt.csv"))) {
                    writer.write(txt);

                }
            }

        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
