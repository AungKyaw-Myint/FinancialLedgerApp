package com.pluralsight.util;

import com.pluralsight.model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCsv {

    private List<Transaction> transactionList= new ArrayList<>();


    public List<Transaction> fileReading(){
        transactionList= new ArrayList<>();
        try {

            // File reading from resource folder
            InputStream inputStream = FileReaderCsv.class
                    .getClassLoader()
                    .getResourceAsStream(FileNameConfig.TRANSACTION_FILE);

            if (inputStream == null) {
                System.out.println("File not found in resources!");
                return null;
            }
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            // skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                Transaction transaction= new Transaction();

                String[] parts = line.split("\\|");

                transaction.setDate(LocalDate.parse(parts[0],DateTimeFormatUtil.DATE_FORMAT));
                transaction.setTime(LocalTime.parse(parts[1],DateTimeFormatUtil.TIME_FORMAT));
                transaction.setDescription(parts[2]);
                transaction.setVendor(parts[3]);
                transaction.setAmount(Double.parseDouble(parts[4]));

                transactionList.add(transaction);
            }
            reader.close();

            fileReadingFromSourceRoot();

        } catch (IOException e) {
            System.out.println("Error file reading!");
            throw new RuntimeException(e);
        }

        return transactionList;
    }

    private void fileReadingFromSourceRoot(){
        try {
            // File reading from resource main
            File file = new File(FileNameConfig.TRANSACTION_FILE);

            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                // skip header
                reader.readLine();

                String line;
                while ((line = reader.readLine()) != null) {
                    Transaction transaction= new Transaction();

                    String[] parts = line.split("\\|");

                    transaction.setDate(LocalDate.parse(parts[0],DateTimeFormatUtil.DATE_FORMAT));
                    transaction.setTime(LocalTime.parse(parts[1],DateTimeFormatUtil.TIME_FORMAT));
                    transaction.setDescription(parts[2]);
                    transaction.setVendor(parts[3]);
                    transaction.setAmount(Double.parseDouble(parts[4]));

                    transactionList.add(transaction);
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Error file reading!");
            throw new RuntimeException(e);
        }

    }
}
