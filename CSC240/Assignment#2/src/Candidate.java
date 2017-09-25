import java.util.Scanner;
import java.util.StringTokenizer;

public class Candidate extends Element
{
   private String name;
   private String age;
   private String party;
   private String issueList;
    
   Scanner keyboard = new Scanner(System.in);
    
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
   public Candidate(String canName, String canAge, String canParty, String isList)
   {
      canName = name;
      canAge = age;
      canParty = party;
      isList = issueList;
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
   public void setName(String canName)
   {
      name = canName.toUpperCase();
   } 
        /*
    The setCandidateAge method sets the age field to the value of the parameter, canAge.
    Post:  age is in uppercase
    @param canAge Value that the age field will be set to
    */
   public void setAge(String canAge)
   {
      age = canAge.toUpperCase();
   }
        /*
    The setCandidateParty method sets the party field to the value of the parameter, canParty.
    Post: party is in uppercase
    @param canParty Value that the party field will be set to
    */
   public void setParty(String canParty)
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
    
   public String getName()
   {
      return name;
   }        
    
   public String getAge()
   {
      return age;
   }
    
   public String getParty()
   {
      return party;
   }     
    
   public String getIssueList()
   {
      return this.issueList;
   }
   
   /**
   *  Prompts the user to enter the information for a Candidate
   *
   *
   */

	public void readIn() 
   {
		int numIssues;
      
		System.out.print("Candidates name: ");
		this.name = keyboard.nextLine().toUpperCase().trim();
      
		System.out.print("Candidates age: ");
		this.age = keyboard.nextLine().toUpperCase();
      
		System.out.print("Candidates party: ");
		this.party = keyboard.nextLine().toUpperCase();
      
		System.out.print("Number of issues for this candidate?: ");
		numIssues = Integer.parseInt(keyboard.nextLine());
      
		System.out.print("Enter the issues when prompted:\n");
      
		for (int i = 0; i < numIssues; i++) {
			System.out.print("#" + (i + 1) + ": ");
			issueList += keyboard.nextLine().toUpperCase().trim() + ";";
		}

	}

	/**
	 * Displays information about a specific candidate.
	 * 
	 */
	public void display() 
   {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Party: " + party);
		System.out.println("Issues: ");
      
		String[] issues = this.issueList.split(";");
		for (String issue : issues) {
			System.out.println(issue);
		}
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
      Candidate clone = new Candidate();
      
      clone.setName(getName());
      clone.setAge(getAge());
      clone.setParty(getParty());
      clone.setIssueList(getIssueList());
      
      return clone;
   }
}

