import java.util.Scanner;

public class CarIntrumentSimulator
{
   public static void main(String[] args)
   {
      final double MPG = 24.0;
      Scanner keyboard = new Scanner(System.in);
      
      double mileage, fuel;
      
      System.out.print("Please enter the car's mileage: ");
      mileage = keyboard.nextDouble();
      
      System.out.print("Please enter the current amount of fuel in the car(In Gallons): ");
      fuel = keyboard.nextDouble();
      
      FuelGauge fuelG = new FuelGauge(fuel);
      Odometer currentMileage = new Odometer(mileage);
      
      while( fuelG.getFuel() > 0)
      {
         currentMileage.incrementMileage();
         
            if(currentMileage.getMileage() % 24.0 == 0)
               fuelG.decrementFuel();
            {
               System.out.println("The amount of fuel is: " + fuelG.getFuel() 
                            + " and the current mileage is: " + currentMileage.getMileage());
            }
      }
   }
}