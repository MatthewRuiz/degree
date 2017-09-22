/**
      This class stores data about the parked car
*/

public class ParkedCar
{
   private String carMake;       //Type of car
   private String model;         //Model of car
   private String color;         //Color of the car
   private String licenseNumber; //License Plate number of car
   private int minutesParked;    //Amount of minutes parked
   
   /**
      No arg constructor that intializes fields to default values
   */
   public ParkedCar()
   {
      carMake = "Unknown";
      model = "Unknown";
      color = "Unknown";
      licenseNumber = "Unknown";
      minutesParked = 0;
   }
   /**This constructor intializes all of the fields
      @param mk The car's make
      @param mod The car's model
      @param col The car's color
      @param lic The car's license plate number
      @param min The amount of minutes parked
   */
   public ParkedCar(String mk, String mod, String col, String lic, int min)
   {
      carMake = mk;
      model = mod;
      color = col;
      licenseNumber = lic;
      minutesParked = min;
   }
   //Copy constructor
   public ParkedCar(ParkedCar car2)
   {
      carMake = car2.carMake;
      model = car2.model;
      color = car2.color;
      licenseNumber = car2.licenseNumber;
      minutesParked = car2.minutesParked;
   }
   //getters
   public String getCarMake()
   {
      return carMake;
   }
   
   public String getModel()
   {
      return model;
   }
   
   public String getColor()
   {
      return color;
   }
   
   public String getLicenseNumber()
   {
      return licenseNumber;
   }
   
   public int getMinutesParked()
   {
      return minutesParked;
   }
   //setters
   public void setCarMake(String carM)
   {
      carMake = carM;
   }
   
   public void setModel(String model)
   {
      model = this.model;
   }
   
   public void setColor(String color)
   {
      color = this.color;
   }
   
   public void setLicenseNumber(String lic)
   {
      licenseNumber = lic;
   }
   
   public void setMinutesParked(int min)
   {
      minutesParked = min;
   }
   public String toString()
   {
      String str = "Car Make: " + carMake + "\nCar Model: " + model + 
                      "\nColor: " + color + "\nLicense Number: " + licenseNumber + 
                      "\nMinutes Parked: " + minutesParked;
                      
      return str;
   }
}