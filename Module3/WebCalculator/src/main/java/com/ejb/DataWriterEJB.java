/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DataWriterEJB {

    @Resource(lookup = "SB_DB")
    DataSource db;

    public void addData(int x, int y, String operation, int result) throws SQLException {
        Connection cn = db.getConnection();
        String sql = "INSERT INTO Hackers (Signature) VALUES (?)";
        StringBuilder strBld = new StringBuilder();
        StringBuilder valueStr = strBld
                .append(x)
                .append(operation)
                .append(y)
                .append("=")
                .append(result)
                .append("(Volodin_AA)");
//String valueStr = x + operation + y + "=" + result + "(Volodin_AA)"; 
//        System.out.println(valueStr);
        PreparedStatement stat = cn.prepareStatement(sql);
        stat.setString(1, valueStr.toString());
        stat.execute();
    }

}
