package Chapter07;
/*
[1] 추상클래스는?(추상클래스 개념)
	- 복수개의 클래스간에 성격과 내용이 비슷한 필드와 메서드를 공통적으로 추출해 만들어진 클래스
	- 실체클래스는 실체가 드러나는 클래스(보통의 클래스)이며, 
	- 추상클래스는 실체 클래스의 공통적인 부분을 추출해 어느정도 규격을 잡아놓은 추상적인 클래스
	- 실체클래스 실제 객체를 생성할 정도의 구체성을 가지는 반면,
	- 추상클래스는 아직 메서드와 내용이 추상적이기 때문에 객체를 생성할 수 없게 만들었음 
	- 추상클래스와 실체클래스는 상속적인 관계를 가지고 있음 

[2] 추상클래스의 용도
	- 공통된 필드와 메서드를 통일할 목적
		 . 필드와 메서드 이름을 통일하여 유지보수성을 높이고 통일성을 유지할 수 있음 
	- 실체클래스 구현시, 시간절약
		 . 강제로 주어지는 필드와 메서드를 가지고 자신의 스타일대로 구현
		 . 설계 시간이 절약 
		 . 설계는 AA(application architecture)가 수행  
	- 규격에 맞는 실체클래스 구현 
		 . 모듈의 결합도는 낮게(영향도를 적게) 가져가면서 변화에는 유연하게 만들기 위해 추상클래스를 사용
	**SOLID  
		      
[3] 추상클래스의 용도
	- 추상 클래스 
		 public abstract class 클래스명{
		  //필드
		  //생성자
		  //메서드
		  //추상메서드
		 }
	- 추상 메서드 
		 [ public | protected ] abstract 리턴타입 메소드명(매개변수1, 매개변수2, … );
		    
[4] 추상클래스의 상속 
 	- 추상 클래스를 상속받는 실체 클래스는 반드시 추상메서드를 재정의(override) 해야 함   
		  
[5] 타입의 다형성  
	- 추상클래스 변수에, 추상클래스를 상속받아 구현한 실체클래스 인스턴스를 주입하면 해당 추상클래스 변수는 
		자동 타입변환을 발생시켜 실체클래스 인스턴스처럼 사용할 수 있음
*/
public class Abstract1 {

	public static void main(String[] args) {
		 //Phone phone = new Phone(); (x)
        SmartPhone smartPhone = new SmartPhone("홍길동");
           
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();

	}

}
abstract class Phone {
	   //필드
	   public String owner;
	      
	   //생성자
	   public Phone(String owner) {
	      this.owner = owner;
	   }
	      
	   //메소드
	   public void turnOn() {
	      System.out.println("폰 전원을 켭니다.");
	   }   
	   public void turnOff() {
	      System.out.println("폰 전원을 끕니다.");
	   }
}
class SmartPhone extends Phone {
	   //생성자
	   public SmartPhone(String owner) {
	      super(owner);
	   }
	   //메소드
	   public void internetSearch() {
	      System.out.println("인터넷 검색을 합니다.");
	   }
	}

