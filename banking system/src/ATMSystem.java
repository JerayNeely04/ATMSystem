import java.util.Scanner;

public class ATMSystem {

  public static void main(String args[]) {
    backAccount ac = new backAccount(); // backaccount object
    ac.displayMenu(); // Transaction display screen
  }

  static class backAccount {
    double checkBalance;
    double savBalance;
    int prevTransaction;
    String custName;
    int accountNum;
    int accountpin;

    /**
     * 
     * @param amount current amount that is being deposited within the account.
     */
    public void deposit(double amount) {
      Scanner dsc = new Scanner(System.in);
      double deposit = dsc.nextDouble();
      
      amount = deposit; // sets deposit variable to amount

      if (amount != 0) {
        checkBalance = amount + checkBalance;
        System.out.println("Balance Available:" + " " + checkBalance);
        System.out.println("-----------------------------------");
      } else if (amount == 0) {
        System.out.println("No money was deposited");
      }
      
      
    }

    /**
     * 
     * @param amount currrent amount being withdrew
     */
    public void withDraw(double amount) {
      Scanner wsc = new Scanner(System.in);
      double withdraw = wsc.nextDouble();
      amount = withdraw;

      if (checkBalance == 0) {
        System.out.println("insufficent funds");
      } else if (checkBalance != 0) {
        ;

        checkBalance = checkBalance - amount;
        System.out.println("Available Balance:" + savBalance);
        System.out.println("-----------------------------------");
      }
    }

    /**
     * Transaction menu displays which action to take dealing with account.
     */
    public void displayMenu() {
      int pin = 0;

      this.accountpin = pin;
      Scanner sc = new Scanner(System.in);
      System.out.println("\nPlease Enter 4 digit Pin\n");

      int enterPin = sc.nextInt();

      if (enterPin > 9999) {
        System.out.println("Invalid Pin");

      }

      // enters the pin to access the prompt transaction screen.
      if (accountpin == pin) {
        System.out.println("-----------------------------------");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Transfer funds");
        System.out.println("4) Check Balance");
        System.out.println("5) Cancel transaction");
        System.out.println("-----------------------------------");
      }

      int scrnPrompt = sc.nextInt();
      if (scrnPrompt == 1) {
        depositMenu();
      } else if (scrnPrompt == 2) {
        withdrawMenu();
      } else if (scrnPrompt == 3) {
        transferMenu();
      } else if (scrnPrompt == 4) {
        checkBalMenu();
      } else if (scrnPrompt == 5) {
        cancelTransaction();
      }

    }

    /**
     * displays the deposit menu when selected.
     */
    public void depositMenu() {

      System.out.println("****DEPOSIT SCREEN****");
      System.out.println("Please Enter Deposit Amount");
      deposit(checkBalance);
      anotherTransaction();

    }

    /**
     * displays the withdraw menu
     */
    public void withdrawMenu() {
      System.out.println("****WITHDRAW SCREEN****");
      System.out.println("Please Enter Withdraw Amount");
      withDraw(checkBalance);
      anotherTransaction();
    }

    /**
     * Displays the transfer menu allow to transfer from checking to saving account
     */
    public void transferMenu() {
      System.out.println("****TRANSFER SCREEN****");
    }

    /**
     * checks the available balance within checking or saving account
     */
    public void checkBalMenu() {

      System.out.println("****ACCOUNT BALANCE****");
      System.out.println("1)CHECKING  2)SAVINGS");

      Scanner cheksc = new Scanner(System.in);
      int input = cheksc.nextInt();
      if (input == 1) {
        System.out.println("Available Checking Balance:" + checkBalance);
      } else if (input == 2) {
        savBalance = checkBalance;
        
        System.out.println("Available Saving Balance:" + savBalance);
      }
      anotherTransaction();
    }

    public void cancelTransaction() {
      System.out.println("Transaction Canceled\n");
      anotherTransaction();
    }

    public void anotherTransaction() {
      System.out.println("Would you like to make another transaction");
      System.out.println("1) YES");
      System.out.println("2) NO");
      Scanner sc = new Scanner(System.in);
      int input = sc.nextInt();
      if (input == 1) {
        displayMenu();
      } else if (input == 2) {
        System.out.print("Transcation Canceled");
        displayMenu();

      }

    }

  }
}
