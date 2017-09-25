public class RoomCarpet
{
   private RoomDimension size;
   private double carpetCost;
   
   public RoomCarpet(RoomDimension dim, double cost)
   {
      //order matters
      size = new RoomDimension(dim);
      carpetCost = cost;
   }
   
   public void setCarpetCost(double cost)
   {
      cost = carpetCost;
   }
   public double getCarpetCost()
   {
      return carpetCost;
   }
   
   public double getTotalCost()
   {
      return size.getArea() * carpetCost;
   }
   
   public String toString()
   {     
      return "Total cost: " + getTotalCost();
   }
   
   
}