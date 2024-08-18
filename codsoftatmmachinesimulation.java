import java.util.Scanner;
class BankAccount {
    private double balance;
       public BankAccount(double initialBalance) {
        this.balance = initialBalance;
       }
         public double getBalance() {
            return balance;
        }
           public void deposit(double amount) {
            if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
          } else {
            System.out.println("Invalid deposit amount.");
           }
           }
          public boolean withdraw(double amount) {
          if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
            } else {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
            } else {
                System.out.println("Insufficient funds.");
            }
            return false;
             }
           }
           }

        class ATM {
        private BankAccount account;
         private Scanner scanner;
         public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
          }
          public void showMenu() {
           while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    CheckBalance();
                    break;
                case 2:
                    DepositMoney();
                    break;
                case 3:
                    WithdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
               }
             }
         }
         private void CheckBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
       }
        private void DepositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        }
         private void WithdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
         }
            }
       public class Main {
        public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(500.00);
        ATM myATM = new ATM(myAccount);
        myATM.showMenu();
      }
        }
