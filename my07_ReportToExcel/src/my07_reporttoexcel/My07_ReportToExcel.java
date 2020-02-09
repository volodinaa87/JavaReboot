/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my07_reporttoexcel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import my05_middle_tier.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author alex
 */
public class My07_ReportToExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        // TODO code application logic here
        java.sql.Date startDate = new java.sql.Date (100,12,12);
        java.sql.Date finalDate = new java.sql.Date (110,12,12);
        RepositoryAW repository = new RepositoryAW();
        List<ProductStatistics> products = repository.getBestSoldProductsInDateRange(startDate, finalDate);
        
        
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("ReportFromDB_MSSQL");
            int i = 1;
        for (var ps : products) {
            Row row = sheet.createRow(i++);
            Cell cell = row.createCell(0);
            cell.setCellValue(ps.getProductName());
            cell = row.createCell(1);
            cell.setCellValue(ps.getSalesAmount());
 book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelReport.xls"));
        }
        
    }
    
}
