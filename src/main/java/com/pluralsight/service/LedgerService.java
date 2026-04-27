package com.pluralsight.service;

import com.pluralsight.model.Transaction;
import com.pluralsight.util.FileReaderCsv;

import java.util.ArrayList;
import java.util.List;

public class LedgerService {

    private final FileReaderCsv fileReaderCsv= new FileReaderCsv();

    public void getAllTransaction(){

        List<Transaction> transactionList = fileReaderCsv.fileReading();

        getHeader();
        for (Transaction transaction: transactionList){
            System.out.println(transaction);
        }
    }

    public static void getHeader() {
        System.out.printf(
                "%-12s %-12s %-20s %-18s %s \n",
                "Date", "Time", "Description", "Vendor", "Amount"
        );

        String line = "-".repeat(80);
        System.out.println(line);
    }
}
