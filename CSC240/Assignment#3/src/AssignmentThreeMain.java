
/**
*  Main Class
*  Matthew Ruiz
*  Assignment #2
*/

import java.util.Scanner;

public class AssignmentThreeMain
{
   static Scanner keyboard = new Scanner(System.in);
   
   private static ElementSet list = new ElementSet();
   
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
      
try
{
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

}
   catch(CannotRetrieveException e)
   {
      System.out.println("CannotRetrieveException thrown.");
   }
   catch(DuplicateObjectException e)
   {
      System.out.println("DuplicateObejectException thrown.");
   }
   catch(CannotRemoveException e)
   {
      System.out.println("CannotRemoveException thrown.");
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
   *  Checks if the Candidate is already in the set. If so, the DuplicateObjectException is 
   *  thrown and caught. The appropriate feedback is given to the user. 
   */ 
   private static void addCandidate() throws DuplicateObjectException
   {
      Candidate temp = new Candidate();
      temp.readIn();
      
      try
      {
         if(list.isMemberOf(temp))
            throw new DuplicateObjectException("");
            
         list.add(temp);
         System.out.println("The Candidate was successfully added!");
      }
      catch(DuplicateObjectException e)//catches if the object already exists
      {
         System.out.println("The Candidate is already in the set!");
      }
   }
   /**
   *  Adds a Donor object to the ElementSet
   *  Checks if the Donor is already in the set. If so, the DuplicateObjectException is 
   *  thrown and caught. The appropriate feedback is given to the user.
   */
   private static void addDonor() throws DuplicateObjectException
   {
      Donor temp = new Donor();
      temp.readIn();
      
      try
      {
         if(list.isMemberOf(temp))
            throw new DuplicateObjectException("");
            
         list.add(temp);
         System.out.println("The Donor was successfully added!");
      }
      
      catch(DuplicateObjectException e)//Catches if the object already exists
      {
         System.out.println("The Donor is already in the set!");
      }
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
            if(e.getClassName().equals("Candidate"))
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
   *
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
            if(e.getClassName().equals("Donor"))
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
   * If the Candidate entered is not in set, the CannotRetrieveException is thrown
   * and the user is provided with the appropriate feedback and the method is ended. 
   *
   */
   private static void displayCandidateData() throws CannotRetrieveException
   {
      System.out.println("Please enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
      Candidate c = new Candidate();
      
      c.setName(name);
      Element result = list.retrieveAnObject(c);
      try
      {
      if(!list.isMemberOf(new Candidate(name)))
         throw new CannotRetrieveException("");
      else
         result.display();
  
      }
      catch(CannotRetrieveException e)
      {
         System.out.println("The Candidate is not in the set!");
      }
         

   }
      /**
   *  Searches for the specific DOnor in the ELementSet that 
   *  is entered by the user.
   *  If the Donor entered is not in set, the CannotRetrieveException is thrown
   *  and the user is provided with the appropriate feedback and the method is ended.
   */
   private static void displayDonorData() throws CannotRetrieveException
   {
      System.out.println("Please enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      Donor d = new Donor();
      
      d.setName(name);
      Element result = list.retrieveAnObject(d);
      
      try
      {
      if(!list.isMemberOf(new Donor(name)))
         throw new CannotRetrieveException("");
      else 
         result.display();
      
         Donor temp = new Donor(name);
      }
      catch(CannotRetrieveException e)
      {
         System.out.println("The Donor is not in the set!");
      }

   }
   /**
   *  Removes the Candidate from the ElementSet that is entered
   *  by the user.
   *  If the Candidate entered is not in set, the CannotRemoveException is thrown
   *  and the user is provided with the appropriate feedback and the method is ended.
   *
   */
   private static void removeCandidate() throws CannotRemoveException
   {
      
      System.out.println("Please enter the name of a Candidate: ");
      String name = keyboard.nextLine().toUpperCase();
      
      try
      {
         if(!list.isMemberOf(new Candidate(name)))
            throw new CannotRemoveException("");
         else
            System.out.println("The Candidate was successfully removed!");
            
            Candidate found = new Candidate(name);
            list.removeAnObject(found); 
      }
      catch(CannotRemoveException e)
      {
         System.out.println("The Candidate you specidifed is not in the set!");
      }
      
      
   }
    /**
   *  Removes the Donor from the ElementSet that is entered
   *  by the user.
   *  If the Donor entered is not in set, the CannotRemoveException is thrown
   *  and the user is provided with the appropriate feedback and the method is ended.
   *
   */
   private static void removeDonor() throws CannotRemoveException
   {
      
      System.out.println("Please enter the name of a Donor: ");
      String name = keyboard.nextLine().toUpperCase();
      
      try
      {
         if(!list.isMemberOf(new Donor(name)))
            throw new CannotRemoveException("");
         else
            System.out.println("The Donor was successfully removed!");
         
         Donor found = new Donor(name);
         list.removeAnObject(found); 
      }
      catch(CannotRemoveException e)
      {
         System.out.println("The Donor you specidifed is not in the set!");
      }
      
   }
   
   
}
