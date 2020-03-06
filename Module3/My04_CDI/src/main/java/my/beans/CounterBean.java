/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.beans;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author alex
 */
//@RequestScoped
//@ApplicationScoped
@SessionScoped
public class CounterBean implements Serializable{
    private int counter = 0;
    public int inc() {
        return ++counter;
    }
    
}
