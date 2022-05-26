package Chapter07;

public class Abstract3 {

	public static void main(String[] args) {
		Employee emp1=new Manager();
		Employee emp2;
	      
		emp1=new Manager();
		emp2=new PartTime();
      
		emp1.echo();
		emp2.echo(); 
	}

}
abstract class Employee {
   private String name;

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public abstract void echo();
}
class Manager extends Employee {
   @Override
   public void echo(){
      System.out.println("관리자입니다");
   }
}
class PartTime extends Employee {
   @Override
   public void echo(){
      System.out.println("아르바이트 입니다.");
   }
}