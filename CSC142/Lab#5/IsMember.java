public class IsMember
{
   public static void main (String[] args)
   {
      int[] array = {2,3,4,5,6,7};
      
      if(isMember(array, 0, array.length) == true)
         System.out.print("It is a member.");
      else
         System.out.print("It is not a member.");
      
   }
   
   public static boolean isMember(int[] array, int value, int size)
   {
      boolean status ;
      
      if(size == 0)
         return false;
      else if (array[size - 1] == value)
         return true;
      else 
         return isMember(array, value, size - 1);
         

         
   }
}