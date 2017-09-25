package candidate;

import java.util.Scanner;
import java.util.ArrayList;

//MATTHEW RUIZ
//CSC 240
//FALL 2015
//ASSIGNMENT 1

public class CandidateMain
{
    private static Scanner keyboard = new Scanner(System.in);
    private static Candidate candidate = new Candidate();
    private static ArrayList<Candidate> myCandidateList = new ArrayList<>();
    private static ArrayList<Candidate> candidateListTwo;
       
    public static void main(String[] args)
    {      
        do
        { 
         
            System.out.print("Candidate's name(LAST, FIRST): ");
            String name = keyboard.nextLine().toUpperCase();
            System.out.print("Candidate's age: ");
            String age = keyboard.nextLine();
            System.out.print("Candidate's Political Party:");
            String party = keyboard.nextLine().toUpperCase();
            System.out.print("NUMBER OF IMPORTANT ISSUES FOR THIS CANDIDATE? ");
            int numberOfIssues = keyboard.nextInt();

            keyboard.nextLine();


            System.out.print("Enter the issues when prompted: \n");
            String issues = "";
        
            for(int i = 0; i < numberOfIssues; i++)
            {
                System.out.print((i+1) + ") ");
                issues += keyboard.nextLine();
                if(i != numberOfIssues-1)
                   issues += "; ";
            }
            //Adds the information of the current candidate to the myCandidateList array.
            myCandidateList.add(new Candidate(name.toUpperCase() , age.toUpperCase(), 
                               party.toUpperCase(), issues.toUpperCase()));
        }
        while(!getQuit());

        //Sets the size of the new array candidateListTwo
        candidateListTwo = new ArrayList<Candidate>(myCandidateList.size());
        
        //Enhanced for loop that will store the information from the myCandidateList array into the i array.
        for(Candidate i: myCandidateList)
            candidateListTwo.add(i);
        
        //Calls the sort method which will bubble sort the candidate's last names.
        candidateListTwo = sort(candidateListTwo);
        //Calls the candidateMenu method which will display the correct menu options to the user.
        candidateMenu();
    }
    
    /*
      The getQuit method will determine if the user wants to quit the current step or the entire program. If the user enters yes then they will be
            asked if they are sure that they want to quit. Unless it is after they have entered the issues for a candidate in which it would then proceed
            to display the candidateMenu.
    */
    private static boolean getQuit()
    {
      System.out.println("Do you want to quit?\nYes\nNo");
        return keyboard.nextLine().toUpperCase().charAt(0) != 'N';
    }
    /*
      Diplays the menu to the user and then after determining what option was chosen will call the appropriate method in the Candidate class 
         to perform the correct action.
    */
    public static void candidateMenu()
    {
        char userInput;
        boolean isValid = false;
        boolean wantsToQuit = false;
        
        Scanner keyboard = new Scanner(System.in);
        //Stores ths menu options in an array of Strings which will then be displayed appropriately through the following for loop.
        String [] menu = {"Display the names of all of the candidates.","Display all data for a specific candidate.",
                        "Display the names of the candidates that belong to a particular party.",
                        "Display the names of candidates who are focused on a particular issue.","Quit the program."};
                              
        do
        {
            System.out.println("\n\nPRESIDENTIAL CANDIDATE TRACKING SYSTEM DATA MENU");
            for (int i = 0; i < 5; i++)
                System.out.println((i+1) + ") " + menu[i]);
            
            System.out.println("Please enter a menu choice (1-5): ");
            userInput = keyboard.nextLine().charAt(0);
            
            if(userInput <= '5' && userInput >= '1')
                isValid = true;
            else
                System.out.println("Invalid choice. Please enter a number (1-5): ");
        }
        while(!isValid);
        
        switch(userInput)
        {
            case '1':
                candidate.displayCandidateNames(candidateListTwo);
                break;
            case '2':
                candidate.searchCandidate(candidateListTwo);
                break;
            case '3':
                candidate.displayPoliticalParty(candidateListTwo);
                break;
            case '4':
                candidate.displayCandidateWithIssue(candidateListTwo);
                break;
            default:
                break;      
        }
        //Checks to see whether the user has prompted the program to quit. If not then it displays the menu again.
        if(!wantsToQuit && userInput != '5')
            candidateMenu();
        else 
        {
            wantsToQuit = getQuit();
            
            if(!wantsToQuit)
                candidateMenu();
        }  
       
        
    }
    
    /*
      The sort array takes in an array that will be sorted by last name.
      @param list The array of candidate names that will be sorted using bubble sort.
      @return Will return the sorted arrayList of candidate names.
    */
    private static ArrayList<Candidate> sort(ArrayList<Candidate> list)
    {
        int num = list.size();
        
        do
        {
            int newNum = 0;
            for(int i = 1; i <= num-1; i++)
            {
                String stringA = list.get(i-1).getCandidateName();
                String stringB = list.get(i).getCandidateName();
                
                if(stringA.compareTo(stringB) > 0)
                {
                    Candidate temp = list.get(i);
                    list.set(i, list.get(i-1));
                    list.set(i-1,temp);
                    newNum = i;
                }
            }
                    num = newNum;
        }
        while(num != 0);
        return list;
    }

}
