/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author alex
 */
public class ProxyCalc {

    String base_url = "http://localhost:8080/My06_AJAX_JAX-RS";
Client client;
    public ProxyCalc() {
        client = ClientBuilder.newClient();
    }

    public ProxyCalc(String base_url) {
        this.base_url = base_url;
        client = ClientBuilder.newClient();
    }

    public int plus(int x, int y) {
        String url = base_url + "/resources/api/plus" + "?x=" + x + "&y=" + y;
        WebTarget target = client.target(url);
        int result = target.request().get(Integer.class);
        return result;
    }
    public int minus(int x, int y) {
        String url = base_url + "/resources/api/minus" + "?x=" + x + "&y=" + y;
        WebTarget target = client.target(url);
        int result = target.request().get(Integer.class);
        return result;
    }

}
