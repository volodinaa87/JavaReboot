/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import my09_ui_db.ReportGenerator;

/**
 *
 * @author alex
 */
public class TestReportGenerator {
    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException {
    ReportGenerator rg =  new ReportGenerator();
        rg.create(new Date(102,0,1), new Date(102,1,1), "/media/alex/FileStorage/Development/Projects/CloudRebootBackUp/ReportGeneratorFiles/excelReport.xls");
    }
}
