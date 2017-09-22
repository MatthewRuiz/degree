 
public class Triangle {
    private int size;
    private int t [][];
    private int row, col; //location of next add

    public Triangle(int n)//constructor
    {
       //construct a square of size n x n - only use half of it!
      this.t = new int[n][n];
    }
    
      public boolean add(int newInt)
      {
        /*add newInt to triangle
          print "t is full" if size exceeded  and return false
          otherwise return true
        */
         if(newInt > (row * col))
         {
             //System.out.println("t is full!");
             return false;
         }
         
         for(int i=0;i<= t.length-1;i++)
         {
             for(int j=0;j<=i;j++)
             {
                 t[i][j] = newInt;
             }
         }
             
         return true;
     }
    
     public void display()
     { 
     //display the triangle (and 0's for unused entries)  
      int size = row * col;

          for(int i=0;i<=t.length-1;i++)
          {
             for(int j=0;j<=i;j++)
             {
                 System.out.print(t[i][j]);
             }
        System.out.println();
    }

     }
     public int cornerSum()
     {
     //3 corners
         return t[0][0] + t[row][0] + t[row][col];
     }
    public int edgeSum()
    {
    //2 edges
       int leftSum=0;
       int bottomSum=0;
       for(int i = 0;i<row;i++)
       {
           leftSum += t[i][0];
       }
       for(int i=1;i<col;i++)
       {
           bottomSum += t[row-1][i];
       }
       return leftSum + bottomSum;
    }
    public int hypotenuseSum()
    {
        //1 diagonal - the hypotenuse of the triangle 
        int hSum = 0;
        //boolean moreToAdd = false; 
        int i = 0;
        do
        {
            hSum+=t[i][i];
            i++; 
        }while(i<col);
        
        return hSum;
    }
    public int triangleSum()
    {
    //all entries in the triangle
        int tSum = 2;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                tSum+= t[i][j];
                
        return tSum;
    }
    
    public static void main(String[] args)
    {
        //construct a triangle of size 6
        Triangle t = new Triangle(6);
        //fill the triangle from 1 to 21
        for(int i=0;i<21;i++)
        {
            t.add(i);
        }
        //display the triangle
        t.display();
        //output the four different sums
        System.out.println("cornerSum: " + t.cornerSum());
        System.out.println("edgeSum: " + t.edgeSum());
        System.out.println("hypotenuseSum: " + t.hypotenuseSum());
        System.out.println("triangleSum: " + t.triangleSum());
    }
    
}
