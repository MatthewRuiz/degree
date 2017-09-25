/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;
/**
 *
 * @author Matt
 */
public class Assignment3 
{
   class Unsort 
{
    public void main(String[] args) throws Exception
    {
        Random rand = new Random();
   
        Scanner keyboard = new Scanner(new File("/Users/Matt/Desktop/CountrySortedFormat.txt"));
        PrintWriter out = new PrintWriter("/Users/Matt/Desktop/CountryUnsortedFormat.txt");
 
        ArrayList<String> line = new ArrayList<String>();
 
        while(keyboard.hasNextLine())
        {
            line.add(keyboard.nextLine());
        }
        //Used to randomize the arrayList. Uses Fisher-Yates. 
        //We spoke via email about using this method.
        Collections.shuffle(line);
    
        for(int i=0;i<line.size();i++)
           out.println(line.get(i));
    
        out.close();

    }
} 
    
}
