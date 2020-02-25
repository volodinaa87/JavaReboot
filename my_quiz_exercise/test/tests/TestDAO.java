/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import my_quiz_exercise.DAO;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class TestDAO {

    public static void main(String[] args) {
//        boolean tryConnect = tryConnect();
        DAO db = new DAO();
        System.out.println("Status connection: " + tryConnect(db));

    }

    public static boolean tryConnect(DAO db) {
        boolean rsConn = false;
        try (Connection cn = DriverManager.getConnection(db.getDbURL(), db.getUser(), db.getPwd());) {
//            Statement stat =  cn.createStatement();
            DatabaseMetaData metadata = cn.getMetaData();
//            System.out.println(metadata);
            rsConn = !metadata.getConnection().toString().equals("");
//            System.out.println(metadata.getConnection().toString().equals("") ? "Connection failure." : "Connection successed."); 
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, "Failure connection", ex.getMessage());
        }
        return rsConn;

    }

}
