/** 
   The Payroll class determines the Employee, how many hours they have worked, their payrate and then calculates their total gross pay.
*/

public class Payroll
{
   
   public final int EMPLOYEES = 7;
   private final int[] employeeID = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
   private final int[] hours = new int[EMPLOYEES];
   private final double[] payRate = new double[EMPLOYEES];
   private final double[] wages = new double[EMPLOYEES];
   
   //mutator methods
   public void setHours(int i, int hoursWorked)
   { 
      hours[i] = hoursWorked;
   }
   
   public void setEmployeeID(int i, int ID)
   {
      employeeID[i] = ID;
   }
   
   public void setPayRate(int i, double payRates)
   {
      payRate[i] = payRates;
   }
   
   public void setWages(int i, int wage)
   {
      wages[i] = wage;
   }
   
   //Accessor methods
   public int getEmployeeID(int i)
   {
      return employeeID[i];
   }
   
   public double getHours(int i)
   {
      return hours[i];
   }
   
   public double getWages(int i)
   {
      return payRate[i] * hours[i];
   }
   
   public double getPayRate(int i)
   {
      return payRate[i];
   }
   
   /** totalPay method calculates the total gross pay of the emplyee
   */
   public void totalPay ()
   {
      int hrs = 0;
      double pRate = 0;
      double wage = 0;
    
      for (int index = 0; index < employeeID.length; index++ )
         wage = hrs * pRate;

   }//end totalPay method
   
}//end Payroll class