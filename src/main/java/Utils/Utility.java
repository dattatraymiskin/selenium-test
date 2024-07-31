package Utils;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.CSVReader;

public class Utility {

    public void saveCardNumber(String FILE_PATH , String cardNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(cardNumber);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveJson(String FILE_PATH , String response) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(response);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateCardNumber(String FILE_PATH, String cardNumber) {
        try {
            Path filePath = Paths.get(FILE_PATH);
            boolean fileExists = Files.exists(filePath);
            boolean fileEmpty = Files.size(filePath) == 0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath), true))) {
                if (!fileExists || fileEmpty) {
                    writer.write("CardAccountNumber");
                    writer.newLine();
                }
                writer.write(cardNumber);
                writer.newLine();
                System.out.println("Data saved to CSV file successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String csvFilePath;

    public Utility(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }


    public String CsvData() {
        List<String[]> data;
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            reader.skip(1);
            data = reader.readAll();
            for (String[] row : data) {
                for (String cell : row) {
                    return cell;
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
