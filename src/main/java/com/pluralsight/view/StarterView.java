package com.pluralsight.view;

import com.pluralsight.model.Transaction;
import com.pluralsight.service.LedgerService;
import com.pluralsight.service.ReportsService;
import com.pluralsight.service.TransactionsService;
import java.util.Scanner;

public class StarterView {

    private final TransactionView transactionView = new TransactionView();
    private final TransactionsService transactionsService= new TransactionsService();
    private final LedgerService ledgerService= new LedgerService();
    private final ReportsService reportsService= new ReportsService();

    public void startApplication(){

        boolean flag= true;
        Scanner sc= new Scanner(System.in);

        while (flag){

            try {
                mainMenu();
                System.out.print("Please choose the menu :");
                String option= sc.nextLine();

                switch (option) {
                    case "D":
                        Transaction depositTran=transactionView.deposit(sc);
                        if(depositTran != null)
                            transactionsService.makeDeposit(depositTran);
                        break;
                    case "P":
                        Transaction payment=transactionView.payment(sc);
                        if (payment != null)
                            transactionsService.payment(payment);
                        break;
                    case "L":
                        ledgerFunction(sc);
                        break;
                    case "E":
                        flag=false;
                        System.out.println("Exit the program!");
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            }catch (Exception e){
                System.out.println("Invalid Option!" +e);
            }

        }
    }

    public void ledgerFunction(Scanner sc){

        boolean flag= true;
        while (flag) {

            try {

                ledgerMenu();
                System.out.print("Please choose the ledger option :");
                String option = sc.nextLine();

                switch (option) {
                    case "A":
                        ledgerService.getAllTransactions(true, true);
                        break;
                    case "D":
                        ledgerService.getAllTransactions(true, false);
                        break;
                    case "P":
                        ledgerService.getAllTransactions(false, true);
                        break;
                    case "R":
                        reports(sc);
                        break;
                    case "H":
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            }catch (Exception e){
                System.out.println("Invalid Option!");
            }
        }
    }

    public void reports(Scanner sc){

        boolean flag= true;
        while (flag) {

            try {
                reportsMenu();
                System.out.print("Please choose the reports list :");

                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        reportsService.generateMonthToDateReport();
                        break;
                    case 2:
                        reportsService.generatePreviousMonthReport();
                        break;
                    case 3:
                        reportsService.generateYearToDateReport();
                        break;
                    case 4:
                        reportsService.generatePreviousYearReport();
                        break;
                    case 5:
                        System.out.print("Search by vendor name :");
                        String vendorName= sc.nextLine();
                        reportsService.generateVendorReport(vendorName);
                        break;
                    case 6:
                        customSearch(sc);
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            }catch (Exception e){
                sc.nextLine();
                System.out.println("Invalid Option!");
            }
        }
    }

    public void customSearch(Scanner sc){
        System.out.println("-----Custom Search----");
        System.out.print("Start Date (yyyy-MM-dd):");
        String startDate = sc.nextLine();

        System.out.print("End Date (yyyy-MM-dd):");
        String endDate = sc.nextLine();

        System.out.print("Description:");
        String description = sc.nextLine();

        System.out.print("Vendor:");
        String vendor = sc.nextLine();

        System.out.print("Amount:");
//        double amount = sc.nextDouble();
        String amount = sc.nextLine();

        reportsService.customSearchReport(startDate,endDate,description,vendor,amount);

    }

    public void mainMenu(){
        System.out.println("D) Add Deposit.");
        System.out.println("P) Make Payment [Debit].");
        System.out.println("L) Ledger.");
        System.out.println("E) Exit.");
    }

    public void ledgerMenu(){
        System.out.println("A) All.");
        System.out.println("D) Deposits.");
        System.out.println("P) Payments.");
        System.out.println("R) Reports.");
        System.out.println("H) Home.");
    }

    public void reportsMenu(){
        System.out.println("1) Month To Date.");
        System.out.println("2) Previous Month.");
        System.out.println("3) Year To Date.");
        System.out.println("4) Previous Year.");
        System.out.println("5) Search by Vendor.");
        System.out.println("6) Custom Search.");
        System.out.println("0) Back.");
    }


}
