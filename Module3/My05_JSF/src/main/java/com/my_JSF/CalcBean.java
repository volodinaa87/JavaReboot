/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my_JSF;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author alex
 */
@Named
//@SessionScoped
@RequestScoped
public class CalcBean implements Serializable{

    private static final Logger LOG = Logger.getLogger(CalcBean.class.getName());
    
    private int x,y,z;

    public void plus(){
        z = x+y;
    }
    public void minus(){
        z = x-y;
    }
    
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    
}
