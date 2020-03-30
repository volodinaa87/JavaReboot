/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webAPI;

import com.ejb.CalcEJB;
import com.ejb.DataWriterEJB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author alex
 */
@Stateless
@Path("webCalc")
public class CalcWebAPI {

    private int result;
    @EJB
    CalcEJB calculator;

    @EJB
    DataWriterEJB db;

    @GET
    @Path("/plus")
    public int plus(@QueryParam("x") int x, @QueryParam("y") int y) {
        try {
            result = calculator.plus(x, y);
            db.addData(x, y, "+", result);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CalcWebAPI.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Somthing went wrong (Operation: plus). Data Not Inserted");
        }
    }

    @GET
    @Path("/minus")
    public int minus(@QueryParam("x") int x, @QueryParam("y") int y) {
        try {
            result = calculator.minus(x, y);
            db.addData(x, y, "-", result);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CalcWebAPI.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Somthing went wrong (Operation: minus). Data Not Inserted");
        }
    }

}