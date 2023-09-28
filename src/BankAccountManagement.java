import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Account{
    private String accountNumber;
    private Customer customer;
    private double balance;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }
}
class Customer{
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Customer Name: " + name + "\nAddress: " + address;
    }
}
class BankAccountManagementSystem{
    private ArrayList<Account> accountList = new ArrayList<Account>();
    public void addAccount(Account ac) {
        System.out.println("Adding account ");
        accountList.add(ac);
    }
    public void deposit(String accountNumber, double amount) {
        for (Account ac : accountList) {
            if (Objects.equals(ac.getAccountNumber(), accountNumber)) {
                System.out.println("Depositing amount "+ amount);
                ac.deposit(amount);
                break;
            }
        }
    }
    public void withdraw(String accountNumber, double amount) {
        for (Account ac : accountList) {
            if (Objects.equals(ac.getAccountNumber(), accountNumber)) {
                ac.withdraw(amount);
            }
        }
    }
    public void displayBalance(String accountNumber) {
        System.out.println(accountNumber);
        for (Account ac : accountList) {
            if (Objects.equals(ac.getAccountNumber(), accountNumber)) {
                ac.displayBalance();
            }
        }
    }

}
public class BankAccountManagement {
    public static void main(String[] args){
        BankAccountManagementSystem ems = new BankAccountManagementSystem();
        Scanner scan = new Scanner(System.in);
        int option = 0;
        while (option != 5) {
            System.out.println("1. Create Bank Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter Customer Name :: ");
                    String name = scan.next();
                    System.out.print("Enter Customer Address :: ");
                    String address = scan.next();
                    Customer cus = new Customer(name, address);
                    System.out.print("Enter Account Number :: ");
                    String accountNumber = scan.next();
                    Account ac = new Account(accountNumber, cus);
                    System.out.println("Account added successfully!");
                    ems.addAccount(ac);
                    break;
                case 2:
                    System.out.print("Enter account number :: ");
                    accountNumber = scan.next();
                    System.out.print("Enter deposit amount :: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    ems.deposit(accountNumber, amount);
                    break;
                case 3:
                    System.out.print("Enter account number :: ");
                    accountNumber = scan.next();
                    System.out.print("Enter withdraw amount :: ");
                    amount = scan.nextDouble();
                    scan.nextLine();
                    ems.withdraw(accountNumber, amount);
                    break;
                case 4:
                    System.out.print("Enter account number:: ");
                    accountNumber = scan.next();
                    ems.displayBalance(accountNumber);
                    break;
                case 5:
                    System.out.println("Exiting Bank Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }}
        scan.close();
    }}
