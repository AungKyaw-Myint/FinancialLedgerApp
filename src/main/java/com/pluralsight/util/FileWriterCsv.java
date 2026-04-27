package com.pluralsight.util;

import com.pluralsight.model.Transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCsv {

    public void fileWriting(String fileName, Transaction transaction){
        File file = new File(fileName);
        boolean isNewFile = !file.exists() || file.length() == 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Format: date,time,description,vendor,amount

            if (isNewFile) {
                writer.write("date|time|description|vendor|amount");
                writer.newLine();

            }
            String line = transaction.getDate() + "|" +
                    transaction.getTime() + "|" +
                    transaction.getDescription() + "|" +
                    transaction.getVendor() + "|" +
                    transaction.getAmount();

            writer.write(line);
            writer.newLine();

            System.out.println("Transaction saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
