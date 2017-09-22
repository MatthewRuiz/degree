import java.util.Scanner;
import java.text.DecimalFormat;

public class RecursiveMethod
{
   public static void main(String[] args)
   {
   
      DecimalFormat formatter = new DecimalFormat("0.0000");
      
      System.out.println("i\t  m(i)\n------------------");
      
      for(int i=1;i<=20;i++)
         System.out.println(i + "\t  "+formatter.format(returnMath(i)));
   }
   
   public static double returnMath(double i)
   {
      if(i == 0)
         return 0;
      else
         return (i/(i+1)) + returnMath(i-1);
   }
}