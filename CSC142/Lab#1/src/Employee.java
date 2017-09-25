public class Employee
{
   private String name;
   private int idNumber;
   private String department;
   private String position;
  
   public Employee(String eName, int ID , String dept , String pos)
   {
      name = eName;
      idNumber = ID;
      department = dept;
      position = pos;
   }
   
   public Employee(String eName , int ID)
   {
      name = eName;
      idNumber = ID;
      department = "";
      position = "";   
   }
   
   public Employee()
   {
      name = "";
      idNumber = 0;
      department = "";
      position = ""; 
   }
   
   public void setName(String eName)
   {
      name = eName;
   }
   
   public void setidNumber(int ID)
   {
      idNumber = ID;
   }
   
   public void setDepertment(String dept)
   {
      department = dept;
   }
   
   public void setPosition(String pos)
   {
      position = pos;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getidNumber()
   {
      return idNumber;
   }
   
   public String getDepartment()
   {
      return department;
   }
   
   public String getPosition()
   {
      return position;
   }
  
}