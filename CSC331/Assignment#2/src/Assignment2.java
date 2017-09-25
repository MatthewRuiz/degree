////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//       NAME: Matthew Ruiz                                                   //
// ASSIGNMENT: CSC 331 Assignment2                                            //
//       DATE: 11/3/16                                                        //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////
package csc331_assignment2;

import java.util.Arrays;

public class Assignment2 {
    
   private static int[] w;
   private static int[] x;
   
  /**
    * Initializes array to 1s
    * Step 1
    */
  private static class Initialize implements Runnable{

       private final int N = 1; 
       private final int index;
       
       public Initialize(int i){ 
           this.index = i;
       }
       @Override
       public void run(){ //will set the current array element to 1(Step 1)
          w[index] = this.N;
       }
        
   }
      
   /**
    * Compares the two elements of the array
    * Stores a 0 into new array in lower number's place.
    */ 
   private static class Max implements Runnable{
       
       private final int X,Y;
       
       public Max(int X, int Y){
           this.X = X;
           this.Y = Y;
       }
      @Override 
      public void run(){
          int num1 = x[X];
          int num2 = x[Y];
          int low;
          if((Integer.compare(num1,num2)) < 0){//compare two numbers
              w[X] = 0;
              low = X;
          }else{
              w[Y] = 0;
              low = Y;
          }
          
          System.out.printf("Thread t(%d,%d) compares x[%1$d] = %d and x[%2$d] = %d, and writes 0 into w[%d]\n",X,Y,num1,num2,low);//print comparison record
          
      } 
      
   }
   /**
    * Displays the location of the largest number and it's value.
    */
   private static class DisplayMax implements Runnable{
       
       private final int INDEX;
       public DisplayMax(int index){
           this.INDEX = index;
       }
       @Override
       public void run(){
           if(w[INDEX] == 1){
               int max = x[INDEX];
               System.out.println("--------------------------------------------------------------------");
               System.out.printf("%-26s%s\n","Maximum ", + max);
               System.out.println("--------------------------------------------------------------------");
               System.out.printf("%-26s%s\n","Location ", INDEX);
           }
       }
   }  
   
   public static void main(String[] args) throws InterruptedException{
       
       if(args.length == 0){//check if any pre arguments were supplied
           System.out.println("Please enter some arguments.");
           return;
       }
       
       int size = Integer.parseInt(args[0]);//get arg values
       
       x = new int[size]; 
       for(int i=0;i<size;i++)//parse args as strings into array
           x[i] = Integer.parseInt(args[i+1]);
       
       w = new int[size];
       for(int i=0;i<size;i++){//initialize all elements in w with a 1. All elements get individual thread
            Thread t = new Thread(new Initialize(i));
            t.start();
       }
       
       System.out.printf("%-25s%s\n","Number of input values ", size);
       System.out.println("--------------------------------------------------------------------");
       String input = Arrays.toString(x);
       System.out.printf("%-25s%s\n","Input values"," x = " + input);
       System.out.println("--------------------------------------------------------------------");
       String afterInit = Arrays.toString(w);
       System.out.printf("%-25s%s\n","After initialization"," w = " + afterInit);
       System.out.println("--------------------------------------------------------------------");
       Thread.sleep(2000); //Slight sleep to thread to show that step 2 will wait for step 1 to execute before starting.
       
       //Compare integers
       
       int inc = 1;
       for( int i=0;i<size;i++){
           for(int j=inc;j<size;j++){
               Thread t = new Thread(new Max(i,j));
               t.start();
           }
           inc++;
       }
       
       Thread.sleep(2000); //Slight sleep to thread to show that step 3 will wait for step 2 to execute before starting.
       String max = Arrays.toString(w);
       System.out.println("--------------------------------------------------------------------");
       System.out.printf("%-25s%s\n","After Step 2"," w = " + max);
       
       //Calls DisplayMax(i) which will look for the element that is represented by 1 and return value and location
       for(int i=0;i<size;i++){
           Thread t = new Thread(new DisplayMax(i));
           t.start();
       }
   }

}


