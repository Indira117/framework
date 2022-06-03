package com.hrms.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReading {
    static Workbook book;
    static Sheet sheet;

    /**
     *
     * @param filePath
     */
    public static void openExcel(String filePath){

        try {
            FileInputStream fis=new FileInputStream(filePath);
            book =new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sheetName
     */
    public static void getSheet(String sheetName){
        sheet= book.getSheet(sheetName);
    }

    /**
     *
     * @return
     */
    public static int getRowCount(){

        return     sheet.getPhysicalNumberOfRows();
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public  static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex,int cellIndex){
        return  sheet.getRow(rowIndex).getCell(cellIndex).toString();
    }


    public static List<Map<String,String>> excelIntoListMap(String filePath, String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String,String>> listData=new ArrayList();
        for (int i = 1; i < getRowCount(); i++) {   //i=row
            //creating map for every single row
            Map<String,String> map=new LinkedHashMap<>();
            //looping through all cell in the row
            for (int j = 0; j <getColsCount(i) ; j++) {//j=column

                //storing values from each cell into a map
                map.put(getCellData(0,j),getCellData(i,j));
            }
            //adding every map to list
            listData.add(map);
        }
        return listData;
    }
}
