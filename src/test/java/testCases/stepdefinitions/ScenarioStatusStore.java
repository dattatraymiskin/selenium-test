package testCases.stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ScenarioStatusStore {
    private static Workbook workbook;
    private Sheet sheet;
    private List<Map<String, String>> stepDetails;
    private static Map<String, String> scenarioStatuses = new HashMap<>();
       @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("########################################################################################################");
        System.out.println("Executing Before Scenario");
        System.out.println( scenario.getName());
    }
    @After
    public void afterScenario(Scenario scenario) throws IOException {
        System.out.println("Executing After Scenario");
        // After scenario hook
        String scenarioName = scenario.getName();
        String status = scenario.getStatus().toString();
        System.out.println("scenarioName: "+scenarioName+ " Status: "+status);
        // Map Cucumber scenario status to custom status (e.g., Passed, Failed)
        if (status.equalsIgnoreCase("PASSED")) {
            scenarioStatuses.put(scenarioName, "Passed");
        } else {
            scenarioStatuses.put(scenarioName, "Failed");
        }
        System.out.println("########################################################################################################");
       // writeScenarioStatusesToExcel(scenarioStatuses, "src/test/resources/ExecutionStatusSheet/scenariostatus.xlsx");
    }
    private void handleTestRunStarted(TestRunStarted event) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Step Execution Details");
        stepDetails = new ArrayList<>();
    }
    /*public static void writeScenarioStatusesToExcel(Map<String, String> scenarioStatuses, String filePath) throws IOException {
        workbook=new XSSFWorkbook();
        File file = new File(filePath);
        Sheet sheet = workbook.createSheet("scenariostatus");
        int rowNum = 1;
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Test Case");
        headerRow.createCell(1).setCellValue("Status");
        for (Map.Entry<String, String> entry : scenarioStatuses.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getKey());
            row.createCell(1).setCellValue(entry.getValue());
        }
        // Write workbook to file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }*/
}