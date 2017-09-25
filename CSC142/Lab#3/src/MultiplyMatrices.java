public class MultiplyMatrices
{
   public static void main(String[] args)
   {
      int[][] a = new int[][] {{2,3,4} , {5,6,7},
                                    {8,9,10}};
      int[][] b = new int[][] {{10,9,8} , {7,6,5},
                                    {4,3,2}};       
      int[][] c = multiply(a,b);
      int listCSize = a.length + b.length;
      
    
      System.out.println("Product of A and B is");
      for (int i = 0; i < c.length; i++) {
         for (int j = 0; j < c[0].length; j++) {
            System.out.print(c[i][j] + " ");
         }
         System.out.println();
      }                                               
   }//end main
  
   public static int[][] multiply(int[][] a, int[][] b)
   {
      int rowsInA = a.length;
      int columnsInA = a[0].length; // same as rows in B
      int columnsInB = b[0].length;
      int[][] c = new int[rowsInA][columnsInB];
       
      for (int i = 0; i < rowsInA; i++) 
         for (int j = 0; j < columnsInB; j++) 
            for (int k = 0; k < columnsInA; k++) 
               c[i][j] = c[i][j] + a[i][k] * b[k][j];

      return c;
   }
   
   
}