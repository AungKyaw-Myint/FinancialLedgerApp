# Financial Tracker CLI Application (Java)

## 📌 Overview

This is a Java Command Line Interface (CLI) application designed to track financial transactions for personal or business use. Users can record deposits and payments, view a ledger, and run reports based on transaction history.

All transactions are stored in a CSV file and persist between application runs.

---

## 💾 Data Storage

All transaction data is stored in a file named:


- **Positive amount** → Deposit
- **Negative amount** → Payment (Debit)

---

## 🚀 Features

### 🏠 Home Screen

The main menu provides the following options:

- **D) Add Deposit**  
  Add a deposit transaction and save it to the CSV file.

- **P) Make Payment (Debit)**  
  Add a payment (expense) transaction and save it to the CSV file.

- **L) Ledger**  
  Navigate to the ledger screen to view transaction history.

- **X) Exit**  
  Exit the application.

---

### 📒 Ledger Screen

Displays all transactions with the **newest entries first**.

Options:

- **A) All**  
  Display all transactions.

- **D) Deposits**  
  Display only deposit transactions (positive amounts).

- **P) Payments**  
  Display only payment transactions (negative amounts).

- **R) Reports**  
  Open the reports screen.

- **H) Home**  
  Return to the home screen.

---

### 📊 Reports Screen

Provides pre-defined and custom filtering options:

#### Pre-defined Reports:

- **1) Month To Date**
- **2) Previous Month**
- **3) Year To Date**
- **4) Previous Year**
- **5) Search by Vendor**  
  Prompts user for vendor name and displays matching transactions.

- **6) Custom Search**

  Allows filtering transactions based on multiple criteria:

    - Start Date
    - End Date
    - Description
    - Vendor
    - Amount
- **0) Back**  
  Return to the Ledger screen.

---

👉 Behavior:
- If a field is filled, filter by it
- If a field is left blank, ignore it in filtering

---

## 🛠️ Technologies Used

- Java (Core Java)
- File I/O (CSV handling)
- CLI-based user interface
- Date and time handling

---

## ▶️ How to Run

1. Compile the project:
   ```bash
   javac Main.java