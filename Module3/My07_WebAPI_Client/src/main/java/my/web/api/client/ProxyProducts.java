/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

import java.io.Closeable;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alex
 */
public class ProxyProducts{
        
    public List<Product> getProducts(String filter) {

        Client client = ClientBuilder.newClient();
        String url = "http://localhost:8080/My06_AJAX_JAX-RS/resources/api/products" + "?filter=" + filter;
        WebTarget target = client.target(url);
        List<Product> result = target
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Product>>() {
                });
        return result;
    }
}
