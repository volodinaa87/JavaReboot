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
import java.text.DateFormat;
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
//        java.sql.Date startDate = new java.sql.Date (100,12,12);
//        java.sql.Date finalDate = new java.sql.Date (110,12,12);
        Date startDate = new Date (100,12,12);
        Date finalDate = new Date (110,12,12);
        RepositoryAW repository = new RepositoryAW();
        List<ProductStatistics> products = repository.getBestSoldProductsInDateRange(startDate, finalDate);
        
        
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("ReportFromDB_MSSQL");
        
        DataFormat format = book.createDataFormat();
        DataFormat numericformat = book.createDataFormat();
        
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        
        CellStyle numericStyle = book.createCellStyle();
        numericStyle.setDataFormat(numericformat.getFormat("#######.##"));
        
        
        Row reportHeader = sheet.createRow(0);
        Cell cellReportHeader = reportHeader.createCell(0);
        cellReportHeader.setCellValue("Start Date");
        cellReportHeader = reportHeader.createCell(1);
        cellReportHeader.setCellValue(startDate);
        cellReportHeader.setCellStyle(dateStyle);
        
        
        reportHeader = sheet.createRow(1);
        cellReportHeader = reportHeader.createCell(0);
        cellReportHeader.setCellValue("Final Date");
        cellReportHeader = reportHeader.createCell(1);
        cellReportHeader.setCellValue(finalDate);
        cellReportHeader.setCellStyle(dateStyle);
        
            int i = 1;
            Row rowHeader = sheet.createRow(3);
            Cell cellHeader = rowHeader.createCell(0);
            cellHeader.setCellValue("Product");
            cellHeader = rowHeader.createCell(1);
            cellHeader.setCellValue("Amount");
            
        for (var ps : products) {
            Row row = sheet.createRow(i+3);
            Cell cell = row.createCell(0);
            cell.setCellValue(ps.getProductName());
            cell = row.createCell(1);
            cell.setCellValue(ps.getSalesAmount());
            cell.setCellStyle(numericStyle);
            i++;
        }
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
 book.write(new FileOutputStream("/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/excelPoi/excelReport.xls"));
    }
    
}
