import java.util.Scanner; //Needed for the Scanner class

public class MergeLists
{
   public static void main(String[] args)
   {
      int list1Size, list2Size;
      Scanner keyboard = new Scanner(System.in);
     
      //Get the sorted elements of the first array
      System.out.print("Please enter the size of list1 followed by the sorted elements in list1: ");
      list1Size = keyboard.nextInt();
      int[] list1 = new int[list1Size];
      
      for(int i = 0; i < list1Size; i++)
      {
         list1[i] = keyboard.nextInt();
      }
   
      //Get the soreted elements of the second array
      System.out.print("\nPlease enter the size of list2 followed by the sorted elements in list1: ");
      list2Size = keyboard.nextInt();
      int[] list2 = new int[list2Size];
     
      for(int i = 0; i < list2Size; i++)
      {
         list2[i] = keyboard.nextInt();
      }
   
      //Make the lentgh of list3 equal to that of list1 and list2 combined
      int[] list3 = new int[list1Size + list2Size];
      int newList = list1Size + list2Size;
      
      //Call the merge method
      merge(list1, list2, list3);
      
      //Print the first array
      System.out.print("List1: " + list1Size + " ");
      for( int i = 0; i < list1.length;i++)
      {
         System.out.print(list1[i] + " ");
      }
      //Print the second array
      System.out.print("\nList2: " + list2Size + " ");
      for( int i = 0; i < list2.length;i++)
      {
         System.out.print(list2[i] + " ");
      }
      //Print the new merged array
      System.out.print("\nThe merged list is ");
      for(int i = 0; i < newList; i++)
      {
         System.out.print(list3[i] + " ");
      }
     
   }//end main
   
   /** The merge method takes the sorted elements of two arrays and then properly assigns them to a third array
     @param a The first array being merged
     @param b The second array being merged
     @param c The new array that will contain both arrays
   */
   
   public static void merge(int []a, int []b, int[] c)
   {
      int indexA = 0,indexB = 0, indexC = 0;
      int sizeA = a.length;
      int sizeB = b.length;
            
           // Runs until neither array is empty
      while(indexA < sizeA && indexB < sizeB)
      {
            // Compare the items of two arrays and copy the smaller item into to third array
         if(a[indexA] < b[indexB])
         {
            c[indexC++] = a[indexA++];
         }
         else{
            c[indexC++] = b[indexB++];
         }
      }
            
           // If array B's index scanned and compared all the items of the array
           // but array A's is not
      while(indexA < sizeA)
      {
         c[indexC++] = a[indexA++];
      }
            
           // If array A's index scanned and compared all the items of the array
           // but array B's is not
      while(indexB < indexB)
      {
         c[indexC++] = b[indexB++];
      }
   }
  
}