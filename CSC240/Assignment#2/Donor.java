import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Donor extends Element
{
   private String name;
   private String location;
   private double amount;
   
   Scanner keyboard = new Scanner(System.in);
   
    /**
	 * Default constructor. Initializes all data to default values.
	 * 
	 */
   public Donor()
   {
      name = "";
      location = "";
      amount = 0.0;
   }
   
   public Donor(String name)
   {
      this.name = name;
      location = "";
      amount = 0.0;
   }
   
   /**
   *  Getter/accessor methods
   */
   public String getName()
   {
      return name;
   }
   
    public String getLocation()
   {
      return location;
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
   
   public void setAmount(double Amount)
   {
      this.amount = amount;
   }
   
    /**
	 * Reads in the data for a Donor object from the user.
	 */
	public void readIn() 
   {

		System.out.print("Donors name: ");
		this.name = keyboard.nextLine().toUpperCase().trim();
      
		System.out.print("Donors location: ");
		this.location = keyboard.nextLine().toUpperCase();
      
		System.out.print("Total donation amount: ");
		amount = keyboard.nextDouble();
	}

	/**
	 * Displays information about a specific donor.
	 */
	public void display() 
   {
		DecimalFormat d = new DecimalFormat("###,###.##");
		System.out.println("Name: " + this.name);
		System.out.println("Location: " + this.location);
		System.out.println("Donation amount: $" + d.format(amount));
	}
    /**
	 * Compares two Donor objects
	 * @param obj the Donor being compared           
	 * @return whether or not the two Donors are equa
	 */
   public boolean equals(Element obj)
   {
      return name.equals(((Donor) obj).name);
   }
   
    /**
	 * Clones a Donor.
	 * @return the cloned Donor.
	 */
   public Element clone()
   {
      Donor clone = new Donor();

      clone.name = name;
      clone.location = location;
      clone.amount = amount;
      
      return clone;
   }

}