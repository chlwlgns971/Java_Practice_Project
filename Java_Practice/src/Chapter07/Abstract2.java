package Chapter07;

public class Abstract2 {
	
	public static void main(String[] args) {
		Dog dog = new Dog();
	    Cat cat = new Cat();
	    dog.sound();
	    cat.sound();
	    System.out.println("——");
	    
	    //변수의 자동 타입 변환
	    Animal animal = null;
	    animal = new Dog();
	    animal.sound();
	    animal = new Cat();
	    animal.sound();
	    System.out.println("——");
	    
	    //매개변수의 자동 타입 변환
	    animalSound(new Dog());
	    animalSound(new Cat());
	}
	public static void animalSound(Animal animal) {
	      animal.sound();
	}
	
}
abstract class Animal {
	public String kind;
	   
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	public abstract void sound();
}
class Cat extends Animal {
   public Cat() {
      this.kind = "포유류";
   }

   @Override
   public void sound() {
      System.out.println("야옹");
   }
}
class Dog extends Animal {
   public Dog() {
      this.kind = "포유류";
   }

   @Override
   public void sound() {
      System.out.println("멍멍");
   }
}

