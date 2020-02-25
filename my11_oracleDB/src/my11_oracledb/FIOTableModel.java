/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my11_oracledb;
/**
 *
 * @author alex
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class FIOTableModel extends AbstractTableModel{
    List<FIO> fios;

    public FIOTableModel(List<FIO> fios) {
        this.fios = fios;
    }


    @Override
    public int getRowCount() {
        return fios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return fios.get(rowIndex).getLastName();
            case 1: return fios.get(rowIndex).getFirstName();
            case 2: return fios.get(rowIndex).getPhone();
        }
        return "Unknown";
        
    }

    public String getColumnName(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return "Фамилия";
            case 1: return "Имя";
            case 2: return "Номер телефона";
        }
        return "Unknown";
    }
    
    
}
