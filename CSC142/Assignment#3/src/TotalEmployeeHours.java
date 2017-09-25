import java.util.Scanner;
import java.io.*;

public class TotalEmployeeHours
{
   public static void main(String[] args)throws IOException
   {
      File file = new File("hours.txt");//Read in the "hours.txt" file
      Scanner inFile = new Scanner(file);
      
      int[][] hours = new int[8][7];
      int[] employee = new int[8];
      int[] totalHours = new int[8];
      int[] totalHoursTwo = new int[8];
      
      int sum = 0;
      int count = 0;
      int count2 = 0;
      int count3 = 0;
      
      
      while(count2 < (hours[0].length * hours.length))
      {
         if(count3 == 7)
         {
            sum = 0;
            count3 = 0;
            count++;
         }
         
         hours[count][count3] = inFile.nextInt();
         sum+=hours[count][count3];
         totalHours[count] = sum;
         totalHoursTwo[count] = sum;
         count2++;
         count3++;
         
      }
      
      //Call the sort method
      Sort(totalHoursTwo);
      
      for(int i=0; i<totalHours.length; i++)
         for(int j=0;j<totalHours.length; j++)
            if(totalHoursTwo[i] == totalHours[j])
               employee[i] = j;
               
      //Display hours worked
      for(int i=0; i<totalHours.length; i++)
         System.out.println("Employee " + employee[i] + ": " + totalHoursTwo[i]);
         
        
      inFile.close();
   }
   /** Sort method sorts the total for each employee in descending order
       @param number the total number of hours 
   */
   public static int[] Sort(int[] number)
   {
      boolean status = true;
      int temp;
      
      while(status)
      {
         status = false;
         
         for(int i=0; i<number.length - 1; i++)
            if(number[i] < number[i+1])
            {
               temp = number[i];
               number[i] = number[i+1];
               number[i+1] = temp;
               status = true;
            }
      }
      
      return number;
   }
}