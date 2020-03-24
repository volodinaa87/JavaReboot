/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import my.ejb.SecondLevelEJB;

/**
 *
 * @author alex
 */
@Path("api")
public class HelloWebAPI {
    
    
    @EJB
    SecondLevelEJB second;
    
    @GET
    @Path("/hello")
    public String hello() throws InterruptedException{
        Thread.sleep(2000);
        return second.saySmth();
    }
    
}
