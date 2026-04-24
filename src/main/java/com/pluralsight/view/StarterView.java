package com.pluralsight.view;

import java.util.List;
import java.util.Scanner;

public class StarterView {

    public void startApplication(){

        boolean flag= true;
        Scanner sc= new Scanner(System.in);

        while (true){
            mainMenu();
            System.out.print("Please choose the menu :");
            String option= sc.nextLine();

            switch (option) {
                case "D":

                    break;
                case "P":

                    break;
                case "L":

                    break;
                case "E":
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    public void ledgerFunction(Scanner sc){
        ledgerMenu();
        System.out.print("Please choose the ledger option :");
        String option= sc.nextLine();

        switch (option) {
            case "A":

                break;
            case "D":

                break;
            case "P":

                break;
            case "R":
                reports(sc);
                break;
            case "H":
                break;
            default:
                System.out.println("Invalid Option!");
        }
    }

    public void reports(Scanner sc){
        reportsMenu();
        System.out.print("Please choose the reports list :");
        int option= sc.nextInt();

        switch (option) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                break;
            case 6:
                break;

            case 0:
                ledgerFunction(sc);
                break;
            default:
                System.out.println("Invalid Option!");
                ledgerFunction(sc);
        }

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
