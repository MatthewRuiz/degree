package candidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//MATTHEW RUIZ
//CSC 240
//FALL 2015
//ASSIGNMENT 1

public class Candidate 
{

    private String name;
    private String age;
    private String party;
    private String issueList;
    
    Scanner keyboard = new Scanner(System.in);
    
    //Constructors
    
    /*
    This candidate constructor had no arguments. It sets the name/age/party field to an empty string.
    */
    public Candidate()
    {
        name = "";
        age = "";
        party = "";
        issueList = "";
    }
    
    /*
    This candidate constructor initializes the Student fields to the values of the input paremeters canName, canAge, and canParty.
    @param canName Name that name will be set to
    @param canAge Age that age will be set to
    @param canParty Political party that party will be set to
    */
    public Candidate(String canName, String canAge, String canParty, String isList)
    {
        name = canName;
        age = canAge;
        party = canParty;
        issueList = isList;
    }
    
    public Candidate(String canName, String canParty, String canIssue)
    {
        name = canName;
        party = canParty;
        issueList = canIssue;
    }
    
    //Setter and mutator methods
    
    /*
    The setCandidateName method sets the name field to the value of the parameter, canName.
    Post: name is in uppercase
    @param canName Value that the name field will be set to
    */
    public void setCandidateName(String canName)
    {
            name = canName.toUpperCase();
    } 
        /*
    The setCandidateAge method sets the age field to the value of the parameter, canAge.
    Post:  age is in uppercase
    @param canAge Value that the age field will be set to
    */
    public void setCandidateAge(String canAge)
    {
            age = canAge.toUpperCase();
    }
        /*
    The setCandidateParty method sets the party field to the value of the parameter, canParty.
    Post: party is in uppercase
    @param canParty Value that the party field will be set to
    */
    public void setCandidateParty(String canParty)
    {
            party = canParty.toUpperCase();
    }
    /*
    The setIssueList method sets the issueList field to the value of the parameter, iList.
    Post: Issues are in is in uppercase
    @param iList Value that the issueList field will be set to
    */
    public void setIssueList(String iList)
    {
            issueList = iList.toUpperCase();
    }
    
    //Getter and accessor methods
    
    public String getCandidateName()
    {
            return name;
    }        
    
    public String getCandidateAge()
    {
            return age;
    }
    
    public String getCandidateParty()
    {
        return party;
    }     
    
    public String getIssueList()
    {
        return issueList;
    }
    
    /*
      The issueListTokenizer method will seperate the different issues that are in the issueList field.
      @param issueList The string that will be tokenized at each semi-colon(;)
    */
    public String issueListTokenizer(String issueList)
    {
        StringTokenizer st = new StringTokenizer(issueList, ";");//Will tokenize the string at each semi-colon(;)
        String tokenList = "";
        
        while (st.hasMoreTokens())
        {
            issueList = (st.nextToken());
            tokenList += issueList + "\n";
        }
        return tokenList;
    }
    
    /*
      The display method will display the information about a candidate when called upon.
    */
    public void display()
    {
        String candidateDisplay = ("AGE: " + age + "\nPARTY: " + party +
                                   "\nIMPORTANT ISSUES: \n " + issueListTokenizer(issueList)); 
        System.out.println(candidateDisplay);                          
    }


    /*
      The displayCandidateNames method uses an enhanced for loop that will store the candidate's names as it passes through the i array. It takes the data from the 
               paramster(candidateList) array.
      @param candidateList The array that contains the candidate's names
    */
    public void displayCandidateNames(ArrayList<Candidate> candidateList)
    {
        System.out.println("\nCandidate Names: ");
        
        candidateList.stream().forEach((i) -> {
            System.out.println("  " + i.getCandidateName());
        });
       
    }


   /*
      The searchCandidate method searches through the array of candidate names and displays the correct message if they were found or not.
      @param myCandidateList The array of candidate information that will be searched through
   */
     public static void searchCandidate(ArrayList<Candidate> myCandidateList)
     {
        Scanner keyboard = new Scanner(System.in);
        char response;
        
        String candidateSearch;
        int found;
        
        do
        {
         System.out.print("Enter the name of the candidate: ");
         candidateSearch = keyboard.nextLine().toUpperCase();
         
         found = binarySearch(myCandidateList, candidateSearch);//Calls the binarySearch method which will search through the myCandidateList array looking for
                                                                //the candidateSearch name
         if(found == -1)         
         {
            System.out.println("This candidate was not found!");
         }
         else
            myCandidateList.get(found).display();//Calls the display method if the candidate was found.
        
        
        System.out.println("\nDo you want to enter another candidate?\nYes\nNo");
        response = keyboard.nextLine().toUpperCase().charAt(0);
        }
        while(response == 'Y');
     }
    
    /*
      The displayPoliticalParty method will search through the candidates and display those who have an affiliation with the given party.
      @param candidateList The array of candidate information that will searched through to find who has a specific party affiliation.
    */
     public void displayPoliticalParty(ArrayList<Candidate> candidateList)
     {
         System.out.println("Enter the name of a political party: ");
         String pParty = keyboard.nextLine().toUpperCase();
         ArrayList<Candidate> results = new ArrayList<>();
         
         candidateList.stream().filter((c) -> (c.getCandidateParty().equals(pParty))//If the candidate belongs to the requested party, the candidate will be added to the results array.
         ).forEach((c) -> {
             results.add(c);
        });
                  
        if(results.size() > 0)
        {
            System.out.println("\n" + pParty + " contains these candidates: ");//Will display the correct candidates in order by last name
            results.stream().forEach((c) -> {
                System.out.println("   " + c.getCandidateName());
             });

        }
        else
            System.out.println(pParty + " does not seem to contain any candidates!");
     }
     /*
         The displayCandidateWithIssue will search through the array of candidate information and will display those who focus on a specific issue.
         @param candidateList The array of candidate information that will be searched through in order to find the candidates who have a specific issue.
     */
     public void displayCandidateWithIssue(ArrayList<Candidate> candidateList)
     {
        System.out.println("Enter an issue: ");
        String issue = keyboard.nextLine().toUpperCase();
        ArrayList<Candidate> results = new ArrayList<>();
                  
        candidateList.stream().filter((c) -> (c.getIssueList().contains(issue))//If the candidate has the requested issue then they will be added to the results array.
        ).forEach((c) -> {
            results.add(c);
        });
         
        if(results.size() > 0)
        {
            System.out.println("\nThese candidates have this issue " + issue + ": ");
            results.stream().forEach((c) -> {
                System.out.println("   " + c.getCandidateName());
            });
        }
        else
            System.out.println("No candidate has the issue of " + issue);
     }
    
    /*
         The binarySearch method will search through the array of candidates in order to find a specific candidate using binary search.
         @param myCandidateList The array that will be searched through.
         @param searchKey The name that will be searched for.
         @return Returns a location in the array where the candidate was found. Will give the appropriate information regarding that candidate when called upon.
    */
    public static int binarySearch(ArrayList<Candidate> myCandidateList, String searchKey)
    {
       int first = 0; 
       int last = myCandidateList.size();
       int middle;
       int whereFound = -1;

       boolean found = false;
       String middleString;

       while(!found && first <= last)
       {
          middle = (first+last) / 2;
          middleString = myCandidateList.get(middle).getCandidateName();

          if(middleString.equals(searchKey))
          {
             found = true;
             whereFound = middle;
          }
          else if (middleString.compareTo(searchKey) > 0)
             last = middle - 1;
          else
             first = middle + 1;
       }
       return whereFound; 
    }

    
}
