/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.List;
import my09_ui_db.Repository;

/**
 *
 * @author alex
 */
public class TestRepository {
    public static void main(String[] args) throws SQLException {
        Repository repository = new Repository();
//        repository.addSignature("AVolodin");
        List<String> data = repository.getAllSignatures();
        for (String str : data) {
            System.out.println("String in DB: " + str);
        }
    }
    
}
