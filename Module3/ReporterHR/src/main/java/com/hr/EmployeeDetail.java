/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr;

/**
 *
 * @author alex
 */
public class EmployeeDetail {

    private int employeeId;
    private String jobId;
    private int managerId;
    private int departmentId;
    private String departmentName;
    private String jobTitle;
    private String firstName;
    private String lastName;
    private int salary;
    private double commissionPercent;
    private String city;
    private String state;
    private String country;

    public EmployeeDetail(int employeeId, String jobId, int managerId, int departmentId, 
                            String departmentName, String jobTitle, String firstName,
                            String lastName, int salary, double commissionPercent, String city, String state, String country) {
        this.employeeId = employeeId;
        this.jobId = jobId;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.jobTitle = jobTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.commissionPercent = commissionPercent;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    

}

//select employee_id, job_id,
//CASE WHEN manager_id is null THEN 0 ELSE manager_id END as manager_id,
//department_id, department_name, job_title, first_name, last_name, salary,
//CASE WHEN commission_pct is null THEN 0 ELSE commission_pct END as commission_pct,
//city, state_province, country_name
//FROM HR.EMP_DETAILS_VIEW;
