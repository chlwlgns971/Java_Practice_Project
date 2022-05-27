package Chapter07;
/*인터페이스
 * 	-인터페이스는 극단적으로 동일 목적 하에 동일한 기능을 보장하기 위해 자바의 다형성을 이용하여 개발코드 수정을 줄이고 유지보수성을 높인다.
 * 인터페이스 문법과 다형성 이해
  	- 인터페이스는 interface 키워드를 통해 선언할 수 있으며 implements 키워드를 통해 일반 클래스에서 인터페이스를 구현할 수 있다.
  	- JAVA8 이전까지는 상수, 추상메소드만 선언이 가능(강제성이 강함을 의미)
  	- JAVA8부터 디폴트메소드, 정적메소드가 추가(구현 강제성 안에 유연함을 제공)  
 * 사용형식
 * 	public interface 인터페이스명{
 * 		//상수- 인터페이스에서 설정된 값을 변경하지 말고 제공해주는 타입 (상수명=값;)(절대적)
 * 		//추상메소드- 제공된 가이드인 추상메소드를 오버라이딩해서 재사용하는 타입 메소드명(강제적)
 * 		//디폴드메소드- 인터페이스에서 기본적으로 제공해주지만, 각 클래스에서 구현해서 써도 되는 타입 메소드명(선택적)
 * 		//정적메소드- 인터페이스에서 제공해주는 것으로 무조건 같은형식으로 사용해야 한다.(절대적)
 */


public class Interface {

	public static void main(String[] args) {
		KBBank kb=new KBBank();
		kb.setBalance(500000);
		kb.withDraw(100001);
		
		Bank_Interface b=new KBBank(1000000);
		b.deposit(100000);
		System.out.println("잔고: "+((KBBank)b).getBalance());
	}

}
