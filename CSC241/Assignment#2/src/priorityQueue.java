/*
* ASSIGNMENT2
* Priority Queue - see sample run in class * Use an array of 3 arrays of 6 items
* Row 0 is highest priority: items 100-199 * Row 1 is next priority: items 200-299
* Row 2 is lowest priority: items 300-399
* Each of the 3 arrays implements a queue
*/

import java.util.*;

public class priorityQueue {
private int[][] queueArray = new int[3][6]; //initialize size of matrix
private int[] front = new int[3];           //Determines where to dequeue
private int[] back = new int[3];            //Determines where to enqueue
private int[] count = new int[3];           //Determines if array/queue is full
private Random rand = new Random();
static Scanner keyboard = new Scanner(System.in);

/*
    Default constructor. Sets all values to 0
*/
public priorityQueue() //constructor 
{
    for(int i=0;i<front.length;i++)
    {
        front[i] = 0;
        back[i] = 0;
        count[i] = 0;
    }
    
}
/*
    Print out the queueArray
*/

public void printQueue() 
{ 
    for(int i=0;i<queueArray.length;i++)
    {
        for(int j=0;j<queueArray[0].length;j++)
        {
            System.out.print(queueArray[i][j] + " ");
        }
        System.out.println();
    }
    
            
}
/*
    The enqueue method adds a number into the queue.
    @item number added
    @return true if added and false if not
*/
public boolean enqueue(int item) 
{
    
    int queue = item / 100;//Used to determine what queue to add to
    boolean isTrue = false;//Will be set to true if the add was successful
        
    //Check if the matrix is full of numbers.
    if((count[0] == queueArray[0].length) && (count[1] == queueArray[1].length) && (count[2] == queueArray[2].length))
    {
        System.out.println("All of the queues are full. " + item + " will be thrown away!");
        return false; 
    }   
    if(queue == 1)//If number added is between 100-199
    { 
        if(count[0]!=6 && back[0] == 6)//Will cause the back[0] to move to front of array if there is still room
           back[0] = 0;
        if(count[0] == 0)//back[0] should be at the start if there are no numbers in array
           back[0] = 0;
      
      
        if(back[0] != 6 && count[0] != 6) //If there is still room to add on first array, add item
        {   
            queueArray[0][back[0]] = item;
            back[0]++; //incremented everytime we add a number
            count[0]++;//incremented everytime we add a number
        }
        else//If the first array if full, attempt store number in 2nd array
        {
         if(count[1]!=6 && back[1] == 6) // Will cause the back[1] to move to front of array if there is still room
            back[1] = 0;
            
            if(back[1] != 6 && count[1] != 6) //If there is still room to add on 2nd array, add item
            {
            queueArray[1][back[1]] = item;
            back[1]++; //incremented everytime we add a number
            count[1]++;//incremented everytime we add a number   
            }
            else //if both 1st and 2nd arrays are full, attempt to store in 3rd array.
            {
                queueArray[2][back[2]] = item;
                back[2]++; //incremented everytime we add a number
                count[2]++;//incremented everytime we add a number
            }
            
        }
        isTrue = true;//True if item was added
      
    }
    else if(queue == 2)//If number is between 200-299
    {
      if(count[1] != 6 && back[1] == 6)//Will cause the back[1] to move to front of array if there is still room
         back[1] = 0;
      if(count[1] == 0)//back[1] should be at the start if there are no numbers in array
         back[1] = 0;
        
        if(back[1] != 6 && count[1] != 6)//If there is still room to add on first array, add item
        {
            queueArray[1][back[1]] = item;
            back[1]++; //incremented everytime we add a number
            count[1]++;//incremented everytime we add a number
        }
        else //If the 2nd array is full, attempt to store in the 2rd array
        {
            if((count[1] == 6 && count[2] == 6))//If both 2nd and 3rd are full, display a message to user
            {
                System.out.println("Both the 2nd and 3rd queue is full. " + item + " will be thrown away.");
                return false;
            }
            if(back[2] != 6 && count[2] !=6) //Attempt to store in the 3rd array
            {
                queueArray[2][back[2]] = item;
                back[2]++; //incremented everytime we add a number
                count[2]++;//incremented everytime we add a number
            }
        }
        isTrue = true;//True if item was added
    }
    else if(queue == 3)//If number is between 300-399
    {  
       if(count[2] != 6 && back[2] == 6)//Will cause the back[2] to move to front of array if there is still room
         back[2] = 0;
       if(count[2] == 0)//back[1] should be at the start if there are no numbers in array
         back[2] = 0;
         
       if(count[2] == 6)//Checks if 2rd queue is full. Displays message to user if so
       {
         System.out.println("The 3rd queue is full. " + item + " will be thrown away.");
         return false;
       }
        if(back[2] != 6 && count[2] != 6)//Attempt to store in 3rd array
        {
           queueArray[2][back[2]] = item;
           back[2]++; //incremented everytime we add a number
           count[2]++;//incremented everytime we add a number
        }
        isTrue = true;//True if item was added
        
    }
    else
      System.out.println("You did not enter a valid number!");//The user did not enter a number between 100-399
    
    //returns true or false if all queues are full 
    //try lower priority queue(s) if necessary
    return isTrue;//True if number was added

    
}
/*
    The dequeue method takes out numbers that are in the array. The 1st array given the highest priority, the 2nd array is next and the 3rd is last.
    @return int Return the number that was removed
*/
public int dequeue()
{ 
/*
*Use random number generator to dequeue according to the following probabilities *queue 0 (highest priority): .50
*queue 1: .30
*queue 2 (lowest priority): .20
*if a queue is empty, go to the next highest queue
*if all queues are empty, return -1 */
    int num = rand.nextInt(10);//Generates number that determines which queue to dequeue from
    int removedNum = 0;
    if(num > 7)//If the 3rd array is set to dequeue but it is empty, the program moves to the 2nd array to dequeue
      if(count[2] == 0) 
         num = 6;
         
    if(num > 4 && num < 8)//If the 2nd array is set to dequeue but it is empty, the program moves to the 1st array to dequeue
      if(count[1] == 0)
         num = 3;
         
    if(num < 5)//If the number generated is 0,1,2,3,4 , then dequeue from first array
    {
        if(count[0] != 0 && front[0] == 6)//If there are still numbers to dequeue and front[0] is at end of array, move front[0] to beginning
            front[0] = 0;
        removedNum = queueArray[0][front[0]];
        queueArray[0][front[0]] = 0;//Set the current spot to 0
        if(front[0] == 0)
        {
            if(count[0]!=0)
            {
               count[0]--;//Decrement if there are still numbers left after dequeue
               front[0]++;//increment if there are still numbers left to dequeue
            }
            else
            {
               front[0] = 0; //Set to 0 if there are no numbers left in array
               back[0] = 0;  //Set to 0 if there are no numbers left in array
            }          
            
            return removedNum; //Return number that was removed
            
            
            
        }
        else//Checks if front[0] does not equal 0
        {
            if(back[0] != 6)//Checks if there are still spots to add
               if(queueArray[0][back[0]] != 0)//Checks if there is a number already in current back[0] position
                  if(back[0] != 0)  //Checks if back[0] equals 0
                     back[0] = front[0];//Set back[0] to front[0] only if it is the first one in array

            if(count[0]!=0)//Checks if there are still numbers in array 
            {
               count[0]--;//decrements if there are still numbers to dequeue
               front[0]++;//increments if there is still numbers left to dequeue
            }
            else//checks if count[0] is equal to 0
            {
               front[0] = 0;//Set to 0 if there are no numbers left in array
               back[0] = 0; //Set to 0 if there are no numbers left in array
            }
           
           return removedNum; //Return number that was removed
           
           
           
        }
    }
    else if(num > 4 && num < 8) //If the number generated is 5,6,7, then dequeue from second array
    {
        if(count[1]!=0 && front[1] == 6)//If there are still numbers to dequeue and front[1] is at the end of the array, move front[1] to beginning
            front[1] = 0;
        queueArray[1][front[1]] = 0;//Set current spot to 0
        if(front[1] == 0)
        {
            if(count[1] == 0)//If there are no numbers in 2nd array, back[0] is set to beginning
               back[1] = 0;
               
            if(count[1]!=0)
            {
               count[1]--;//Decrement if there are still numbers left after dequeue
               front[1]++;//increment if there are still numbers left to dequeue
            } 
            else
            {
               front[1] = 0;//Set to 0 if there are no numbers left in array
               back[1] = 0; //Set to 0 if there are no numbers left in array 
            }        
            
            return removedNum;   //Return number that was removed
        }
        else
        {
            if(back[1] != 6)//Checks if there are still spots to add
               if(queueArray[1][back[1]] != 0)//Checks if there is a number already in current back[1] position
                  if(back[1] != 0)  //Checks if back[1] equals 0
                     back[1] = front[1];//Set back[1] to front[1] only if it is the first one in array

            if(count[1]!=0)//Checks if there are still numbers in array 
            {
               count[1]--;//decrements if there are still numbers to dequeue
               front[1]++;//increments if there is still numbers left to dequeue 
            }
            else//checks if count[1] is equal to 0
            {
               front[1] = 0;//Set to 0 if there are no numbers left in array
               back[1] = 0; //Set to 0 if there are no numbers left in array
            }
           
           return removedNum; //Return number that was removed
        }
    }
    else 
    {
        if(count[2]!=0 && front[2] == 6)//If there are still numbers to dequeue and front[2] is at the end of the array, move front[1] to beginning
           front[2] = 0;
        queueArray[2][front[2]] = 0;//Set current spot to 0
        if(front[2] == 0)
        {
            if(count[2] == 0)
            {
               System.out.println("The third queue is already empty.");
               back[2] = 0;
            }
            if(count[2]!=0)
            {
               count[2]--;//Decrement if there are still numbers left after dequeue
               front[2]++;//increment if there are still numbers left to dequeue
            } 
            else
            {
               front[2] = 0;//Set to 0 if there are no numbers left in array
               back[2] = 0; //Set to 0 if there are no numbers left in array 
            }           
            
            return removedNum; //Return number that was removed
            
            
            
        }
        else 
        {
            if(back[2] != 6)//Checks if there are still spots to add
               if(queueArray[2][back[2]] != 0)//Checks if there is a number already in current back[2] position
                  if(back[2] != 0)  //Checks if back[2] equals 0
                     back[2] = front[2];//Set back[2] to front[2] only if it is the first one in array

            if(count[2]!=0)//Checks if there are still numbers in array 
            {
               count[2]--;//decrements if there are still numbers to dequeue
               front[2]++;//increments if there is still numbers left to dequeue  
            }
            else
            {
               front[2] = 0;//Set to 0 if there are no numbers left in array
               back[2] = 0; //Set to 0 if there are no numbers left in array
            }
           
           return removedNum; //Return number that was removed
        }
    }
}
public static void main(String[] args) 
{ 
    priorityQueue ln = new priorityQueue(); //Create new instance of priorityQueue
    boolean keepGoing = false;
    do
    {
        System.out.println("\nWhat do you want to do? \n'E' for enqueue.\n'D' for dequeue.\n-1 to exit.");
        char response = keyboard.nextLine().charAt(0);//Determine what user wants to do
    
        if(response == 'E' || response == 'e')
        {
            System.out.println("\nPlease enter a number between 100-299 to add to the queue: ");
            int number = Integer.parseInt(keyboard.nextLine());
            ln.enqueue(number);//Call the enqueue method. 
            ln.printQueue();//Print the matrix
            keepGoing = true;
        }
        else if ( response == 'D' || response == 'd')
        {
        
            ln.dequeue();//call dequeue method
            ln.printQueue();//rint matrix
            keepGoing = true;
        }
        else
        {
            System.out.println("You have ended the program by not chosing to \"Enqueue\" or \"Dequeue\".");
            keepGoing = false;
        }
    }while(keepGoing);
}
}//end class