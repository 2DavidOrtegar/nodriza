package app.support.getinfotest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GetInfoTest {


    // Cambiar la ruta para indicar en que lugar obtendras
    // los escenarios de las features en especifico.
    private static String dirCarp = "ruta de la feature";
    private static String filename = "ruta con el excel que se desea cargar";
    private static File carpetSoap = new File(dirCarp);

    private static BufferedReader in;
    private static ArrayList<String> listScenario = new ArrayList<>();;

    // Se le entrega la ruta de la carpeta
    // Crea una lista de contenidos (archivos)
    // los ordena por orden alfabetico
    // Crea un archivo de lectura por cada
    // archivo que haya econtrado.
    private static void getTest() throws IOException {
        List<File> list = Arrays.asList(carpetSoap.listFiles());
        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println("No se encuentran archivos en el destino");
        } else {
            for (int i = 0; i < list.size(); i++) {
                in = new BufferedReader(new FileReader(list.get(i).getPath()));
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.contains("Scenario Outline: ")) {
                        line = line.replace("Scenario Outline: ","");
                        getScenario(line);
                    }
                }
                in.close();
            }
        }
    }

    //Modifica el nombre del scenario y lo agrega a una lista
    private static void getScenario(String scenario) throws IOException {
        try {
            scenario.substring(18);
            listScenario.add(scenario);
        }catch (Exception e){
            e.getCause();
            System.out.println("Fallo getScenario");
        }


    }

    // Se crea archivo excel en la ruta de "data/"
    // el archivo excel se llama "Scenarios".
    // El archivo excel escribe cada scenario que encuentre
    // por cada celda.
     private static void Excel() throws IOException {

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(" Scenarios ");

        //Create row object
        XSSFRow row = spreadsheet.createRow(0);
        Cell cellHeader = row.createCell(0);
        cellHeader.setCellValue("Num Test");
        Cell cellHeader2 = row.createCell(1);
        cellHeader2.setCellValue("Name Scenarios");


        int rowNum = 1;
        for (int i = 0; i < listScenario.size(); i++) {
            Row row1 = spreadsheet.createRow(rowNum++);
            row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue(listScenario.get(i));
        }


        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(
                new File(filename));

        workbook.write(out);
        out.close();
    }

    public static void main(String[] args) {
        try {
            getTest();
            Excel();
        } catch (Exception e) {
            System.out.println("No paso nadi");
            e.getCause();
        }
    }
}
