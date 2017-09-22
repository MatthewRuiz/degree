public class Odometer
{
   public final double MAXMILEAGE = 999999.0;
   public final double MPG = 24.0;
   private double mileage;
   
   public Odometer()
   {
      mileage = 0.0;
   }
   
   public Odometer(double mileage)
   {
      this.mileage = mileage; 
   }
   
   //getter
   public double getMileage()
   {
      return mileage;
   }
   
   //setter
   public void setMileage(double mileage)
   {
      this.mileage = mileage;
   }
   
   public void incrementMileage()
   {
      if(mileage < MAXMILEAGE)
         mileage++;
      else
         mileage = 0;
   }


}