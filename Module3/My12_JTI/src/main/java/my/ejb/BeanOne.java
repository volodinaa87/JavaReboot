/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author alex
 */
@Stateless
public class BeanOne {
    
    @Resource(lookup="Hackers_JNDI") //сюда пишем jndi с сервера
    DataSource db;
    public void addData() throws SQLException {
        Connection cn = db.getConnection();
        String sql = "INSERT INTO Hackers (Signature) VALUES ('VOLODIN_AA-BEANONE-1')";
        Statement stat = cn.createStatement();
        stat.executeUpdate(sql);
        
    }
    
}
