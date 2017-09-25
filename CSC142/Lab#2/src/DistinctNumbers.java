import java.util.*;

/** Distince numbers
 */
 
public class DistinctNumbers {
   public static void main(String[] args) {
      final int SIZE = 10;
      int[] numbers = new int[SIZE];
      int[] distinct;
      
      //initialize numbers
      for (int i = 0; i < numbers.length; i++)
         numbers[i] = ((int) (Math.random() * 10)) + 1;
      
      //output numbers
      System.out.println("In original array:");
      for (int i = 0; i < numbers.length; i++)
         System.out.print(numbers[i]+" ");
      System.out.println();
      
      //call method
      distinct = saveDistinctNumbers(numbers);
      
      //output distinct: 
      System.out.println("\nIn the array of distinct numbers:");
      for (int i = 0; ((i < distinct.length)||(distinct[i]== 0)); i++)
         System.out.print(distinct[i] + " ");
      System.out.println();

   }
   
   /** save distinct numbers
     @ para numbers: original array
     @ return: partially filled array that has distinct numbers from numbers
    */
    public static int[] saveDistinctNumbers(int[] array) {
    
    
    }


}