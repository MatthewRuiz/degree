import java.util.Scanner;

public class CarpetCalcTest
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      //RoomDimension roomD = new RoomDimension();
      
      double length, width, area, cost;
      
      System.out.print("Please enter the the length of the room: ");
      length = keyboard.nextDouble();
      
      System.out.print("Please enter the width of the room: ");
      width = keyboard.nextDouble();
      
      System.out.print("Please enter the the cost per square foot: ");
      cost = keyboard.nextDouble();
      //Close keyboard -- Needed after keyboard.nextDouble();
      keyboard.close();
      
      RoomDimension roomD = new RoomDimension(width,length);
      RoomCarpet roomC = new RoomCarpet(roomD,cost);
      
      roomC.setCarpetCost(cost);
      System.out.println(roomC);
      
      
      
      
   }
}