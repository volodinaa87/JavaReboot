/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author alex
 */
public class ProxyCalc implements Closeable {

//    String base_url = "http://localhost:8080/My06_AJAX_JAX-RS";
    String base_url;
    Client client;

    public ProxyCalc() {
        
//        try(FileInputStream in = new FileInputStream("//media/alex/FileStorage/Development/Projects/CloudRebootBackUp/Module3/My07_WebAPI_Client/src/main/java/conf.properties")){
        try(InputStream in = Client.class.getResourceAsStream("/conf.properties")){
        client = ClientBuilder.newClient();
            Properties props = new Properties();
            props.load(in);
            base_url = props.getProperty("base_url_calc");
        } catch (IOException ex) {
            Logger.getLogger(ProxyCalc.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("JAX-RS-Client: not created!");
        }
        
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

    @Override
    public void close() throws IOException {
        client.close();
    }

}
