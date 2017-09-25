

public class ElementSet
{
   //fields
   private int currentIndex;// Index of current element in the set
   private int currentSize;// Number of objects currently in the list
   private final int MAXSETSIZE = 100;// Maximum number of objects that can be
										// in an ElementSet.
   private Element[] theList;// Will reference an array of objects
								// from the subclasses of the abstract
								// class, Element


	// Constructor ...

	/**
	 * The ElementSet constructor sets up an array with MAXSETSIZE-many cells to
	 * reference objects from the subclasses of Element. It also initializes
	 * currentIndex and currentSize.
	 */
   public ElementSet()
   {
      theList = new Element[MAXSETSIZE];
      currentIndex = -1;
      currentSize = 0;
   }
	// Test methods

	/**
	 * The isMemberOf method tests to see if the parameter, anElement, is
	 * already a member of the ElementSet. Note that anElement can reference
	 * either a Person, a Student, or any subclass (direct or indirect) of the
	 * Element class.
	 * @param anElement
	 *            the object being checked for membership in the set
	 * @return true if anElement is already in the set and false
	 */
   public boolean isMemberOf(Element obj)
   {
      //local data
      String paramClass = obj.getClassName();
      String currClass;
      //logic
      for(int i = 0;i<currentSize;i++)
      {
         currClass = theList[i].getClassName();
         // Only compare anElement against those objects
      	// that belong to anElement's class
         if(currClass.equals(paramClass))
            if(theList[i].equals(obj))
               return true;
      }
      // This object was not found in the set
      return false;
   }
   	/**
	 * The isFull method returns true if the calling object is full and false
	 * otherwise.
	 * @return true if the calling object is full to capacity and false
	 *         otherwise.
	 */
   public boolean isFull()
   {
      return currentSize == MAXSETSIZE;
   }
   	/**
	 * The isEmpty method returns true if the calling object is empty and false
	 * otherwise.
	 * @return true if the calling object is empty and false otherwise.
	 */
   public boolean isEmpty()
   {
      return currentSize == 0;
   }
   
   	// Access methods

	/**
	 * The size method returns the number of objects currently in the set.
	 * @return the value of currentSize
	 */
   public int size()
   {
      return currentSize;
   }
   	/**
	 * The getCurrent() method returns a reference to the current object in the
	 * set. Note the pre-condition. This method should only be called if the set
	 * is not empty. The method advances currentIndex to the next object to set
	 * up for the next call to getCurrent. If getCurrent returns a copy of the
	 * last object, currentIndex is reset to 0. Pre: currentIndex is not -1
	 * (which can only occur if currentSize is not 0).
	 * @return copy of the current object
	 */
   public Element getCurrent()
   {
      int saveIndex = currentIndex;
      
      if(currentIndex == currentSize - 1)
         currentIndex = 0;
      else
         currentIndex++;
         
      return theList[saveIndex].clone();
   }
 	// Mutator methods ...

	/**
	 * The add method returns false if the ElementSet is already full.
    * If the object is already in the set, the DuplicateObjectException is thrown,
    * providing the user with the appropriate feedback
	 * @param anElement
	 *            the object we will try to add
	 * @return true if the object was successfully added
	 */  
   public boolean add(Element anElement) throws DuplicateObjectException
   {
        if(currentSize == MAXSETSIZE)
           return false;
        else if(isMemberOf(anElement))
        {
           throw new DuplicateObjectException("Already there!");
        }

        theList[currentSize] = anElement.clone();

        currentSize++;

        if(currentSize == 1)
           currentIndex = 0;
         
         
        return true;
   }
	/**
	 * The clear method resets the set to the empty set.
	 */   
   public void clear()
   {
      for(int i = 0;i<currentSize;i++)
         theList[i] = null;
         
      currentIndex = -1;
      currentSize = 0;
   }
	// The display method

	/**
	 * The display method displays all of the objects in the set using
	 * polymorphism in a powerful way.
	 */   
   public void display()
   {
      if(currentSize == 0)
         System.out.println("There are no objects in the set!");
      else
      {
         System.out.println("Here are the objects in the set: ");
         for(int i = 0;i<currentSize;i++)
         {
            theList[i].display();
            System.out.println("\n");
         }
      }
   }
   /**
   *  Searches for an object in the ElementSet array
   *  @param anObject The desired element
   *  @return Returns an Element if found
   */   
   public Element retrieveAnObject(Element obj) throws CannotRetrieveException
   {
      String paramClass = obj.getClassName();
      String currClass;
      
      for(int i=0;i<currentSize;i++)
      {
         currClass = theList[i].getClassName();
         if(currClass.equals(paramClass) && theList[i].equals(obj))
            return theList[i].clone();
      }
      
      return null;
   }
   /**
   *  Removes and object from the ElementSet
   *  @param anObject The object that the user wants to remove
   *  @return Returns if the ELement was removed successfully
   */   
   public void removeAnObject(Element obj) throws CannotRemoveException
   {
      String paramClass = obj.getClassName();
      String currClass;
      
      for(int i = 0;i<currentSize;i++)
      {
         currClass = theList[i].getClassName();
         if(currClass.equals(paramClass) && theList[i].equals(obj))
         {
            if(i==currentSize - 1)
            {
               theList[i] = null;
               currentSize--;
            }
            else
            {
               for(int j = i;j<currentSize;j++)
                  theList[j] = theList[j+1];
                  
               currentSize--;
            }
         }
      }

   }
   
   
}