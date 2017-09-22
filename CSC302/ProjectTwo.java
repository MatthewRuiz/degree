/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc302proj2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class ProjectTwo {
   public static void main(String[] args){ 
       
       Scanner keyboard = new Scanner(System.in);
       
       int p;            // First prime number.
       int q;            // Second prime number.
       int n;            // n = p * q
       int z;            // z 
       int e;            // Co-prime to z
       int d;            // A number which would make, (d*e)mod(n) = 1, true.
       int m;            // Plaintext message.
       BigDecimal c;     // Encrypted ciphertext.    
       
       // Display the public key.
       System.out.println("Public key is (n=" + n + ",e=" + e + ").");
       // Display the private key.
       System.out.println("Private key is (n=" + n + ",d=" + d + ").");
       
       // Display the equation used to encrypt the plaintext message m.
       System.out.println("For plaintext message m, the encryption "
               + " is c(m) = (m^e)mod(n) = (m^" + e + ")mod(" + n + ").");
       
       BigDecimal bigDecN = new BigDecimal(n);                      // Translate n into a BigDecimal.
       BigInteger bigIntM = new BigInteger(String.valueOf(m));      // Translate m into a BigInteger.
       BigDecimal bigDecCPow = new BigDecimal(bigIntM.pow(e));      // Translate the result of bigIntM^e into a BigDecimal.
       c = bigDecCPow.remainder(bigDecN);                           // Set c to the result of bigDecCPow % bigDecN.
                 
       System.out.println("c = " + c);                              // Display the value of the cypher
      
       // Display the equation used to decrypt the ecrypted ciphertext c.
       System.out.println("For encrypted ciphertext c, the decryption "
               + " is m(c) = (c^d)mod(n) = (c^" + d + ")mod(" + n + ").");

       BigInteger bigIntC = new BigInteger(c.toString());           // Translate c into a BigInteger.
       BigDecimal bigDecMPow = new BigDecimal(bigIntC.pow(d));      // Translate the result of bigIntC^d into a BigDecimal.
       BigDecimal bigDecM = bigDecMPow.remainder(bigDecN);          // Set bigDecM to the result of bigDecMPow % bigDecN.
     
       System.out.println("m = " + bigDecM);
}
     /**
   *    Get the modInverse.
   *    @param e phi(n).
   *    @param mod Number to mod of e.
   *    @return d The number which makes '(d*e)mod(n)' true.
   */
   static int modInverse(int e, int mod){
      for(int d=1; true; d++)
         if((d*e)%mod == 1)
            return d;
   }
   
   /**
   *    Check if a number is prime
   *    @param n The number to check.
   *    @return True if prime, false if not.
   */
   static boolean isPrime(int n) {
      // Check if n is a multiple of 2.
      if (n%2 == 0) {
         // Display unsatisfied feedback.
         System.out.println(n + " is divisible by 2 and is therefore not prime. ");
         return false;
      }
         
      // Check the odds.
      for(int i=3; i*i<=n; i+=2) {
         if(n%i == 0){
            System.out.println(n + " is divisible by " + i + " and is therefore not prime. ");
            return false;
         }
      }
      return true;
   }
   
   /**
   *    Check if e is co-prime to z.
   *    @param e The number to check if it is co-prime to z.
   *    @param z The number e is being checked to.
   *    @return True if co-prime, false if not.
   */
   static boolean coPrime(int e, int z){
      if(z%e == 0){
         System.out.println(z + " is divisible by " + e + ".");
         return false;
      }
      return true;
   }
   
   /**
   *    Get the greatest common divisor(GCD) for two numbers.
   *    @param a The first number.
   *    @param b The second number.
   *    @return The GCD of the two numbers.
   */
   private static int gcd(int a, int b){
        while (b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
   }
   
   /**
   *    Get the least common multiple(LCM) for two numbers.
   *    @param a The first number.
   *    @param b The second number.
   *    @return The LCM of the two numbers.
   */
   static int lcm(int a, int b){
        return a * (b / gcd(a, b));
   }
}
