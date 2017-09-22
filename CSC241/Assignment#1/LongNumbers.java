package assignment.pkg1;

import java.util.*;

/*Matthew Ruiz
* CSC 241-01
* Dr.Fabrey
* Assignment1
*/

public class LongNumbers
{
	private List<Integer>[] theLists;
	
	public LongNumbers()
	{
		this.theLists = new LinkedList[10];
		
		for(int i = 0; i < 10; i++)
		{
			this.theLists[i] = new LinkedList<>();
		}
	}
	public void add(int location, int digit)
	{
		//add digit at head of LinkedList given by location
		this.theLists[location].add(digit);
	}
	
	public int remove(int location)
	{
		//remove a digit from LinkedList given by location
		return this.theLists[location].remove(0);
	}
	
	public boolean isEmpty(int location)
	{
		//check for an empty LinkedList given by location
		if(theLists[location].size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public List<Integer> get(int location)
	{
		// add digit at head of LinkedList given by location
		return this.theLists[location];
	}
	
	public static void main(String[] args)
	{
		LongNumbers longNum = new LongNumbers();
		LinkedList<Integer> sum = new LinkedList<>();
		
		Scanner kb = new Scanner(System.in);
		
		int count = 0;
		String number;
		int currDigit;
                int newDigit = 0;
		do
		{
			//ask user for long numbers
			System.out.println("Enter number " + (count + 1) + ":");
			number = kb.next();
			if("-1".equals(number))
			{
				break;
			}
			//store string in linkedlists as characters
			int numberLength = number.length();
			for (int i = numberLength - 1; i >= 0; i--)
			{
				//longNum.theLists[count].add(number.charAt(i) - '0');
				currDigit = Character.getNumericValue(number.charAt(i));
				longNum.add(count, currDigit);
                                newDigit = currDigit;
             
			}
			count++;
		}while(count < 10 && !"-1".equals(number));
		
		// add sum of all long numbers
		int carry = 0;
		int digitSum = 0;
                int newDigitSum = 0;
                int newCarry = 0;
		boolean moreNumbersToAdd = false;
		do
		{
			if(carry > 0)
			{
				moreNumbersToAdd = true;
			}
			moreNumbersToAdd = false;
			digitSum = 0;
			for (int i = 0; i < count; i++)
			{
				List<Integer> integerList = longNum.get(i);
				//checks if there are more numbers to add
				if (integerList.size() == 0)
				{
					continue;
				}
				moreNumbersToAdd = true;
				digitSum = digitSum + integerList.remove(0)+carry;
                                newDigitSum = digitSum % 10;
			}
         
			if (moreNumbersToAdd)
			{	  
			 	carry = digitSum / 10;
				sum.add(0, newDigitSum);
			}
		} while (moreNumbersToAdd);
		
		// print sum
		System.out.print("Sum: ");
		for (int i = 0; i < sum.size(); i++) {
			System.out.print(sum.get(i));
		}
	}//end main
}//end class
