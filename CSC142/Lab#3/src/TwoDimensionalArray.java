public class TwoDimensionalArray
{
   public static void main(String[] args)
   {
      
      int[][] array = new int[][]  {{1, 2, 4, 5}, {6, 7, 8, 9}, 
                                   {10, 11, 12, 13}, {14, 15, 16, 17}};
   
      //Call and display getTotal method.
      System.out.println(getTotal(array));
      
      //Call and display getAverage method.
      System.out.println(getAverage(array));
      
      //Call getRowTotal method and displays total.
      for(int i=0;i<array.length;i++)
         System.out.println("Row " + i+1 + " total is: " + getRowTotal(array,i));
         
      //Call getColumnTotal method and displays total.
      for(int i=0;i<array.length;i++)
         System.out.println("Column " + i+1 + " total is: " + getColumnTotal(array,i));
         
      //Call getHighestIntRow method and display the highest in each row.   
      for(int i=0;i<array.length;i++)
         System.out.println("The higest number in row " + i+1 + " is: " + getHighestInRow(array,i));
         
      //Call getLowestInRow method and display the lowest in each row.
      for(int i=0;i<array.length;i++)
         System.out.println("The lowest number in row " + i+1 + " is: " + getLowestInRow(array,i));
   }
   
   public static int getTotal(int[][] a)
   {
      int total = 0;
      
       for (int[] a1 : a) {
           for (int col = 0; col<a.length; col++) {
               total += a1[col];
           }
       }
            
      return total;
   }
   
   public static int getAverage(int[][] a)
   {
      return getTotal(a) / (a.length * a.length);
   }
   
   public static int getRowTotal(int[][] a , int row)
   {
      int total = 0;
      
      for(int col=0;col<a.length;col++)
         total+=a[row][col];
         
      return total;
   }
   
   public static int getColumnTotal(int[][] a , int col)
   {
      int total = 0;
      
       for (int[] a1 : a) 
           total += a1[col];
         
      return total;
   }
   
   public static int getHighestInRow(int[][] a, int row)
   {
      int highest = a[row][0];
      
      for(int i=1;i<a.length;i++)
         if(highest<a[row][i])
            highest = a[row][i];
      
      return highest;
   }
   
   public static int getLowestInRow(int[][] a, int row)
   {
      int lowest = a[row][0];
      
      for(int i=1;i<a.length;i++)
         if(lowest>a[row][i])
            lowest = a[row][i];
      
      return lowest;
   }
}