/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.beans;

import javax.inject.Inject;

/**
 *
 * @author alex
 */
public class HelloBean {
    @Inject
    DummyBean dummy;
    
    private String greeting  = "Hello, I am CDI Bean";

    public String getGreeting() {
        return greeting + " O_0 " + dummy.foo();
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
}
