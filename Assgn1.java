/*1 Create an interface Account with methods Bank_deposit(double
Amount) and withdraw(double amount). Implement this interface in
classes for different types of bank accounts, such as CheckingAccount
and SavingsAccount. Write a program that simulates banking operations
using these account types with exception handling. */
import java.util.Scanner;
interface Account {
    void bankDeposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class CheckingAccount implements Account {
    private double balance;

    public CheckingAccount(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public void bankDeposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount implements Account {
    private double balance;

    public SavingsAccount(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public void bankDeposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
public class Assgn1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CheckingAccount checkingAccount = new CheckingAccount(1000);
        SavingsAccount savingsAccount = new SavingsAccount(5000);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Manage Checking Account");
            System.out.println("2. Manage Savings Account");
            System.out.println("3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    manageAccount(checkingAccount, "Checking Account", scanner);
                    break;

                case 2:
                    manageAccount(savingsAccount, "Savings Account", scanner);
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        System.out.println("Checking Account balance: $" + checkingAccount.getBalance());
        System.out.println("Savings Account balance: $" + savingsAccount.getBalance());

        scanner.close();
    }

    private static void manageAccount(Account account, String accountType, Scanner scanner) {
        System.out.println("Managing " + accountType);
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Back to main menu");
        int operation = scanner.nextInt();

        try {
            switch (operation) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.bankDeposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    System.out.println(accountType + " balance: $" + account.getBalance());
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
