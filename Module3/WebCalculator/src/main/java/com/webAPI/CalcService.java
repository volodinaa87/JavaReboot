/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author alex
 * using servlets from com.servlets
 */
@Path("api")
public class CalcService {
//    @Inject
//    @
    
    @GET
    @Path("/plus")
    public int plus(@QueryParam("x") int x, @QueryParam("y") int y){
        return (x+y);
    }
    @GET
    @Path("/minus")
    public int minus(@QueryParam("x") int x, @QueryParam("y") int y){
        return x-y;
    }
    
}
