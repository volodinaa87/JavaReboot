/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.SQLException;
import java.util.List;
import my11_oracledb.FIO;
import my11_oracledb.Repository;

/**
 *
 * @author alex
 */
public class TestRepository {
    public static void main(String[] args) throws SQLException {
        Repository repository = new Repository();
        List<FIO> phones = repository.getAllFIO();
        System.out.println(phones.size());
//        phones = repository.getProducts("A");
//        System.out.println(phones.size());
    }
    
}
