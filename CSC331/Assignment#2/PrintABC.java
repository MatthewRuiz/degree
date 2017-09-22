////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//       NAME: Matthew Ruiz                                                   //
// ASSIGNMENT: CSC 331 Assignment2                                            //
//       DATE: 11/3/16                                                        //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////
package csc331_assignment2;

public class PrintABC {
   
   //used to determin which thread should be executing
   int status = 1;
    
   /**First thread that determines if status is 1. 
    * If so, prints "A " and increases status by 1.
    * Gives access to BThread to execute.
    */
   private static class AThread implements Runnable{
       
       PrintABC printABC; //instance of PrintABC class
       
       AThread(PrintABC printABC){
           this.printABC = printABC;
       }
       
       public void run(){
           
               synchronized(printABC){            //used to ensure that the invoked synchronized method  
                   for(int i=0;i<10;i++){         //wait until current thread is finished with the object
                       try{             
                            while(printABC.status != 1)
                                this.printABC.wait();
                       }catch(InterruptedException interruptedException){}
                       
                       System.out.print("A ");
                       printABC.status = 2; //give access to BThread.
                       printABC.notifyAll();//used once the task is finished so all waiting threads can continue
                   }
               }
       }
   } 
   /**Second thread that determines if status is 2. 
    * If so, prints "B " and increases status by 1.
    * Gives access to CThread to execute.
    */
   private static class BThread implements Runnable{
       
       PrintABC printABC;//instance of PrintABC class
       
       BThread(PrintABC printABC){
           this.printABC = printABC;
       }
       
       public void run(){  
            synchronized(printABC){
                for(int i=0;i<10;i++){//repeat 10 times
                    try{
                        while(printABC.status != 2)
                            this.printABC.wait(); 
                    }catch(InterruptedException interruptedException){}
                    
                    System.out.print("B ");
                    printABC.status = 3; //give access back to AThread
                    printABC.notifyAll();//used once the task is finished so all waiting threads can continue
                }
            }
       }
   }
   
   /**Third thread that determines if status is 3. 
    * If so, prints "C " and sets status back to 1.
    * Gives access to BThread to execute.
    */
   private static class CThread implements Runnable{
       
       PrintABC printABC;//instance of PrintABC class
       
       CThread(PrintABC printABC){
           this.printABC = printABC;
       }
       
       public void run(){
           synchronized(printABC){
               for(int i=0;i<10;i++){ //repeat 10 times
                   try{
                       while(printABC.status != 3)
                           this.printABC.wait();
                   }catch(InterruptedException interruptedException){}
                   
                   System.out.print("C ");
                   printABC.status = 1;
                   printABC.notifyAll();
               }
           }
       }   
   }
   
   public static void main(String[] args) throws InterruptedException{
       
       PrintABC printABC = new PrintABC(); //instance of PrintABC class
       
       Thread a = new Thread(new AThread(printABC));
       Thread b = new Thread(new BThread(printABC));
       Thread c = new Thread(new CThread(printABC));
       
       a.start();
       b.start();
       c.start();
   }
   
   
   
   
}
