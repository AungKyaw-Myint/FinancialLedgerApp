package com.pluralsight.service;

import com.pluralsight.model.Transaction;
import com.pluralsight.util.FileReaderCsv;

import java.util.ArrayList;
import java.util.List;

public class LedgerService {

    private final FileReaderCsv fileReaderCsv= new FileReaderCsv();

    public void getAllTransactions(boolean includeDeposits, boolean includePayments){

        List<Transaction> transactionList = new ArrayList<>();
        transactionList=fileReaderCsv.fileReading();

        getHeader();
        for (Transaction transaction: transactionList){
            if(includeDeposits && transaction.getAmount() >=0) {
                System.out.println(transaction);
            }
            if (includePayments && transaction.getAmount() <0){
                System.out.println(transaction);
            }
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
