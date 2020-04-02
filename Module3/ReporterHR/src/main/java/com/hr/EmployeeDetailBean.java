/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alex
 */
@Named
@RequestScoped
public class EmployeeDetailBean {

    @Inject
    DataLoader dataLoader;

    private List<EmployeeDetail> employees;
    private String depFilter = "";
    private String lastnameFilter = "";
    private String firstnameFilter = "";
    private String jobtitleFilter = "";
    private boolean ckbFilter;

    public List<EmployeeDetail> getEmployees() {

        try {
//System.out.println(dataLoader.getDetailedEmployees().size());
            return dataLoader.getDetailedEmployees(depFilter,lastnameFilter,firstnameFilter,jobtitleFilter,ckbFilter);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailBean.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("SQL Data Get Error");
        }
        return null;
    }

    public void setEmployees(List<EmployeeDetail> employees) {
        this.employees = employees;
    }

    public String getDepFilter() {
        return depFilter;
    }

    public void setDepFilter(String depFilter) {
        this.depFilter = depFilter;
    }

    public String getLastnameFilter() {
        return lastnameFilter;
    }

    public void setLastnameFilter(String lastnameFilter) {
        this.lastnameFilter = lastnameFilter;
    }

    public String getFirstnameFilter() {
        return firstnameFilter;
    }

    public void setFirstnameFilter(String firstnameFilter) {
        this.firstnameFilter = firstnameFilter;
    }

    public String getJobtitleFilter() {
        return jobtitleFilter;
    }

    public void setJobtitleFilter(String jobtitleFilter) {
        this.jobtitleFilter = jobtitleFilter;
    }

    public boolean isCkbFilter() {
        return ckbFilter;
    }

    public void setCkbFilter(boolean ckbFilter) {
        this.ckbFilter = ckbFilter;
    }

}
