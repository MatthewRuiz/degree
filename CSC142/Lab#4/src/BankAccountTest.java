public class BankAccountTest
{
   public static void main(String[] args)
   {
      BankAccount fund = new BankAccount(546.34);
      BankAccount fund2 = new BankAccount(fund);
      System.out.println(fund);
      
      System.out.println(fund.equals(fund2));
      
      if(fund.equals(fund2))
         System.out.println("Both objects are the same.");
      else
         System.out.println("Both objects are different.");
      
   }
}