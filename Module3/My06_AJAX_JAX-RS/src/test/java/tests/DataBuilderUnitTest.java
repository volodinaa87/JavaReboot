/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import aw.data.DataBuilder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class DataBuilderUnitTest {
    
    public DataBuilderUnitTest() {
    }
    
    @Test
    public void testGetFullPriceListFilterEmpty() throws SQLException, ClassNotFoundException{
        try {
            DataBuilder repo = new DataBuilder();
            assertEquals("BadData", 295, repo.getFullPriceList("").size());
//            assertEquals("BadData", 296, repo.getFullPriceList("").size());
//            assertEquals("BadData", 2, repo.getFullPriceList("a").size());
//            System.out.println(repo.getFullPriceList("").size());
//            System.out.println(repo.getFullPriceList("a").size());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DataBuilderUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testGetFullPriceListFilterA() throws SQLException, ClassNotFoundException{
        try {
            DataBuilder repo = new DataBuilder();
            assertEquals("BadData", 2, repo.getFullPriceList("a").size());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DataBuilderUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
