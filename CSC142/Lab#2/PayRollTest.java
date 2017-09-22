import java.util.Scanner; //Needed for the Scanner class

public class PayRollTest
{
   public static void main(String[] args)
   {
      final int EMPLOYEES = 7;
      double payRate;
      int hours;
     
      Payroll payRoll = new Payroll();
      Scanner keyboard = new Scanner(System.in);
     
      for (int i = 0; i < EMPLOYEES; i++)
      {
         //Get Employee ID
         System.out.println("EmployeeID:" + payRoll.getEmployeeID(i));
      
         //Get hours worked
         System.out.println("Enter the hours worked:");
         hours = keyboard.nextInt();
         payRoll.setHours(i,hours);
       
         //Check if hours worked is greater than 0.
         while(hours<0)
         {
            System.out.println("The number of hours worked that was entered is invalid, please enter a number >0");
            System.out.println("Enter the hours worked: ");
            hours = keyboard.nextInt();
            payRoll.setHours(i,hours);
         }//End while loop
         
         //Spacing
         System.out.println();
      
         //Get the payRate
         System.out.println();
         System.out.println("Enter the hourly rate:");
         payRate = keyboard.nextDouble();
         payRoll.setPayRate(i, payRate);
       
       
         //Check if payRate is greater than $6.00
         while(payRate < 6.00)
         {
            System.out.println("The number is invalid, please enter a number that is not less then 6.00 for pay rate.");
            System.out.println("Enter the hours worked:");
            payRate = keyboard.nextDouble();
         }//end of while loop
         
         //Spacing
         System.out.println();
      
      }//End of for loop
      
      //Display the total wage of the employee
      payRoll.totalPay();//Calculates employee's total pay.
      
      for (int i = 0; i < EMPLOYEES; i++ )
         System.out.printf("EmployeeID: %d Pay Roll is $%4.2f\n", payRoll.getEmployeeID(i) , payRoll.getWages(i));
   }
}