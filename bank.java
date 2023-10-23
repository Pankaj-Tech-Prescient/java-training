import java.util.Scanner;
import java.util.ArrayList;

class Account{
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withraw(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void checkBalance(){
        System.out.println("Account " + accountNumber + " Balance: $" + balance);
    }
}

class Customer{
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void listAccounts(){
        System.out.println(name + "'s Accounts: ");
        for (Account account : accounts){
            System.out.println("Account " + account.getAccountNumber() + ": $" + account.getBalance());
        }
    }
}
public class bank {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        while (true){
            System.out.println("\nBank Management System");
            System.out.println("1. Create Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. List Customer Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer newCustomer = new Customer(customerName);
                    customers.add(newCustomer);
                    break;
                case 2:
                    System.out.println("Enter customer name: ");
                    String existingCustomerName = scanner.nextLine();
                    Customer customerToAddAccount = findCustomerByName(customers, existingCustomerName);
                    if (customerToAddAccount != null){
                        System.out.print("Enter initial balance for the new account: $");
                        double initialBalance = scanner.nextDouble();
                        Account newAccount = new Account(generateAccountNumber(), initialBalance);
                        customerToAddAccount.addAccount(newAccount);
                        System.out.println("New account added to " + existingCustomerName + ".");
                    }else {
                        System.out.print("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String depositCustomerName = scanner.nextLine();
                    Customer customerToDeposit = findCustomerByName(customers, depositCustomerName);
                    if (customerToDeposit != null){
                        System.out.println("Enter account number: ");
                        int accountNumber = scanner.nextInt();
                        Account accountToDeposit = findAccountByNumber(customerToDeposit, accountNumber);
                        if (accountToDeposit != null){
                            System.out.println("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            accountToDeposit.deposit(depositAmount);
                            System.out.println("Deposit successfull.");
                        }else {
                            System.out.println("Account not found.");
                        }
                    }else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter customer name: ");
                    String debitCustomerName = scanner.nextLine();
                    Customer customerToDebit = findCustomerByName(customers, debitCustomerName);
                    if (customerToDebit != null){
                        System.out.println("Enter account number: ");
                        int accountNumber = scanner.nextInt();
                        Account accountToDebit = findAccountByNumber(customerToDebit, accountNumber);
                        if (accountToDebit != null){
                            System.out.println("Enter debit amount: ");
                            double debitAmount = scanner.nextDouble();
                            if (accountToDebit.withraw(debitAmount) == true) {
                                System.out.println("Debit scussessfull.");
                            }else {
                                System.out.println("Debit unscussessfull.");
                            }
                        }
                        else {
                            System.out.println("Account not found.");
                        }
                    }else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter customer name: ");
                    String balanceCustomerName = scanner.nextLine();
                    Customer customerToCheckBalance = findCustomerByName(customers, balanceCustomerName);
                    if (customerToCheckBalance != null){
                        customerToCheckBalance.listAccounts();
                    }else {
                        System.out.println("Customer not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter customer name: ");
                    String listAccountsCustomerName = scanner.nextLine();
                    Customer customerToListAccounts = findCustomerByName(customers, listAccountsCustomerName);
                    if (customerToListAccounts != null) {
                        customerToListAccounts.listAccounts();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static Customer findCustomerByName(ArrayList<Customer> customers, String name){
        for (Customer customer: customers){
            if (customer != null && customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

    public static Account findAccountByNumber(Customer customer, int accountNumber){
        for (Account account: customer.getAccounts()){
            if (account != null && account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    public static int generateAccountNumber(){
        return (int) (Math.random() * 10000);
    }
}
