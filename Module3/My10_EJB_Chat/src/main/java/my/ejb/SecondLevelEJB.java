/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ejb;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author alex
 */
@Stateless
public class SecondLevelEJB {
    
    @EJB
    HelloEJB hello;
    
    public String saySmth(){
        return hello.SayHello() + " " + (new Date().toString());
    }
    
    
}
