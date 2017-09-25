public class FuelGauge
{
   final double MAXFUEL = 15.0;
   private double fuel;
   
   public FuelGauge()
   {
      fuel = 0.0;
   }
   
   public FuelGauge(double fuel)
   {
      //to check if fuel entered exceeds maximum amount
      if(fuel <= MAXFUEL)
         this.fuel = fuel;
      else
         fuel = MAXFUEL;
   }
   
   //setter
   public void setFuel(double fuel)
   {
      this.fuel = fuel;
   }
   
   //getter
   public double getFuel()
   {
      return fuel;
   }
   
   public void incrementFuel()
   {
      if(fuel < MAXFUEL)
         fuel++;
     
   }
   
   public void decrementFuel()
   {
      if(fuel > 0)
         fuel--;
   }
   
   
}
   