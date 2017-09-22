import java.util.Date;

public class AccountTest
{
   public static void main(String[] args)
   {
      Account a1 = new Account(1122, 20000, 0.45);
      java.util.Date dateCreated = new java.util.Date();
      
      //Withdraws $2500 from the account balance.
      a1.withdraw(2500);
      //Deposits $3000 to the account balance.
      a1.deposit(3000);
      //Displays necessary output. Converting the date to a String befor printing.
      System.out.println("Date created: " + dateCreated.toString());
      System.out.println("Account ID: " + a1.getID());         //Displays the balance in a US currency format.
      System.out.printf("Your balance after the transaction is: $%.2f.\n " , a1.getBalance());
      System.out.println("The monthly interest rate on this account is: " + a1.getMonthlyInterestRate() + "%.");
   }
}