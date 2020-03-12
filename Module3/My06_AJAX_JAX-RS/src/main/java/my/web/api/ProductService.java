/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api;

import aw.data.DataBuilder;
import aw.data.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author alex
 */

@Path("api")
public class ProductService {

@Inject
DataBuilder db;

@GET
@Path("/products")
public List<Product> getProducts(@QueryParam("filter") String filter) {
    try {
        return db.getFullPriceList(filter);
    } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

}
