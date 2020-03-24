/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api;

import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import my.ejb.ChatEJB;

/**
 *
 * @author alex
 */
@Path("chat")
public class ChatWebAPI {
    
@EJB
ChatEJB chat;

@GET
@Path("/send")
public String sendMessage(@QueryParam("message") String message){
    chat.sendMessage(new Date()+ " :::: " + message);
    return "OK";
}
@GET
@Path("/get") //history
public String getHistory(){
    return chat.getHistory();
}


}
