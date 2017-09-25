/**
   This class stores data about the parking meter
*/

public class ParkingMeter
{
   private int minutesPurchased;
   
   public ParkingMeter()
   {
      minutesPurchased = 0;
   }
   
   public ParkingMeter(int m)
   {
      minutesPurchased = m;
   }
   
   public void setMinutes(int m)
   {
      minutesPurchased = m;
   }
   
   public int getMinutesPurchased()
   {
      return minutesPurchased;
   }
   
   public String toString()
   {
      String str = "Minutes Purchased: " + minutesPurchased;
      
      return str;
   }
  
}