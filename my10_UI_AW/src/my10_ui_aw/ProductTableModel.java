/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my10_ui_aw;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class ProductTableModel extends AbstractTableModel{
    List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return products.get(rowIndex).getId();
            case 1: return products.get(rowIndex).getProductName();
            case 2: return products.get(rowIndex).getProductNumber();
            case 3: return products.get(rowIndex).getPrice();
        }
        return "Unknown";
        
    }
    
    
}
