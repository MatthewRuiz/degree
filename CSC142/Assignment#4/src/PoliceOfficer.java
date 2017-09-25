public class PoliceOfficer
{
   private String name;
   private String badgeNumber;
    
   public PoliceOfficer(String n, String bn)
   {
      name = n;
      badgeNumber = bn;
   }
   
   public PoliceOfficer(PoliceOfficer officer2)
   {
      name = officer2.name;
      badgeNumber = officer2.badgeNumber;
   }
   
   public void setName(String name)
   {
      name = this.name;
   }
   
   public void setBadgeNumber(String badgeNumber)
   {
      badgeNumber = this.badgeNumber;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getBadgeNumber()
   {
      return badgeNumber;
   }
   
  public ParkingTicket patrol(ParkedCar car, ParkingMeter meter)
   {
      ParkingTicket ticket;
      
      int illegalMinutes = car.getMinutesParked() - meter.getMinutesPurchased();
      
      //must check if it is an expired ticket
      if(illegalMinutes > 0) //"this" references the PoliceOfficer Object.
         ticket = new ParkingTicket(car,this,illegalMinutes);
      else
         ticket = null;
         
         return ticket;        
   }
   
   public String toString()
   {
      String str = "Officer: " + name + "\nBadge Number: " + badgeNumber;
      
      return str;
   }
}