package com.selenium.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    File file=new File("E:\\BooksWagonAssignment\\src\\main\\resources\\Credentials.xlsx");
    public ReadExcelData(){
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream(file);
            this.workbook=new XSSFWorkbook(fileInputStream);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getData(){
        this.sheet=this.workbook.getSheetAt(0);
        Cell cell=this.sheet.getRow(0).getCell(0);
        String data= cell.getStringCellValue();
        return data;
    }
    public int getRowCount(){
        int rowNum=this.workbook.getSheetAt(0).getLastRowNum();
        ++rowNum;
        return rowNum;
    }
}
