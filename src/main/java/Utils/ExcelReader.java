package Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public static int totalRow;

   /* public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws  IOException {

        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        workbook.close();
        return readSheet(sheet);
    }*/

    private String filePath;



    public List<Map<String, String>> getData(String filePath,String sheetName) throws IOException, InvalidFormatException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
      //  Workbook workbook = WorkbookFactory.create(fileInputStream);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in " + filePath);
        }

        Row headerRow = sheet.getRow(0);
        int columnCount = headerRow.getPhysicalNumberOfCells();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < columnCount; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell cell = row.getCell(j);
                String header = headerCell.getStringCellValue();
                String value = (cell != null) ? cell.toString() : "";
                rowData.put(header, value);
            }
            data.add(rowData);
        }

        workbook.close();
        fileInputStream.close();
        return data;
    }

}
