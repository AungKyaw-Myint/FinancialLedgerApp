package com.pluralsight.service;

import com.pluralsight.model.Transaction;
import com.pluralsight.util.FileNameConfig;
import com.pluralsight.util.FileWriterCsv;
import com.pluralsight.view.TransactionView;

import java.io.File;

public class TransactionsService {

    private final FileWriterCsv fileWriterCsv= new FileWriterCsv();

    public void makeDeposit(Transaction transaction){

        try{
            fileWriterCsv.fileWriting(FileNameConfig.TRANSACTION_FILE, transaction);
        }catch (Exception e){
            System.out.println("Transaction Service Fail! "+e);
        }

    }

    public void payment(Transaction transaction){
        try {
            fileWriterCsv.fileWriting(FileNameConfig.TRANSACTION_FILE, transaction);
        }catch (Exception e){
            System.out.println("Transaction Service Fail! "+e);
        }
    }
}
