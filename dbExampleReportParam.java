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
public class dbExampleReportParam {

//    public static void main(String[] args) throws SQLException {
//        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\AdventureWorks:1433;databaseName=AdventureWorks";
//        try ( Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {
////            System.out.println(cn.getClientInfo());
//
////            String sqlQuery = "select pp.ProductPhotoID, pp.LargePhotoFileName from Production.ProductPhoto as pp";
//            String sqlQuery = "select name, ListPrice from production.Product "
//                    + "where name like ? "
//                    + "order by ListPrice, name desc";
//            PreparedStatement ps = cn.prepareStatement(sqlQuery);
//            String filter = "'B%'";
//            ps.setString(1, filter);
////            ps.executeQuery();
//            try ( ResultSet rs = ps.executeQuery()) {
////                rs.next();
//                while (rs.next()) {
//                    String nameField = rs.getString("Name");
//                    String listPrice = rs.getString("ListPrice");
////                    System.out.printf("nameField=%s \t\t\t listPrice=%s \n ", nameField, listPrice);
//                    System.out.printf(" " + nameField + " " + listPrice);
////System.out.println("ProdID: " + prodID + " \tName: " + name + " \tProductNumber: " + prodNum);
//
//                }
//            }
//        }
//    }
    //delete dublicate
//    public static void main(String[] args) throws SQLException,{
//        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\SB:1433;databaseName=SB";
//        try ( Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {
////            System.out.println(cn.getClientInfo());
//
////            String sqlQuery = "select pp.ProductPhotoID, pp.LargePhotoFileName from Production.ProductPhoto as pp";
////            String sqlQuery =  "INSERT INTO Hackers(Signature) values(?)";
//            String sqlQuery =  "WITH CTE AS ( " +
//"	SELECT Signature, ROW_NUMBER() OVER(PARTITION BY Signature ORDER BY Signature) rnk " +
//"	FROM Hackers where Signature  = ?) " +
//"DELETE FROM CTE " +
//"WHERE 1<rnk;";
////pstmt.setInt(1, 777);
//            PreparedStatement pstmt = cn.prepareStatement(sqlQuery);
//pstmt.setString(1, "Александр Володин");
////            pstmt = cn.prepareStatement(sqlQuery);
//pstmt.executeUpdate();
//                }
//            }
    //get Metadata in DB
    public static void main(String[] args) throws SQLException {
        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\AdventureWorks:1433;databaseName=AdventureWorks";
        try ( Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {
            DatabaseMetaData metadata = cn.getMetaData();
//            String schemaName

            ResultSet rsMeta = metadata.getTables(null, null, null, new String[]{"TABLE"});
            while (rsMeta.next()) {
                System.out.println(rsMeta.getString("TABLE_NAME"));

            }
            rsMeta.close();

            rsMeta = metadata.getColumns(null, "Production", "Product", null);
            while (rsMeta.next()) {
                System.out.println(rsMeta.getString("COLUMN_NAME") + "|" + rsMeta.getString("TYPE_NAME"));
                
            }
        }
    }

}
