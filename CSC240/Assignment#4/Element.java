

/**
   This version of the Element class has been modified to include
	a toString method for use with the generic class Set<T>.  It
	also no longer contains the equals method, using the equals
	method inherited from the Object class:
	          public boolean equals(Object anObject) ....

	The purpose of the abstract class Element is to introduce the
	"common class protocol" for all of its subclasses.  That common
	class protocol is introduced using	abstract as well as fully
	implemented methods.  The abstract methods are:
 				  readIn
				  display
				  clone
				  toString
	In addition, the abstract class Element fully implements the
	getClassName method.
*/

    public abstract class Element
   {

   // Access method

   /**
      The getClassName method returns the name of the calling object's
   	class.
   	@return the name of the calling object's class
   */

		public String getClassName()
      {
         // Local data ...
         String resultStr;
         int whereAt;   // Where the . is in the class name

         // Logic ...
         resultStr = getClass().getName();
         whereAt = resultStr.indexOf('.');
         return resultStr.substring(whereAt + 1);
      }


      // Abstract methods readIn, display and eqauls.
      // Direct subclasses must implement these in order for them
      // not to be abstract.

       public abstract void readIn();

       public abstract void display();

       public abstract Element clone();

       public abstract String toString();
   }

