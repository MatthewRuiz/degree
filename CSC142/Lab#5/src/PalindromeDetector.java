public class PalindromeDetector
{
   public static void main(String[] args)
   {
      System.out.print(isPalindrome("aaffaa"));
   }
   
   public static boolean isPalindrome(String word)
   {
      if(word.length() <= 1)
         return true;//Checks if the first and last element are equal up until there is 1 element left. If not, returns false.
      else if(word.charAt(0) == word.charAt(word.length() - 1))
         return isPalindrome(word.substring(1, word.length() - 1));
         
      return false;
   }
}