/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author alex
 */
@Stateless
public class BeanZero {
    @EJB
    BeanOne one;
    @EJB
    BeanTwo two;        
    
    public void doIt(){
        try {
            one.addData();
            if(1==1) throw new RuntimeException("Test EJB Error");
            two.addData();
        } catch (SQLException ex) {
            Logger.getLogger(BeanZero.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error detected in Bean");
        }
        
    }
    
}
