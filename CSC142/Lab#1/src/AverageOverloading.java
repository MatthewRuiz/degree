public class AverageOverloading
{
   public static void main(String[] args)
   {
      //Call the overloading methods respectively
      double avg2, avg3, avg4;
      
      avg2 = average(4,5);
      avg3 = average(2,3,4);
      avg4 = average(2,4,5,6);
      
      System.out.printf(" avg2 is %4.2f \n avg3 is %4.2f \n avg4 is %4.2f" , avg2 , avg3 , avg4);
   }
   
   /**Calculate the average of two doubles*/
   public static double average(double num1, double num2)
   {
      return (num1 * num2) / 2;
   }
   
    public static double average(double num1, double num2, double num3)
   {
      return (num1 * num2 * num3) / 3;
   }
   
    public static double average(double num1, double num2, double num3, double num4)
   {
      return (num1 * num2 * num3 * num4) / 4;
   }
   
   
}