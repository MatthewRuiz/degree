public class RoomDimension
{
   private double length;
   private double width;
   
   public RoomDimension(double width, double length)
   {
      this.width = width;
      this.length = length;
   }
   
   //copy constructor
   public RoomDimension(RoomDimension r) {
      length = r.length;
      width = r.width;
   }
   
   public double getLength()
   {
      return length;
   }
   
   public double getWidth()
   {
      return width;
   }
   
   public double getArea()
   {
      return length * width;
   }
   
      public String toString()
   {
      String str = "Length: " + length + "\nWidth: " + width + "\n";
      
      return str;
   }
   
}

