/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my11_oracledb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class Repository {

    String databaseURL = "jdbc:oracle:thin:@yand.dyndns.org:1521:orcl";
    String user = "HR";
    String pwd = "Pa$$w0rd";

    public Repository() {

    }

    public Repository(String databaseURL, String user, String pwd) {
        this.databaseURL = databaseURL;
        this.user = user;
        this.pwd = pwd;
    }


    public List<FIO> getAllFIO() throws SQLException {
        List<FIO> fios = new ArrayList<>();

        try (Connection cn = DriverManager.getConnection(databaseURL, user, pwd)) {
            String sql = "SELECT LAST_NAME, FIRST_NAME, PHONE_NUMBER from HR.EMPLOYEES where rownum<=10";
            Statement stat = cn.createStatement();
            try (ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    fios.add(new FIO(                            
                            rs.getString("LAST_NAME"),
                            rs.getString("FIRST_NAME"),
                            rs.getString("PHONE_NUMBER")));
                
                }
            }
        }

        return fios;
    }

}
