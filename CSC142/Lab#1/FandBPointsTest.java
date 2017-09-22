import java.util.Scanner;

public class FandBPointsTest
{
   public static void main(String[] args)
   {
      double temperature;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter a temperature: ");
      temperature = keyboard.nextDouble();
      
      keyboard.close();
      
      FreezingAndBoilingPoints fAndB = new FreezingAndBoilingPoints(temperature);
     
      if (fAndB.isEthylFreezing())
         System.out.println("Ethyl alcohol will freeze at this temperature.");
     
       if (fAndB.isOxygenFreezing())
         System.out.println("Oxygen will freeze at this temperature.");
     
       if (fAndB.isWaterFreezing())
         System.out.println("Water will freeze at this temperature.");
      
       if (fAndB.isEthylBoiling())
         System.out.println("Ethyl alcohol will boil at this temperature.");
      
       if (fAndB.isOxygenBoiling())
         System.out.println("Oxygen will boil at this temperature.");
     
       if (fAndB.isWaterBoiling())
         System.out.println("Water will boil at this temperature."); 
   }
}