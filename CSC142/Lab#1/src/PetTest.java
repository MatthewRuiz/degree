public class PetTest
{
   public static void main(String[] args)
   {
      Pet p = new Pet();
      Pet p1 = new Pet("Bill" , "Dog");
      Pet p2 = new Pet("Bill" , "Dog" , 10);
      
      System.out.println(p1.getName() + p1.getAnimal());
      System.out.println(p2.getName() + p2.getAnimal() + " " + p2.getAge());
 
      p2.setName("Joe");
      p2.setAge(15);
      
      System.out.println(p2.getName() + p2.getAge());
   }
}