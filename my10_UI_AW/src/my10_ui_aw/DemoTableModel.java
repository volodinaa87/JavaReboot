/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my10_ui_aw;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class DemoTableModel extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowIndex*10 + columnIndex;
    }
    
    
}
