/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ejb;

import javax.ejb.Singleton;

/**
 *
 * @author alex
 */
@Singleton
public class ChatEJB {
    private String history;
    
    public void sendMessage(String message) {
        history = message + "</br>" + history;
        
    }
    public String getHistory() {
        return history;
        
    }
    
}
