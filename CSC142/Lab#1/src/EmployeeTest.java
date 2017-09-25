public class EmployeeTest
{
   public static void main(String[] args)
   {
      Employee e = new Employee("Susan Meyers" , 47899 , "Accounting" , "Vice President");
      Employee e1 = new Employee("Mark Jones" , 39119 , "IT" , "Programmer");
      Employee e2 = new Employee("Joy Rogers" , 81774 , "Manufacturing" , "Engineer");
      
      System.out.println("Name\t\t ID Number \t Department \t Position");
      System.out.println(e.getName() + "\t " + e.getidNumber() + "\t\t " + e.getDepartment() + "\t " + e.getPosition());
      System.out.println(e1.getName() + "\t " + e1.getidNumber() + "\t\t " + e1.getDepartment() + "\t\t " + e1.getPosition());
      System.out.println(e2.getName() + "\t " + e2.getidNumber() + "\t\t " + e2.getDepartment() + "\t " + e2.getPosition());
   }
}