/**
*  Main Class
*  Matthew Ruiz
*  Assignment #4
*/
import java.util.Scanner;
import java.util.ArrayList;

public class AssignmentFour
{
   static Scanner keyboard = new Scanner(System.in);
   
   private static Set<Element> list = new Set<Element>(); //Create Set that will contain Candidate and Donor objects
   
   public static void main(String[] args)
   {
      menu();
   }
   
    /*
   *Prompts the user with the menu
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
         for(int i = 0;i<9;i++)
            System.out.println((i+1) + ") " + menu[i]);
               
         System.out.println("Please enter a menu choice(1-9): ");
         userInput = keyboard.nextLine().charAt(0);
         
         if(userInput <= '9' && userInput >= '1')
            isValid = true;
         else
            System.out.println("Sorry. That was not a valid menu choice. Please pick(1-9): ");       
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
      else
      {
         wantsToQuit = getQuit();
            
         if(!wantsToQuit)
            menu();
      }
            
      
   }
   /*
   *     getQuit prompts checks to see if the user wants to quit the meniu
   */   
   private static boolean getQuit()
   {
      System.out.println("Do you want to quit?\nYes\nNo");
       return keyboard.nextLine().toUpperCase().charAt(0) != 'N';
   }
   /**
   *  Adds a Candidate object to the ElementSet
   *  Checks if the Candidate is already in the set. If so the appropriate feedback is given to the user. 
   */ 
   private static void addCandidate() 
   {
      Candidate temp = new Candidate();
      temp.readIn();

      if(list.isMemberOf(temp))
         System.out.println(temp.getName() + " is already in the list!");
      else
      {      
      list.add(temp);
      System.out.println(temp.getName() + " was successfully added to the Candidate Set!");
      }
   
   }
   /**
   *  Adds a Donor object to the ElementSet
   *  Checks if the Donor is already in the set. If so, the appropriate feedback is given to the user.
   */
   private static void addDonor() 
   {
      Donor temp = new Donor();
      temp.readIn();
      
   
      if(list.isMemberOf(temp))
         System.out.println(temp.getName() + " is already in the list!");
            
      list.add(temp);
      System.out.println(temp.getName() + " was successfully added to the Donor list!");
   
   }
   /**
   *Displays the names of all of the Candidates int the ElementSet
   */
   private static void displayAllCandidates()
   {
      if(list.isEmpty())
         System.out.println("There are no Candidates in the list!");
      else
      {
         int counter = 0;
         
         for(int i = 0;i<list.size();i++)
         {
            Element e = list.getCurrent();
            if(e.getClassName().contains("Candidate"))
            {
               System.out.println(((Candidate) e).getName());
               counter++;
            }
            
         }
         if(counter == 0)
            System.out.println("There are no Candidates in the list!");
      }
   }
   /**
   *Displays the name of all of the Donors in the ELementSet
   */
   private static void displayAllDonors()
   {
      if(list.isEmpty())
         System.out.println("There are no Donors in the list!");
      else
      {
         int counter = 0;
         
         for(int i = 0;i<list.size();i++)
         {
            Element e = list.getCurrent();
            if(e.getClassName().contains("Donor"))
            {
               System.out.println(((Donor) e).getName());
               counter++;
            }
         }
         if(counter == 0)
            System.out.println("There are no Donors in the list!");
      }
   }
   /**
   *
   * Searches for the specific Candidate in the ElementSet that is entered
   * by the user.
   * If the Candidate entered is not in set, the user is provided with the appropriate feedback and the method is ended. 
   *
   */
   private static void displayCandidateData() 
   {
      System.out.println("Please enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
      Candidate c = new Candidate();
      
      c.setName(name);
      Element result = list.retrieveAnObject(c);
      
      
      if(!list.isMemberOf(new Candidate(name)))
         System.out.println(name + " was not in the set!");
      else
         result.display();
   
   
         
   
   }
   /**
   *  Searches for the specific DOnor in the ELementSet that 
   *  is entered by the user.
   *  If the Donor entered is not in set, the user is provided with the appropriate feedback and the method is ended.
   */
   private static void displayDonorData() 
   {
      System.out.println("Please enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      Donor d = new Donor();
      
      d.setName(name);
      Element result = list.retrieveAnObject(d);
      
   
      if(!list.isMemberOf(new Donor(name)))
         System.out.println(name + " was not in the set!");
      else 
         result.display();
      
      Donor temp = new Donor(name);
      
   
   }
   /**
   *  Removes the Candidate from the ElementSet that is entered
   *  by the user.
   *  If the Candidate entered is not in set, the user is provided with the appropriate feedback and the method is ended.
   *
   */
   private static void removeCandidate() 
   {
      
      System.out.println("Please enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
      
     
      if(list.isMemberOf(new Candidate(name)))
      {
         Candidate found = new Candidate(name);
         list.removeAnObject(found);
         System.out.println(name + " was successfully removed!");
      }
      else
      {

         System.out.println(name + " was not int the set7!"); 
      }

   }
    /**
   *  Removes the Donor from the ElementSet that is entered
   *  by the user.
   *  If the Donor entered is not in set, the user is provided with the appropriate feedback and the method is ended.
   */
   private static void removeDonor() 
   {
      
      System.out.println("Please enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      
   
      if(!list.isMemberOf(new Donor(name)))
         System.out.println(name +" was not in the set!");
      else
         System.out.println(name + " was successfully removed!");
         
         Donor found = new Donor(name);
         list.removeAnObject(found); 
      
   
      
   }
   
   
}
