/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my09_ui_db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class Repository {

    String databaseURL = "jdbc:sqlserver://yand.dyndns.org\\SB:1433;databaseName=SB";
    String user = "northwind";
    String pwd = "northwind";

    public Repository() {

    }

    public Repository(String databaseURL, String user, String pwd) {
        this.databaseURL = databaseURL;
        this.user = user;
        this.pwd = pwd;
    }

    public void addSignature(String hacker) throws SQLException {

        try (Connection cn = DriverManager.getConnection(databaseURL, user, pwd)) {
            String sql = "INSERT INTO Hackers(Signature)"
                    + "VALUES (?)";

            PreparedStatement prep = cn.prepareStatement(sql);
            prep.setString(1, hacker);
            prep.executeUpdate();

        }

    }

    public List<String> getAllSignatures() throws SQLException {
        List<String> results = new ArrayList<>();
        try (Connection cn = DriverManager.getConnection(databaseURL, user, pwd)) {
            String sql = "select Signature from Hackers order by ID desc";
            PreparedStatement prep = cn.prepareStatement(sql);
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    results.add(rs.getString("Signature"));
                }
            }
        }
        return results;

    }

}
