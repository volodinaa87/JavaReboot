/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my_JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author alex
 */
@Named
@SessionScoped
public class DataBean implements Serializable{
    private List<String> data;

    public List<String> getData() {
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("Data_"+ i);
        }
        
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
    
}
