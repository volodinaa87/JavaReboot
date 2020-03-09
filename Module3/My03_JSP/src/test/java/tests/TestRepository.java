/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import aw.data.DAO;
import aw.data.DataBuilder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class TestRepository {
    public static void main(String[] args) throws SQLException {
        try {
            DAO db = new DAO();
            DataBuilder dbo = new DataBuilder();
            
            System.out.println("Status connection: " + dbo.getFullPriceList().size());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
