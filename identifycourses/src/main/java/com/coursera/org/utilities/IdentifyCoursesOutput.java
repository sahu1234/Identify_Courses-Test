package com.coursera.org.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

 

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class IdentifyCoursesOutput {

public static void main(String[] args) {
        
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        //Create Excel Sheet
        XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
        
        //Creating the Data
        Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
        dataSet.put("1", new Object[] {"ID", "Operation", "Output"});
        dataSet.put("2", new Object[] {"1", "Select Language", "English"});
        dataSet.put("3", new Object[] {"2", "Select Level", "beginner"});
        dataSet.put("4", new Object[] {"3", "Select First Course", "Web Design for Everybody: Basics of Web Development & Coding"});
        dataSet.put("5", new Object[] {"4", "Rating of First Course", "4.7"});
        dataSet.put("6", new Object[] {"5", "Duration of First Course", "Approximately 6 months to complete"});
        dataSet.put("7", new Object[] {"7", "Select Second Course", "Introduction to Web Development"});
        dataSet.put("8", new Object[] {"7", "Rating of Second Course", "4.7"});
        dataSet.put("9", new Object[] {"8", "Duration Of Second Course", "Approx. 22 hours to complete"});
        
        
        
        //Iterate over the Data
        Set<String> set = dataSet.keySet();
        int rownum = 0;
        
        for (String key : set) {
            
            Row row = samplesheet.createRow(rownum++);
            
            Object[] data = dataSet.get(key);
            
            int cellNum = 0;
            
            for (Object value : data) {
                
                Cell cell = row.createCell(cellNum++);
                
                if (value instanceof String)
                    cell.setCellValue((String)value);
                else if(value instanceof Integer)
                   cell.setCellValue((Integer)value);
                
            }
            
        }
        
        //Write Down file on HadDisk
        try {
            FileOutputStream writeFile = new FileOutputStream("IdentifyCourses.xlsx");
            // For MacUsers /users/customDir Name/FileName
            //For Windows C:/Test/Sample/..../Filename
            // C://Test//Sample//....//filename
            
            
            workbook.write(writeFile);
            
            writeFile.close();
            System.out.println("Sample Excel file is being created Successfully");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

 

    }

 

}

