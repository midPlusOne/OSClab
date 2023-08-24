/*Create an interface Account with methods Bank_deposit(double
Amount) and withdraw(double amount). Implement this interface in
classes for different types of bank accounts, such as CheckingAccount
and SavingsAccount. Write a program that simulates banking operations
using these account types with exception handling.

*/

import java.util.Scanner;

interface Account {
    void Bank_deposit(double amount);

    void Withdraw(double amount);
}

class CheckingAccount implements Account {
    double bal = 0.0;

    public void Bank_deposit(double amount) {
        System.out.println("Amount " + amount + " deposited to your Account ");
        bal += amount;
        System.out.println("Current Balance:" + bal);
    }

    public void Withdraw(double amount) {
        if (bal - amount > 0) {
            System.out.println("Amount " + amount + " withdrawn from your Account ");
            bal -= amount;
            System.out.println("Current Balance:" + bal);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class SavingsAccount implements Account {

    double bal = 0.0;

    public void Bank_deposit(double amount) {
        System.out.println("Amount " + amount + " deposited to your Account ");
        bal += amount;
        System.out.println("Current Balance:" + bal);
    }

    public void Withdraw(double amount) {
        if (bal - amount >= 0) {
            System.out.println("Amount " + amount + " withdrawn from your Account ");
            bal -= amount;
            System.out.println("Current Balance:" + bal);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class as2_1 {
    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount();
        SavingsAccount sa = new SavingsAccount();
        Scanner scanner = new Scanner(System.in);
        int key, ch;
        double amt;

        try {

            while (true) {
                System.out.println("1.Savings Account\n2.Checking Account\n3.Exit");
                System.out.print("Enter your choice:");
                key = scanner.nextInt();
                switch (key) {
                    case 1:
                        System.out.println("1.Deposit\n2.Withdraw\n3.MainMenu");
                        System.out.print("Enter choice:");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                System.out.print("Enter the amount to deposit:");
                                amt = scanner.nextDouble();
                                sa.Bank_deposit(amt);
                                continue;
                            case 2:
                                System.out.print("Enter the amount to withdraw:");
                                amt = scanner.nextDouble();
                                sa.Withdraw(amt);
                                continue;
                            case 3:
                                break;

                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1.Deposit\n2.Withdraw\n3.MainMenu");
                        System.out.print("Enter choice:");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                System.out.print("Enter the amount to deposit:");
                                amt = scanner.nextDouble();
                                ca.Bank_deposit(amt);
                                continue;
                            case 2:
                                System.out.print("Enter the amount to withdraw:");
                                amt = scanner.nextDouble();
                                ca.Withdraw(amt);
                                continue;
                            case 3:
                                break;

                            default:
                                System.out.println("Invalid choice");
                                continue;
                        }
                        break;
                    case 3:
                        System.out.println("Exiting.......");
                        return;
                    default:
                        System.out.println("Enter proper choice");
                        break;
                }
            }
        } catch (Exception exception) {
            System.out.println("Enter proper value");
            return;
        }
    }
}