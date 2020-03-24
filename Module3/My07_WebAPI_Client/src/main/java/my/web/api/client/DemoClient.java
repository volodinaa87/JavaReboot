/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

import java.io.IOException;

/**
 *
 * @author alex
 */
public class DemoClient {
//    public static void main1(String[] args) {
//        Client client = ClientBuilder.newClient();
//        String url = "http://localhost:8080/My06_AJAX_JAX-RS/resources/api/plus" + "?x=2&y=3";
//        WebTarget target = client.target(url);
//        String result = target.request().get(String.class);
//        System.out.println(result);
//    }

//    public static void main2(String[] args) {
//        Client client = ClientBuilder.newClient();
//        String url = "http://localhost:8080/My06_AJAX_JAX-RS/resources/api/products" + "?filter=a";
//        WebTarget target = client.target(url);
//        List <Product> products = new ArrayList<>();
//        String result = target.request().get(String.class);
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        Client client = ClientBuilder.newClient();
//        String url = "http://localhost:8080/My06_AJAX_JAX-RS/resources/api/products" + "?filter=";
//        WebTarget target = client.target(url);
//        List<Product> result = target
//                .request(MediaType.APPLICATION_JSON)
//                .get(new GenericType<List<Product>>(){});
//
////        for (Product product : result) {
////            System.out.println(product.toString());
////        }
//        
//        System.out.println("Rows quantity: " + result.size());
//
//    }
    public static void main(String[] args) throws IOException {
        try(ProxyCalc calc = new ProxyCalc();){
        System.out.println("Plus: " + calc.plus(3, 4));
        System.out.println("Minus: " + calc.minus(3, 4));
        
        ProxyProducts proxyProducts = new ProxyProducts();
        System.out.println("Size by Proxy Class ProxyProducts: " + proxyProducts.getProducts("m").size());
    }

}}
