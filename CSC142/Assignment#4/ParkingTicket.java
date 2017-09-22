public class ParkingTicket
{
   private ParkedCar car;
   private PoliceOfficer officer;
   private double fine;
   private int minutes;
   
   private final double BASE_FINE = 25.0;
   private final double HOURLY_FINE = 10.0;
   
   //Constructors
   public ParkingTicket(ParkedCar aCar, PoliceOfficer anOfficer, int min)
   {
      car = aCar;
      officer = anOfficer;
      minutes = min;
      fine = 0.0;
   }
  
   public ParkingTicket(ParkingTicket ticket2)
   {
      car = ticket2.car;
      officer = ticket2.officer;
      fine = ticket2.fine;
      minutes = ticket2.minutes;
   }
   //* Calculates
   public void calculateTicket()
   {
      double hours = minutes/60.0;
      int intHours = (int)hours;
      
      if((hours - intHours) > 0)
         intHours++;
         
         fine = BASE_FINE + (intHours * HOURLY_FINE);
      
   }
   
   public String toString()
   {
      String str = "The fine will be: " + fine;
      
      return str;
   }
}