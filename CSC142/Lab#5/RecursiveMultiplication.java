public class RecursiveMultiplication
{
   public static void main(String[] args)
   {
      int one = multiply(4,5);
      System.out.print(one);
   }
   
   public static int multiply(int x, int y)
   {
      if(x==0)
         return 0;
      else
         return y + multiply(x-1, y);
   }
}