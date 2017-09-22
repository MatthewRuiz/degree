/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.util.*;
import java.io.File;

/**
 *
 * @author Matt
 */
public class Sorting {

    public static void main(String[] args) throws Exception {

        ArrayList<String> line = new ArrayList<>(238);
        readInArray(line);//read in .txt file
        shellSort(line);//Call shell sort method
            
        //display sorted countries by population
        for (String l : line) {
            System.out.println(l);
        }
    }   
    //Get the population and convert to int
    public static int getPopulation(ArrayList<String> a, int i) {
        String populationString = a.get(i).substring(50, 65).trim().replaceAll(",", "");
        //System.out.println(populationString);
        int pop = Integer.parseInt(populationString);
        //System.out.println(pop);
        return pop;
    }
    //read in .txt file
    public static void readInArray(ArrayList<String> line) throws Exception {
        Scanner keyboard = new Scanner(new File("/Users/Matt/Desktop/CountryUnsortedFormat.txt"));
        while (keyboard.hasNextLine()) {
            line.add(keyboard.nextLine());
        }
    }
    //Sort the .txt file using shell sort and store in a new ArrayList
    public static void shellSort(ArrayList<String> line){
        int j;
        for (int gap = line.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < line.size(); i++) {
                String hold = line.get(i);
                int population = getPopulation(line,i);
                for (j = i; (j >= gap) && getPopulation(line,j-gap)>population; j -= gap) {
                    line.set(j, line.get(j-gap));
                }
                line.set(j,hold);
            }
        }
    }
}
