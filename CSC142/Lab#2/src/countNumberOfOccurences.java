import java.util.Scanner;//Needed for the Scanner class

public class countNumberOfOccurences
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter integers 1-100: ");
      int[] numbers = new int[100];
      int numb;
      //While loop to test if the number entered is not 0
      while ((numb = keyboard.nextInt()) != 0)
      {       
         numbers[numb]++;
      }//end while loop
      
      for(int i = 1; i < 100; i++)
      {
         if (numbers[i] > 0)
            if(numbers[i] < 2)
              System.out.println(i + " occurs " + numbers[i] + " time. ");
            else
              System.out.println(i + " occurs " + numbers[i] + " times. ");
         
      }//end for loop
      
   }//End main method
   
}//end countNumberOfOccurences class