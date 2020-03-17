/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.web.api.client;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class ProductsTableModel extends AbstractTableModel{
    List<Product> products;
    public ProductsTableModel(List<Product> products){
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return products.get(rowIndex).getProductName();
            case 1:  return products.get(rowIndex).getPrice();
        }
        return "Unknown";
    }
}
