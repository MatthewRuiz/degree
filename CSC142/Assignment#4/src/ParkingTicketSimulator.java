public class ParkingTicketSimulator
{
   public static void main(String[] args)
   {
     //Call the ParkedCar class
     //Assign the appropriate discriptions to the vehicle.
      ParkedCar car = new ParkedCar("Ford" ,"Focus" ,"Red" , "JK4563J" ,150);
   
      //Create a ParkingMeter object
      //Assign 60 to the amount of minutes purchased.
      ParkingMeter meter = new ParkingMeter(60);
   
      //Create a PoliceOfficer object
      //Assign a name and badge number to the patrolling officer
      PoliceOfficer officer = new PoliceOfficer("Officer John Doe" , "4243");
   
      //Create a ParkingTicket object using the information from the ParkedCar and ParkingMeter classes
      ParkingTicket ticket = officer.patrol(car, meter);
   
      System.out.println(car);
      System.out.println(meter);
      System.out.println(officer);
      //Check if the ticket is legal or not
      if(ticket == null)
         System.out.println("There was no ticket!");
      else
      {
         ticket.calculateTicket();
         System.out.print(ticket);
      }
   }
   
}