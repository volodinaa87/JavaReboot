/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_quiz_exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author alex 
 * excel report builder
 */
public class PriceListGenerator {

    public void priceListGenerate(String path) throws IOException {
        try {
            DataBuilder db = new DataBuilder();
            List<Product> pricelist = db.getFullPriceList();
            Date reportDate = new Date();

            Workbook book = new HSSFWorkbook();
            Sheet sheet = book.createSheet("Price List AdventureWorks");

            DataFormat dateformat = book.createDataFormat();
            DataFormat numericformat = book.createDataFormat();

            CellStyle dateStyle = book.createCellStyle();
            dateStyle.setDataFormat(dateformat.getFormat("dd.mm.yyyy"));

            CellStyle numericStyle = book.createCellStyle();
//            numericStyle.setDataFormat(numericformat.getFormat("######.##"));
//            numericStyle.setDataFormat(numericformat.getFormat("#####,##0.00[$р.-419];\\\\-#####,##0.00[$р.-419]"));
            numericStyle.setDataFormat(numericformat.getFormat("[$$-409] #####,##0.00;[RED]-[$$-409] #####,##0.00"));

            Row priceListHeader = sheet.createRow(0);
            Cell cellPriceListHeader = priceListHeader.createCell(0);
            cellPriceListHeader.setCellValue("Price List Download Date:");

            cellPriceListHeader = priceListHeader.createCell(1);
            cellPriceListHeader.setCellValue(reportDate);
            cellPriceListHeader.setCellStyle(dateStyle);

            int i = 1;
            Row rowHeader = sheet.createRow(3);
            Cell cellHeader = rowHeader.createCell(0);
            cellHeader.setCellValue("ProductCategory");
            cellHeader = rowHeader.createCell(1);
            cellHeader.setCellValue("ProductName");

            cellHeader = rowHeader.createCell(2);
            cellHeader.setCellValue("ProductNumber");

            cellHeader = rowHeader.createCell(3);
            cellHeader.setCellValue("Price");

            String prevCategory = "";
            for (var pl : pricelist) {
                Row row = sheet.createRow(i + 3);
                
                
                Cell cell = row.createCell(0);
//                cell.setCellValue(pl.getProductCategory());
                cell.setCellValue(prevCategory.equalsIgnoreCase(pl.getProductCategory()) == true ? "":pl.getProductCategory());
                
                cell = row.createCell(1);
                cell.setCellValue(pl.getProductName());

                cell = row.createCell(2);
                cell.setCellValue(pl.getProductNumber());

                cell = row.createCell(3);
                cell.setCellValue(pl.getPrice());
                cell.setCellStyle(numericStyle);
                prevCategory = pl.getProductCategory();
                i++;
            }

            for (int j = 0; j < 4; j++) {
                sheet.autoSizeColumn(j);
            }
//            sheet.autoSizeColumn(0);
//            sheet.autoSizeColumn(1);
//            sheet.autoSizeColumn(2);
//            sheet.autoSizeColumn(3);

            try (FileOutputStream stream = new FileOutputStream(path)) {
                book.write(stream);
                book.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PriceListGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
