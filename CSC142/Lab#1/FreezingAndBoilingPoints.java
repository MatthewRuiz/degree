public class FreezingAndBoilingPoints
{
   private final double temperature;
   
   public FreezingAndBoilingPoints(double temp)
   {
      temperature = temp;
   }
   
   public double getTemperature()
   {
      return temperature;
   }
   
   public boolean isEthylFreezing()
   {
       return temperature <= -173.0;
   }
   
   public boolean isEthylBoiling()
   {
       return temperature >=172.0;
   }
   
   public boolean isOxygenFreezing()
   {
       return temperature <= -362.0;
   }
   
   public boolean isOxygenBoiling()
   {
       return temperature >= -306.0;
   }
   
   public boolean isWaterFreezing()
   {
       return temperature <= 32.0;
   }
   
   public boolean isWaterBoiling()
   {
       return temperature >= 212;
   }
   
   
}