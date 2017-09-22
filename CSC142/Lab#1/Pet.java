import java.util.Scanner;

public class Pet
{
   private String name;
   private String animal;
   private int age;
   
   
   public Pet()
   {
       name = "";
       animal = "";
       age = 0;
   }
   
   public Pet(String n, String ani)
   {
      name = n;
      animal = ani;
      age = 0;
   }
   
   public Pet(String n, String ani, int ag)
   {
      name = n;
      animal = ani;
      age = ag;
   }
   
   public String getName()
   {
      return name;
   }
 
   
   public String getAnimal()
   {
      return animal;
   }
   
   
   public int getAge()
   {
      return age;
   }
   
   public void setName(String n)
   {
      name = n;
   }
   
   public void setAnimal(String ani)
   {
      animal = ani;
   }
   
   public void setAge(int ag)
   {
      age = ag;
   }
   
}