package com.qa.utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;

public class ExcelOperations {
    String filePath;
    Sheet sheet;


    public ExcelOperations(String  sheetName){
        filePath = "src/test/resources/TestData/TestDataDetails.xlsx";
        File testDataFile = new File(filePath);
        Workbook workbook = null;
        try {
            workbook =  WorkbookFactory.create(testDataFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /**
         * get the sheetname
         */
        sheet =  workbook.getSheet(sheetName);
    }

    public HashMap<String, String> getTestDataMap(int rowNum) throws Exception{

        /**
         * Assign a map to get a data in Key , value pair
         */
        HashMap<String ,String> readData = new HashMap<>();

        /** iterate the i with 0 so that it will get the keys(Header of columns)
         *  sheeName.getRow(0).getLastCellNum()   --> it will help to get the last column
         *
         */

        for (int i=0;i<sheet.getRow(0).getLastCellNum();i++){

            /**
             *  //convert the values to string format even thouth the values provided are in another data type.
             */
            sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            readData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(rowNum).getCell(i).toString());

        }

        return readData;
    }

    public int getRowCount(){
        return sheet.getLastRowNum();
    }

    public int getColumnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

}
