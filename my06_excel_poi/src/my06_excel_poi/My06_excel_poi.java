/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my06_excel_poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author alex
 */
public class My06_excel_poi {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (Workbook book = new HSSFWorkbook()) {
            Sheet  sh = book.createSheet("HelloSheet");
            Row row = sh.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("HelloExcelWorld");
            book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelExample.xls"));
      
            
            Sheet sh2 = book.cloneSheet(0);
            for (int i = 3; i < 100; i++) {
            Row row2 = sh2.createRow(i+1);
                
            Cell cell2 = row2.createCell(i);
            cell2.setCellValue(i*i);
            book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelExample.xls"));
            }
            
            Sheet sh3 = book.createSheet("ТаблицаКвадратов");
            for (int i = 0; i < 9; i++) {
                Row r3 = sh3.createRow(i);
                for (int j = 0; j < 9; j++) {
                    Cell cell3 = r3.createCell(j);
                    cell3.setCellValue(Math.pow((i*10+j),2));
                    //book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelExample.xls"));
                }
                book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelExample.xls"));
            }

            
            
            book.close();
        
        }
    }
    
}
