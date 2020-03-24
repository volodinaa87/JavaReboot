/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ejb;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

//@Singleton  //equivalent ApplicationScope
//@Stateful //like sessionScope, занимает память
@Stateless //не запоминает, использует пул
public class HelloEJB {
    public String SayHello(){
        return "Say }{eLlo EJB!!!";
    }
}
