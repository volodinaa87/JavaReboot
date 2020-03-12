/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author alex
 */
@Path("api")
public class CalcService {
    
    @GET
    @Path("/plus")
    public int plus(@QueryParam("x") int x, @QueryParam("y") int y){
        return 10*(x+y);
    }
    @GET
    @Path("/minus")
    public int minus(@QueryParam("x") int x, @QueryParam("y") int y){
        return x-y;
    }
    
}
