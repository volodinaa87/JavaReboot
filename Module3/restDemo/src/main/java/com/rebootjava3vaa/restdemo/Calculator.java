/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebootjava3vaa.restdemo;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
//import javax.xml.ws.handler.Handler;
//import javax.xml.ws.handler.LogicalHandler;

/**
 *
 * @author alex
 */
@WebService(serviceName = "Calculator")
@HandlerChain(file = "Calculator_handler.xml")
public class Calculator implements Handler<MessageContext>{

    /**
     *
     * @param param
     * @return
     */
    @WebMethod(action = "sample_operation")
    public String operation(@WebParam(name = "param_name") String param) {
        // implement the web service operation here
        return param;
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    @WebMethod(action = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j;
        return k;
    }

    /**
     * Web service operation
     * @param i
     * @param j
     * @return
     */
    
    @WebMethod(operationName = "divide")
    public int divide(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        //TODO write your implementation code here:
        int k = i / j;
        return k;
    }

    @Override
    public boolean handleMessage(MessageContext c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean handleFault(MessageContext c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close(MessageContext mc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
