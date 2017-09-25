public class CharacterCounter
{
   public static void main(String[] args)
   {
      char[] array = {'b','c','b','r','b','r'};
   
      int x = 0;
      System.out.print(charCounter(array, x,'r'));
   }
     
   public static int charCounter(char[] array, int x, char c)
   {
      if(x == array.length)
         return 0;
      else if(array[x] == c)//adds 1 for each time the character is found. 
         return 1 + charCounter(array, x+1, c);
      else//moves to the next element of the array to check if above statement is true. 
         return charCounter(array, x+1, c);
   }
}