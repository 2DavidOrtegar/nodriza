package app.support.utils;

import app.support.loadproperties.LoadProperty;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Excel {
    private String pathFile = LoadProperty.PATHS.getProperty("absolutefilepath") + "excel\\";
    public void writeExcel(String fileName, String nameSheet, Object[][] datatypes) {
        /*
        Object[][] datatypes = {
                    {"Datatype", "Type", "Size(in bytes)"},
                    {"int", "Primitive", 2},
                    {"float", "Primitive", 4},
                    {"double", "Primitive", 8},
                    {"char", "Primitive", 1},
                    {"String", "Non-Primitive", "No fixed size"}
            };
         */
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(nameSheet);

        System.out.println(pathFile);
        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(pathFile + fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    public ArrayList<ArrayList<String>> readExcel(String fileName) {

        ArrayList<ArrayList<String>> data = new ArrayList<>();

        try {

            FileInputStream excelFile = new FileInputStream(new File(pathFile + fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                ArrayList<String> d = new ArrayList<>();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        //System.out.print(currentCell.getStringCellValue());
                        d.add(currentCell.getStringCellValue());
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        //System.out.print(currentCell.getNumericCellValue());
                        d.add(currentCell.getStringCellValue());
                    }

                }

                data.add(d);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
