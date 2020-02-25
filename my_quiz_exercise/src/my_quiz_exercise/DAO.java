/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_quiz_exercise;

/**
 *
 * @author alex
 * @version 1.0
 * Default Constructor: user,pwd,dbURL - by default usage MSSQL Server
 * Custom Constructor: user,pwd,dbURL - yours credentials to link DB
 * 
 */
public class DAO {

    //default link db credentials

    public DAO() {
//        this.user = user;
//        this.pwd = pwd;
//        this.dbURL = dbURL;
    }
    String user = "northwind";
    String pwd = "northwind";
    String dbURL = "jdbc:sqlserver://yand.dyndns.org:1433;databaseName=AdventureWorks";
    
    public DAO(String user,String pwd,String dbURL) {
        this.user = user;
        this.pwd = pwd;
        this.dbURL = dbURL;
    }
    



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }
    
}
