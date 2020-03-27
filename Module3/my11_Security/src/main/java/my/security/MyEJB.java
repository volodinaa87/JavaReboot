/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.security;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author alex
 */
@DeclareRoles({"role1","role2"})
@Stateless
public class MyEJB {
    
    @RolesAllowed("role1")
    public String secret(){
        return "Secret";
    }
    
}
