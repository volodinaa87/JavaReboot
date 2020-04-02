/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author alex сделать серез jndi меньше писать пример в DataWriterEJB и
 * DataBuilder
 */
public class DataLoader {

    @Resource(lookup = "HR_DB")
    DataSource hrdb;

    public List<EmployeeDetail> getDetailedEmployees(String depFilter, String lastnameFilter, String firstnameFilter, String jobtitleFilter, boolean ckbFilter) throws SQLException {
        List<EmployeeDetail> results = new ArrayList<>();
        try (Connection conn = hrdb.getConnection()) {
            String sqlQuery = "select employee_id, job_id, "
                    + "CASE WHEN manager_id is null THEN 0 ELSE manager_id END as manager_id, "
                    + "department_id, department_name, job_title, first_name, last_name, salary, "
                    + "CASE WHEN commission_pct is null THEN 0 ELSE commission_pct END as commission_pct, "
                    + "city, state_province, country_name "
                    + "FROM HR.EMP_DETAILS_VIEW "
                    + "where department_name like ? "
                    + "or last_name like ? "
                    + "or first_name like ? "
                    + "or job_title like ? ";

            PreparedStatement prep = conn.prepareStatement(sqlQuery);
            if(ckbFilter == true){
                
            prep.setString(1, "%");
            prep.setString(2, "%");
            prep.setString(3, "%");
            prep.setString(4, "%");
            }
            else {
            switch (depFilter) {
                case "":
                    prep.setString(1, "");
                    break;
                case "%":
                    prep.setString(1, "%");
                    break;
                default:
                    prep.setString(1, depFilter + "%");
                    break;
            }

            switch (lastnameFilter) {
                case "":
                    prep.setString(2, "");
                    break;
                case "%":
                    prep.setString(2, "%");
                    break;
                default:
                    prep.setString(2, lastnameFilter + "%");
                    break;
            }
            switch (firstnameFilter) {
                case "":
                    prep.setString(3, "");
                    break;
                case "%":
                    prep.setString(3, "%");
                    break;
                default:
                    prep.setString(3, firstnameFilter + "%");
                    break;
            }
            switch (jobtitleFilter) {
                case "":
                    prep.setString(4, "");
                    break;
                case "%":
                    prep.setString(4, "%");
                    break;
                default:
                    prep.setString(4, jobtitleFilter + "%");
                    break;
            }
            }

            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    EmployeeDetail ed = new EmployeeDetail(
//                            rs.getInt("employee_id"),
//                            rs.getInt("job_id"),
//                            rs.getInt("manager_id"),
//                            rs.getInt("department_id"),
//                            rs.getString("department_name"),
//                            rs.getString("job_title"),
//                            rs.getString("first_name"),
//                            rs.getString("last_name"),
//                            rs.getInt("salary"),
//                            rs.getDouble("commission_pct"),
//                            rs.getString("city"),
//                            rs.getString("state_province"),
//                            rs.getString("country_name")
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getDouble(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13)
                    );
                    results.add(ed);
                }

            } catch (SQLException ex) {
                Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;

    }

}
