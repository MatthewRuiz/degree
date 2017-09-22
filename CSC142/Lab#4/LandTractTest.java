import java.util.Scanner;

public class LandTractTest
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      double length, width, areaOne, areaTwo;
      
      System.out.print("Please enter the length of tract 1: ");
      length = keyboard.nextDouble();
      System.out.print("Please enter the width of tract 1: ");
      width = keyboard.nextDouble();
      
      LandTract land1 = new LandTract(length, width);
      
      System.out.print("Please enter the length of tract 2: ");
      length = keyboard.nextDouble();
      System.out.print("Please enter the width of tract 2: ");
      width = keyboard.nextDouble();
      
      LandTract land2 = new LandTract(length, width);
      
      System.out.println(land1);
      System.out.println(land2);
      
      if(land1.equals(land2))
         System.out.println("The two tracts of land are equal in size!");
      else
         System.out.println("The two tracts of land are not equal in size!");
   }
}