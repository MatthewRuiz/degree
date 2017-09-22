/**
*  Donor class
*  Matthew Ruiz
*/
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class Donor extends Element
{
   private String name;
   private String location;
   private double amount;
   
    /**
	 * Default constructor. Initializes all data to default values.
	 */   
   public Donor()
   {
      name = "";
      location = "";
      amount = 0.0;
   }
   /**
    Constructor that sets name to the parameter, location to empty String and the amount to 0.0.
    @param name The name that the Donor will be set to
   */
   public Donor(String name)
   {
      this.name = name;
      location = "";
      amount = 0.0;
   }
    /**
	 * Reads in the data for a Donor object from the user.
	 */   
   public void readIn()
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Donor's name: ");
      name = keyboard.nextLine().toUpperCase().trim();
      
      System.out.println("Donor's location: ");
      location = keyboard.nextLine().toUpperCase().trim();
      
      System.out.println("Donation amount: ");
      amount = keyboard.nextDouble();
   }
	/**
	 * Displays information about a specific donor.
	 */   
   public void display()
   {
      DecimalFormat d = new DecimalFormat("###,###.##");
      System.out.println("Donor: " + this.name);
      System.out.println("Location: " + this.location);
      System.out.println("Donation amount: " + d.format(amount));
   }
    /**
	 * Compares two Donor objects
	 * @param obj the Donor being compared          
	 * @return whether or not the two Donors are equal
	 */   
   public boolean equals(Object obj)
   {
      if(obj.getClass().getName().equals("Donor"))
         if(name.equals(((Donor) obj).name))
            return true;
            
            
      return false;
   }
    /**
	 * Clones a Donor.
	 * @return the cloned Donor.
	 */   
   public Element clone()
   {
      Donor d = new Donor();
      
      d.name = this.name;
      d.location = this.location;
      d.amount = this.amount;
      
      return d;
   }
   /**
      Needed to satisfy the promise between the abstract Element class and the calling Donor class
   */
   public String toString()
   {
      return "Name: " + name + "\nLocation: " + location 
                  + "\nDonation Amount: " + amount;
   }
   /**
   *  Getter/accessor methods
   */   
   public String getName()
   {
      return this.name;
   }
   
   public String getLocation()
   {
      return this.location;
   }
   
   public double getAmount()
   {
      return amount;
   }
   /**
   *  Setter/mutator methods
   */   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setLocation(String location)
   {
      this.location = location;
   }
   
   public void setAmount(double amount)
   {
      this.amount = amount;
   }
}