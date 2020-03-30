/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author alex
 */
@Stateless
public class CalcEJB {

    public int plus(int x, int y) {
        return x + y;

    }

    public int minus(int x, int y) {
        return x - y;

    }
}