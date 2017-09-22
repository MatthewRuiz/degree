/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;
import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileReader;
/**
 *
 * @author Matt
 */
public class Hashing{
    public static void main(String[] args) throws Exception{
        Scanner kbd = new Scanner(System.in);
        //DEclare hashtable tof size 300 that stores an int as key and string as vale
        Hashtable table = new Hashtable<Integer, String>(300);
        //
        ArrayList<String> line = new ArrayList<String>(238);
        readInArray(line);//read in .txt 
        String findCountry;//Country user enters
        String country;

        
        //Add countries to hashtable using hashCode()%300
       for(int i=0;i<line.size();i++){
            country= line.get(i).substring(0,50).trim();
            table.put(Math.abs(country.hashCode())%300,line.get(i));
            //Display country/population and the key it is being stored at
            System.out.println("Key: " +Math.abs(country.hashCode())%300 +": \t " + line.get(i));
        }       
        //Propmt user to enter a country to find. Then looks for it in hashtable using hashCode()%300
        System.out.println("Please enter a country to look for: ");
        findCountry = kbd.nextLine();
        int cHash = Math.abs(findCountry.hashCode())%300;
        //Print out data for hastable
        System.out.println("Key: " + cHash + "\nCountry: " + table.get(cHash));
    
    }
    
    //Read in text file and store in ArrayList
    public static void readInArray(ArrayList<String> line) throws Exception {
            Scanner keyboard = new Scanner(new File("/Users/Matt/Desktop/CountryUnsortedFormat.txt"));
            while (keyboard.hasNextLine()) {
                line.add(keyboard.nextLine());
        }
    
}
}
