/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my04_consoleanalyticapp;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author alex
 */
public class My04_ConsoleAnalyticApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        LocalDate startDate, finalDate;

        System.out.println("Please enter the StartDate:(dd.MM.yyyy)");
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        System.out.println("Please enter the FinalDate:(dd.MM.yyyy)");
        String str2 = in.nextLine();
        System.out.println("StartDate: " + str1);
        System.out.println("FinalDate: " + str2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        startDate = LocalDate.parse(str1, formatter);
        finalDate = LocalDate.parse(str2, formatter);

        System.out.println("StartDate: " + startDate.toString());
        System.out.println("FinalDate: " + finalDate.toString());

        String dbLink = "jdbc:sqlserver://yand.dyndns.org\\AdventureWorks:1433;databaseName=AdventureWorks";
        try (Connection cn = DriverManager.getConnection(dbLink, "northwind", "northwind")) {

            String sqlQuery = "select top 10 Name, Sum(LineTotal) as Amount "
                    + "from sales.salesOrderDetail ss  "
                    + "inner join Production.product pp on ss.ProductID = pp.ProductID "
                    + "inner join Sales.SalesOrderHeader ssh on ss.SalesOrderID = ssh.SalesOrderID "
                    + "where ssh.OrderDate between ? and ? "
                    + "group by Name "
                    + "order by Sum(LineTotal) desc";

            PreparedStatement ps = cn.prepareStatement(sqlQuery);

            ps.setDate(1, Date.valueOf(startDate));
            ps.setDate(2, Date.valueOf(finalDate));
//            ps.setDate(1, java.sql.Date.valueOf(startDate));
//            ps.setDate(2, java.sql.Date.valueOf(finalDate));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String prodName = rs.getString("Name");
                    Double amount = rs.getDouble("Amount");
                    System.out.print("Name: " + prodName + "\t");
                    System.out.println("Amount: " + Math.round(amount) );
                }

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(My04_ConsoleAnalyticApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

    }
}
