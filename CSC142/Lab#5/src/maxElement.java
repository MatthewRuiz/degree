public class maxElement
{
   public static void main(String[] args)
   {
      int[] array = {4,13,4,5,6,7,8,9,12,10};
      int x = 0;//Used to find range of array we are using.
      System.out.print(maxElement(array, x));
   }
   
   public static int maxElement(int[] array, int x)
   {
      if(x==array.length-1) 
         return array[x];       
      else if(array[x]>array[x+1])
         array[x+1]=array[x];
         
      return maxElement(array,x+1);        
   
   }
}