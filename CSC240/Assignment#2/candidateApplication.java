import java.util.Scanner;


public class candidateApplication
{
   static Scanner keyboard = new Scanner(System.in);
   
   private static ElementSet list = new ElementSet();
   
   public static void main(String[] args)
   {
      menu();
      
   }
   /*
   *     getQuit prompts checks to see if the user wants to quit the meniu
   */
   private static boolean getQuit()
   {
      System.out.println("Do you want to quit?\nYes\nNo");
       return keyboard.nextLine().toUpperCase().charAt(0) != 'N';
   }
   
   /*
   *Prompts the user with the menu
   *
   *@return A menu choice
   */ 
   public static void menu()
   {
      char userInput;
      boolean isValid = false;
      boolean wantsToQuit = false;
      
      String [] menu = {"Add a new Candidate","Add a new Donor",
                        "Display the names of the all of the Candidates","Display the names of all of the Donors",
                        "Display all of the data for a particular Candidate","Display all of the data for a particular Donor",
                        "Remove a particular Cadidate","Remove a particular Donor","Quit the program."};
                        
      
      do
      {
         System.out.println("West Chester Presidential Candidate Tracking Society Data Menu");
         for(int i = 0; i < 9; i++)
            System.out.println((i+1) + ") " + menu[i]);
               
         System.out.print("Please enter a menu choice (1-9): ");
         userInput = keyboard.nextLine().charAt(0);
               
         if(userInput <= '9' && userInput >= '1')
            isValid = true;
         else
            System.out.println("Sorry, that is not a valid choice. Try again(1-9)");
                   
      }
      
      while(!isValid);
      
      switch(userInput)
      {
         case '1':
            addCandidate();
            break;
         case '2': 
            addDonor();
            break;
         case '3':
            displayAllCandidates();
            break;
         case '4':
            displayAllDonors();
            break;
         case '5':
            displayCandidateData();
            break;
         case '6':
            displayDonorData();
            break;
         case '7':
            removeCandidate();
            break;
         case '8':
            removeDonor();
            break;
         default:
            break;
      }
         
      if(!wantsToQuit && userInput != '9')
         menu();
      else //If the user has entered 9 then the program calls the getQuit method which asks the user if they are sure that they want to quit.
      {
         wantsToQuit = getQuit();
            
         if(!wantsToQuit)
            menu();
      }  
                         
   }
   
   /**
   *  Adds a Candidate object to the ElementSet
   *
   *
   *
   */
   private static void addCandidate()
   {
      Candidate temp = new Candidate();
      temp.readIn();
      
      int outcome = list.add(temp);

       switch (outcome) {
           case -1:
               System.out.println("This Candidate was already in the list!");
               break;
           case 1:
               System.out.println("This Candidate was successfully added!");
               break;
           case 0:
               System.out.println("This list is full!");
               break;
           default:
               break;
       }
   }
   
   /**
   *
   *   Adds a Donor object to the ElementSet
   *
   */
   private static void addDonor()
   {
      Donor temp = new Donor();
      temp.readIn();
      
      int outcome = list.add(temp);
      
       switch (outcome) {
           case 1:
               System.out.println("This Donor was successfully added!");
               break;
           case -1:
               System.out.println("This Donor was already in the list!");
               break;
           case 0:
               System.out.println("This list is full!");
               break;
           default:
               break;
       }
   }
   
   /**
   *
   *Displays the names of all of the Candidates int the ElementSet
   *
   */
   private static void displayAllCandidates()
   {
      if(list.isEmpty())
         System.out.println("There are no Candidate in the list!");
      else
      {
         int counter = 0;
         for(int i = 0;i<list.size();i++)
         {
            Element e = list.getCurrent();
            if(e.getClassName().equals("Candidate"))
            {  
               System.out.println(((Candidate) e).getName());
               counter++;
            }
         }
         if(counter == 0)
            System.out.println("There are no Candidates!");
      }
   }
   /**
   *Displays the name of all of the Donors in the ELementSet
   *
   */
   private static void displayAllDonors()
   {
      if(list.isEmpty())
         System.out.println("There are no Donors in this list!");
      else
      {
         int counter = 0;
         for(int i = 0;i<list.size();i++)
         {
            Element e = list.getCurrent();
            if(e.getClassName().equals("Donor"))
            {
               System.out.println(((Donor) e).getName());
               counter++;
            }
         }
         if(counter == 0)
            System.out.println("There are no Donors!");
      }
   }
   
   /**
   *
   * Searches for the specific Candidate in the ElementSet that is entered
   * by the user. 
   *
   */
   private static void displayCandidateData()
   {  
      System.out.print("Enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
      Candidate c = new Candidate();
      
      c.setName(name);
      Element result = list.retrieveAnObject(c);
      if(list.isMemberOf(new Candidate(name)))
      {
         Candidate temp = new Candidate(name);
      }
      
      if(result == null)
         System.out.println("Not a valid Candidate!");
      else
         result.display();
   }
   
   /**
   *  Searches for the specific DOnor in the ELementSet that 
   *  is entered by the user.
   *
   */
   private static void displayDonorData()
   {
      Donor d = new Donor();
      
      System.out.print("Enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      d.setName(name);
      Element result = list.retrieveAnObject(d);
      if(list.isMemberOf(new Donor(name)))
      {
         Donor temp = new Donor(name);
      }
      
      if(result == null)
         System.out.println("Not a valid Donor!");
      else
         result.display();
   }
   
   /**
   *  Removes the Candidate from the ElementSet that is entered
   *  by the user.
   *
   *
   */
   private static void removeCandidate()
   {
      boolean result = false;
      
      System.out.print("Enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
   
      if(list.isMemberOf(new Candidate(name)))
      {
         Candidate found = new Candidate(name);
         result = list.removeAnObject(found);
      }
   
      if(result)
         System.out.println("The Candidate was successfully removed!");
      else
         System.out.println("Not a valid Candidate!");
   }
   
   /**
   *  Removes the Donor from the ElementSet that is entered
   *  by the user
   */
   private static void removeDonor()
   {
      boolean result = false;
      
      System.out.print("Enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      
      if(list.isMemberOf(new Donor(name)))
      {
         Donor found = new Donor(name);
         result = list.removeAnObject(found);
      }
      
      if(result)
         System.out.println("The Donor was successfully removed!");
      else
         System.out.println("Not a valid Donor!");
   }
}