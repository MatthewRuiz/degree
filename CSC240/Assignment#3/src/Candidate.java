/**
*  Candidate class
*  Matthew Ruiz
*/

import java.util.Scanner;
import java.util.StringTokenizer;
public class Candidate extends Element
{
   private String name;
   private String age;
   private String party;
   private String issueList;
   
    //Constructors
    
    /*
    * Default constructor
    */
   
   public Candidate()
   {
      name = "";
      age = "";
      party = "";
      issueList = "";
   }
   
   public Candidate(String name)
   {
      this.name = name;
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
   public Candidate(String name, String age, String party, String issues)
   {
      this.name = name.toUpperCase().trim();
      this.age = age;
      this.party = party.toUpperCase();
      issueList = issues;
   }
   
   /**
   *  Prompts the user to enter the information for a Candidate
   *
   *
   */
   public void readIn()
   {
      Scanner keyboard = new Scanner(System.in);
      int numOfIssues = 0;
      System.out.println("Candidate's name: ");
      this.name = keyboard.nextLine().toUpperCase().trim();
      
      System.out.println("Candidate's age: ");
      this.age = keyboard.nextLine();
      
      System.out.println("Candidate party: ");
      this.party = keyboard.nextLine().toUpperCase();
      
      System.out.println("How many important issues are there for " + name + "?");
      numOfIssues = Integer.parseInt(keyboard.nextLine());
      
      System.out.println("Enter issues when prompted!");
      
      for(int i = 0;i<numOfIssues;i++)
      {
         System.out.print("#" + (i+1) + ":");
         issueList = keyboard.nextLine().toUpperCase().trim() + ";";
      }
      
   }
	/**
	 * Displays information about a specific candidate.
	 * 
	 */ 
   public void display()
   {
      System.out.println("Name: " + this.name);
      System.out.println("Age: " + age);
      System.out.println("Party: " + party);
      System.out.println("Issues: ");
      String[] issues = this.issueList.split(";");
      for(String issue: issues)
         System.out.println(issue);
   }
   /*
   *  Determines if two Candidates are equal in name
   *  @param obj The candidate being used
   *  @return Return true if the two Candidates are equal
   */
   public boolean equals(Element obj)
   {
      return this.name.equals(((Candidate) obj).name);
   }
   /**
   *  Clones a Candidate object
   *  @return A clone of the Candidate
   */
   public Element clone()
   {
      Candidate candidate = new Candidate();
      
      candidate.name = name;
      candidate.age = age;
      candidate.party = party;
      candidate.issueList = issueList;
      
      return candidate;
   }
   
   //Getter and accessor methods
   public String getName()
   {
      return this.name;
   }
   
   public String getAge()
   {
      return this.age;
   }
   
   public String getParty()
   {
      return this.party;
   }
   
   public String getIssueList()
   {
      return issueList;
   }
    //Setter and mutator methods
    
   public void setName(String name)
   {
      this.name = name;
   }

   public void setAge(String age)
   {
      this.age = age;
   }
   
   public void setParty(String party)
   {
      this.party = party;
   }
   
   public void setIssueList(String issueList)
   {
      this.issueList = issueList;
   }
}