package FinalExam;
 
public class FinalExam {

/* Three-way heap and heapsort
 * Date supplied in array declaration
 * Children of parent i are 3i-1, 3i, and 3i+1
 * Parent of child j is (j+1)/3
*/
  
  private int size;
  private int [] data;
  
  
  public FinalExam(){
      data = new int[14];
      size = 0;
  }
  //check if empty
  public boolean isEmpty() { return size == 0; }
 
  //display
  public void display(){
  // display the data in the array - this is a method for the class
      for(int i=1;i<data.length;i++){
          if(data[i] != 0)
            System.out.print(data[i] + " ");         
      }     
      System.out.println();
  }  
  /*
    add number to heap in correct spot
    param n number to be added
  */ 
  public boolean add(int elt) {
  // use percolateUp and display
      int capacity = data.length-1;//Set capacity to amount of numbers in array-1
      
      //check if the array is full. If so, increase size 
      if(size==capacity){
          size = data.length*2+1;
      }
      
      int h = percolateUp(++size, elt);//call the percolateUp method. Incrementing size before calling
      
      data[h] = elt;//store number entered into appropriate spot
      display();//display the heap as is
  
      return true;
  }
 
  /*
    percolateUp will store elt in the appropriate spot. Checking if the format is correct i.e small numbers to the top
    param hole spot that added number will go
    param elt number to be compared
  */
  private int percolateUp(int hole, int elt) {
  // code for three-way heap
  
      //check if first addition or if the apropriate element is in the wrong position
      while(hole > 1 && data[(hole+1)/3] > elt){
          data[hole] = data[(hole+1)/3];
          hole = (hole+1)/3;
      }
              
      return hole;
  }
 
  /*
    percolateDown will take out the smallest number, i.e. root, and then configure remaining heap so that it is structuraly correct and formatted correctly.
    param hole spot that must be filled
    param elt number to be compared
  */
  private int percolateDown(int hole, int elt) {
  // code for three-way heap
    
      while(true){
          int left = hole*3-1;//left child
          int mid = hole*3;//middle child
          int right = hole*3+1;//right child
          int child;
          
          if(left > size){//left is too big and therefore we reached the bottom of tree
              break;
          }
          
          //if left is only element left, set to child
          if(left==size)
              child = left;
          else if(data[left]<data[mid] && data[left]<data[right])
              child = left;
          else if(data[mid]<data[right])
              child = mid;
          else
              child = right;
          
          if(data[child] > elt)
              break;
          else{
             data[hole] = data[child]; 
             hole = child;
          }  
      }
        
      return hole;
  }
   /*
    remove removeMin is performed. Calling the percolateDown method and returning the number that is the smallest.
  */ 
  public int remove() {
   // use percolateDown and display
      
    //Check if heap is empty  
    if(size==0)
        System.out.println("There are no elements in the array. Heap is empty!");
         
    int top = data[1];//Number to be removed
    int n =  data[size--];//Number at the end of the heap that must be relocated
    int hole = percolateDown(1,n);//Calls percolateDown method to find where n should go
    data[hole] = n;//store n in the hole
    
    //print heap as removed
    for(int i=1;i<size+1;i++){
        System.out.print(data[i] + " ");
    }
    System.out.println();
    
    return top;
  }
    /*
    Display the array and it's contents
   */
    public static void display(int [] array){
    // display the array parameter used by main 
        for(int i=0;i<array.length;i++)
            System.out.print(array[i] + " ");
    }
    
    public static void main(String[] args) throws Exception {
    // main program goes here 
       int []A ={13,33,11,27,99,22,45,15,21,10,88,77,25};   
       FinalExam f = new FinalExam();
       int[] B = new int[A.length]; 
       
       //Print out array entered in before heap
       System.out.println("Array:");
       display(A);
       
       System.out.println();
       //Print out heap as new numbers are entered
       System.out.println("========================================");
       System.out.println("Add to Heap:");
       for(int i=0;i<A.length;i++)
           f.add(A[i]);
       
        //Print out heap as numbers are removed
        System.out.println("=======================================");
        System.out.println("Remove from Heap:");
        for (int i = 0; i < A.length; i++) {
            B[i] = f.remove();
        }
        
        System.out.println("Array:");
        
        display(B);
    }
}
