import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**An exercise of using methods */

public class MethodExercise
{
   /** Main Method */
   //Group A fill in the blanks for this method.
   public static void main (String[] args)
   {
      double num1, num2, num3, avg, max, min;
      boolean isTriangle;
            
      //Get input for three numbers.
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter the first number: ");
      num1 = keyboard.nextDouble();
      
      System.out.print("Enter the second number: ");
      num2 = keyboard.nextDouble();
      
      System.out.print("Enter the third number: ");
      num3 = keyboard.nextDouble();
      
      //Call calcAverage method.
      avg = calcAverage(num1, num2,num3);
        
      //Output the result
      System.out.printf("The average of the three numbers is %4.2f \n" , avg);
      
      //Call findMax method.
      max = findMax(num1,num2,num3);
      
      //Output max
      System.out.println("The maximum number of the three numbers is " + max);
      
      //Call findMin method.
      min = findMin(num1, num2, num3);
      
      //Output min
      System.out.println("The minimum number of the three numbers is " + min);
      
      
      //Call sort method
      sortNumbers(num1, num2, num3);
          
      //Call isValidTriangle method
      isTriangle = isValidTriangle(num1, num2, num3);
      if( isTriangle )
        System.out.println("It is a valid triangle!");
      else
        System.out.println("It is not a valid triangle!");
 
   }//End Main
   
   /**Method calcAverage: Calculates and returns the average of the three numbers*/
   public static double calcAverage(double num1, double num2, double num3)
   {
      return (num1 + num2 + num3)/3;
   }
   
   /**Method findMax: Finds and returns the maximum number among the three numbers*/
   public static double findMax(double num1, double num2, double num3)
   {
      double max = 0;
      
      if(num1>0)
        max = num1;
      if(num2 > max)
        max = num2;
      if(num3 > max)
        max = num3;
        
        return max;
   }
   
   /**Method findMin: Finds and returns the minimum number among the thre numbers*/
   public static double findMin(double num1, double num2, double num3)
   {
      double min = num1;
      
     if(num2 < min)
      min = num2;
     if(num3 < min)
      min = num3;
    
        return min;
   }
   
   /**Method sort: Sorts and displays the three numbers in increasing order*/
   public static double[] sortNumbers(double num1, double num2, double num3)
   {
        double numList[] = {num1, num2, num3};
        Arrays.sort(numList);
        return numList;
   }
   
   
   /**Method isValidTriangle: Determines if the three numbers(representing three edges) can form a valid triangle*/
   public static boolean isValidTriangle(double num1, double num2, double num3)
   {
      double numList[] = sortNumbers(num1, num2, num3);
      
      if ( numList[0] + numList[1] > numList[2] ) 
         return true;
      else
         return false;
      
   }


}//End Class