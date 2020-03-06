/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my_JSF;

import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author alex
 */
@Named
//@ApplicationScoped
public class TimeBean {
    private Date now = new Date();

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
    
}
