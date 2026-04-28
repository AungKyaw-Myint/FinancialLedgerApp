package com.pluralsight.service;

import com.pluralsight.model.Transaction;
import com.pluralsight.util.DateTimeFormatUtil;
import com.pluralsight.util.FileReaderCsv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportsService {

    private final FileReaderCsv fileReaderCsv= new FileReaderCsv();

    public void generateMonthToDateReport(){
        List<Transaction> transactionList = new ArrayList<>();

        try {
            transactionList = fileReaderCsv.fileReading();

            LocalDate start = LocalDate.now().withDayOfMonth(1);

            getHeader();
            for (Transaction transaction : transactionList) {
                if (transaction.getDate().isAfter(start)) {
                    System.out.println(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Report Service Failed! "+e);
        }
    }

    public void generatePreviousMonthReport(){
        try {
            List<Transaction> transactionList = new ArrayList<>();
            transactionList = fileReaderCsv.fileReading();

            LocalDate start = LocalDate.now().minusMonths(1).withDayOfMonth(1);
            LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

            getHeader();
            for (Transaction transaction : transactionList) {
                if (transaction.getDate().isAfter(start) && transaction.getDate().isBefore(end)) {
                    System.out.println(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Report Service Failed! "+e);
        }
    }

    public void generateYearToDateReport(){

        try {

            List<Transaction> transactionList = new ArrayList<>();
            transactionList = fileReaderCsv.fileReading();
            LocalDate start = LocalDate.now().withDayOfYear(1);

            getHeader();
            for (Transaction transaction : transactionList) {
                if (transaction.getDate().isAfter(start)) {
                    System.out.println(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Report Service Failed! "+e);
        }
    }

    public void generatePreviousYearReport(){

        try {
            List<Transaction> transactionList = new ArrayList<>();
            transactionList = fileReaderCsv.fileReading();

            LocalDate start = LocalDate.now().minusYears(1).withDayOfYear(1);
            LocalDate end = start.withDayOfYear(start.lengthOfYear());

            getHeader();
            for (Transaction transaction : transactionList) {
                if (transaction.getDate().isAfter(start) && transaction.getDate().isBefore(end)) {
                    System.out.println(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Report Service Failed! "+e);
        }
    }

    public void generateVendorReport(String vendorName){

        try {

            List<Transaction> transactionList = new ArrayList<>();
            transactionList = fileReaderCsv.fileReading();

            getHeader();
            for (Transaction transaction : transactionList) {
                if (transaction.getVendor().toLowerCase().contains(vendorName.toLowerCase())) {
                    System.out.println(transaction);
                }
            }
        }catch (Exception e){
            System.out.println("Report Service Failed! "+e);
        }
    }

    public void customSearchReport(String inputStartDate, String inputEndDate, String description, String vendorName, String inputAmount){

        try {

            List<Transaction> transactionList = new ArrayList<>();
            transactionList = fileReaderCsv.fileReading();

            LocalDate startDate = inputStartDate.isEmpty() ? null : LocalDate.parse(inputStartDate, DateTimeFormatUtil.DATE_FORMAT);
            LocalDate endDate = inputEndDate.isEmpty() ? null : LocalDate.parse(inputEndDate, DateTimeFormatUtil.DATE_FORMAT);
            Double amount = inputAmount.isEmpty() ? null : Double.parseDouble(inputAmount);

            getHeader();
            for (Transaction transaction : transactionList) {
                // Date filter
                if (startDate != null && transaction.getDate().isBefore(startDate)) continue;
                if (endDate != null && transaction.getDate().isAfter(endDate)) continue;

                // Description filter
                if (!description.isEmpty() &&
                        !transaction.getDescription().toLowerCase().contains(description.toLowerCase())) continue;

                // Vendor filter
                if (!vendorName.isEmpty() &&
                        !transaction.getVendor().toLowerCase().contains(vendorName.toLowerCase())) continue;

                // Amount filter
                if (amount != null && transaction.getAmount() != amount) continue;

                System.out.println(transaction);

            }
        }catch (Exception e){
            System.out.println("Error -> "+e);
        }
    }


    private static void getHeader() {
        System.out.printf(
                "%-12s %-12s %-20s %-18s %s \n",
                "Date", "Time", "Description", "Vendor", "Amount"
        );

        String line = "-".repeat(80);
        System.out.println(line);
    }
}
