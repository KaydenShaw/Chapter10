import java.util.Scanner;
import java.util.Date;

class Account {
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    public void withdraw(double amount) { this.balance -= amount; }
    public void deposit(double amount) { this.balance += amount; }
}


public class Main { 
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        while (true) {
            System.out.print("Enter an id: ");
            int id = input.nextInt();

            if (id < 0 || id >= accounts.length) {
                System.out.println("Please enter a correct id.");
                continue;
            }

            while (true) {
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                
                int choice = input.nextInt();
                
                if (choice == 1) {
                    System.out.println("The balance is " + accounts[id].getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    accounts[id].withdraw(input.nextDouble());
                } else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    accounts[id].deposit(input.nextDouble());
                } else if (choice == 4) {
                    break;
                }
            }
        }
    }
}
