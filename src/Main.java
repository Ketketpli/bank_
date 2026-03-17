import entities.Account;
import exceptions.DomainExceptions;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        System.out.println();

        Account acc = new Account(number, name, balance, withdrawLimit);

        try {
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f", acc.getBalance());
        }
        catch (DomainExceptions e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}