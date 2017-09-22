import java.util.Scanner;

public class StringReverse
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter a word.");
      String word = keyboard.nextLine();
      
      System.out.println(reverse(word));
   }
   
   public static String reverse(String word)
   {
      if((word == null) || (word.length() <= 1))
         return word;
      else
         return reverse(word.substring(1)) + word.charAt(0);
   }
}