import java.util.Scanner;//Needed for the Scanner class.

public class PrintingDistinctNumbers
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter ten numbers [1-10]");
      int[] numbers = new int[10];
      
      //Enters the 10 numbers
      for(int i = 0; i < 10;i++)
         numbers[i] = keyboard.nextInt();

      System.out.print("The distinct numbers are: " );
      saveDistinctNumbers(numbers);
      
   }//end main method
   
   /** The saveDistinctNumbers method saves the distinct numbers in the array
       @para numbers Array used for distinct numbers. 
   */
   public static int[] saveDistinctNumbers(int[] numbers)
   {
      //for loop that will determine if the number is distinct
      for(int i = 0; i < 10; i++)
      {
         boolean distinct = true;
         //for loop that determines if the number has already been entered. If so, it will not list it as a distinct number.
         for(int j = 0; j < i; j++)
         {
            if(numbers[i] == numbers[j])
            distinct = false;      
         }
         //Prints out all of the individual distinct numbers
         if(distinct)
               System.out.print(numbers[i]);
      }
      
      return numbers;
      
   }// end saveDistinctNumbers method
}