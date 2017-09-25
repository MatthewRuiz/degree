public class LandTract
{
   private double length;
   private double width;
   double areaOne, areaTwo;
   
   //constructors
   public LandTract()
   {
      length = 0.0;
      width = 0.0;
   }
   
   public LandTract(double length, double width)
   {
      this.length = length;
      this.width = width;
      areaOne = length * width;
      areaTwo = length * width;
   }
   
   //setters
   public void setLength(double length)
   { 
      this.length = length;
   }
   
   public void setWidth(double width)
   {
      this.width = width;
   }
   
   //getters
   public double getWidth()
   {
      return width;
   }
   
   public double getLength()
   {
      return length;
   }
   
   public double getArea()
   {
      return length * width;
   }
   
   public boolean equals(LandTract landT)
   {
      return (areaOne == landT.areaOne && areaTwo == landT.areaTwo);
   }
   
   public String toString()
   {    
      return "The area of this piece of land is: " + getArea();
   }
}