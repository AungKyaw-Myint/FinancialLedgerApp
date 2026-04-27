package com.pluralsight.view;

import com.pluralsight.model.Transaction;
import com.pluralsight.util.DateTimeFormatUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TransactionView {

    public Transaction deposit(Scanner sc){
        Transaction transaction= new Transaction();
        System.out.println("-----Deposit----");
        try {
            System.out.print("Description :");
            String description = sc.nextLine();
            if (description == null || description.trim().isEmpty()) {
                System.out.println("Description cannot be empty.");
                return null;
            }

            System.out.print("Vendor :");
            String vendor= sc.nextLine();
            if (vendor == null || vendor.trim().isEmpty()) {
                System.out.println("Vendor cannot be empty.");
                return null;
            }

            System.out.print("Amount :");
            double amount = Double.parseDouble(sc.nextLine());
//            double amount= sc.nextDouble();
//            sc.nextLine();
            if (amount < 0) {
                System.out.println("Amount must be 0 or greater.");
                return null;
            }

            transaction.setDate(LocalDate.parse(LocalDate.now().format(DateTimeFormatUtil.DATE_FORMAT)));
            transaction.setTime(LocalTime.parse(LocalTime.now().format(DateTimeFormatUtil.TIME_FORMAT)));
            transaction.setDescription(description);
            transaction.setVendor(vendor);
            transaction.setAmount(amount);

            return transaction;

        }catch (Exception e){
            System.out.println("❌ Invalid input. Deposit failed. Please try again.");
            return null;
        }
    }

    public Transaction payment(Scanner sc){
        Transaction transaction= new Transaction();
        System.out.println("-----Payment----");
        try {
            System.out.print("Description :");
            String description = sc.nextLine();
            if (description == null || description.trim().isEmpty()) {
                System.out.println("Description cannot be empty.");
                return null;
            }

            System.out.print("Vendor :");
            String vendor= sc.nextLine();
            if (vendor == null || vendor.trim().isEmpty()) {
                System.out.println("Vendor cannot be empty.");
                return null;
            }

            System.out.print("Amount :");
            double amount = Double.parseDouble(sc.nextLine());
            if (amount < 0) {
                System.out.println("Amount must be 0 or greater.");
                return null;
            }
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            transaction.setDate(LocalDate.now());
            transaction.setTime(LocalTime.parse(time.format(formatter)));
            transaction.setDescription(description);
            transaction.setVendor(vendor);
            transaction.setAmount(amount*-1);

            return transaction;

        }catch (Exception e){
            System.out.println("❌ Invalid input. Payment failed. Please try again.");
            return null;
        }
    }
}
