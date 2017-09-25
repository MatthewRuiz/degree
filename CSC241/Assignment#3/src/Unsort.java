/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Unsort{

    public static void main(String[] args) throws Exception{
        
        PrintWriter out = new PrintWriter("/Users/Matt/Desktop/CountryUnsortedFormat.txt");
        ArrayList<String> line = new ArrayList<String>(238);
        readInArray(line);//read in .txt file
        
        //Used to randomize the arrayList. Uses Fisher-Yates. 
        //We spoke via email about using this method.
        Collections.shuffle(line);
        
        //write shuffled countries to .txt file
        for(int i=0;i<line.size();i++)
           out.println(line.get(i));
    
        out.close();

    }
 
    //read in .txt file and store in ArrayList
public static void readInArray(ArrayList<String> line) throws Exception {
            Scanner keyboard = new Scanner(new File("/Users/Matt/Desktop/CountrySortedFormat.txt"));
            while (keyboard.hasNextLine()) {
                line.add(keyboard.nextLine());
        }
    }
}
