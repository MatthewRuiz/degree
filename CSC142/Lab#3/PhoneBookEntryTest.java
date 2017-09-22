import java.util.ArrayList;
public class PhoneBookEntryTest
{
   public static void main(String[] args)
   {
   
      PhoneBookArrayList bookArrayList = new PhoneBookArrayList();
      
      PhoneBookEntry entry1 = bookArrayList.new PhoneBookEntry("Jack", "920-456-2345");
      PhoneBookEntry entry2 = bookArrayList.new PhoneBookEntry("Sam", "868-344-2345");
      PhoneBookEntry entry3 = bookArrayList.new PhoneBookEntry("George", "414-234-2345");
      PhoneBookEntry entry4 = bookArrayList.new PhoneBookEntry("Dimo", "608-049-2345");
      PhoneBookEntry entry5 = bookArrayList.new PhoneBookEntry("Jenny", "971-456-2345");
      
      List<PhoneBookEntry> phoneNumberEntries = new ArrayList<PhoneBookEntry>();
      phoneNumberEntries.add(entry1);
      phoneNumberEntries.add(entry2);
      phoneNumberEntries.add(entry3);
      phoneNumberEntries.add(entry4);
      phoneNumberEntries.add(entry5);
      
   }
}