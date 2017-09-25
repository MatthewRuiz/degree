import java.util.Date;

/** This programs displays the balance of a bank account
*/

public class Account
{
   //fields
   private int id;
   private double balance;
   private double annualInterestRate;
   private Date dateCreated;
   
   //Constructors
   public Account()
   {
      id = 0;
      balance = 0.0;
      annualInterestRate = 0;
   }
   
   public Account(int ID, double b)
   {
      id = ID;
      balance = b;
   }
   
   public Account(int ID, double b, double air)
   {
      id = ID;
      balance = b;
      annualInterestRate = air;
   }
   
   
   //getter method
   public int getID()
   {
      return id;
   }
   
   //getter method
   public double getBalance()
   {
      return balance;
   }
   
   //getter method
   public double getAnnualInterestRate()
   {
      return annualInterestRate;
   }
   
   //getter method
   public Date getDateCreated()
   {
      return dateCreated;
   }
   
   public void setID(int ID)
   {
      id = ID;
   }
   
   public void setBalance(double b)
   {
      balance = b;
   }
   
   public void setAnnualInterestRate(double air)
   {
      annualInterestRate = air;
   }
   
   //Gets monthly interest rate from annual interest rate
   public double getMonthlyInterestRate()
   {
      return annualInterestRate/12;
   }
   
   //calculates balance after a withdraw
   public double withdraw(double amount)
   {
      return balance -= amount;
   }
   
   //calculates balance after a deposit
   public double deposit(double amount)
   {
      return balance += amount;
   }
   
}