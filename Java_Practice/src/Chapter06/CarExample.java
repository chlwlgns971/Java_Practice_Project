
package Chapter06;
/*ctrl+alt+방향키아래->아랫줄에 현재 줄 코드 복사후 붙여넣기
 *shift+home->현재줄 전체선택
 *ctrl+F6= 패키지내 다른 자바파일로 이동
 *ctrl+F3= 메소드 위에서 실행하면 해당 메소드 위치로 이동가능
 */

public class CarExample {
	public static void main(String[] args) {
		System.out.println("실행");
		// myCar: 객체, 클래스변수, 인스턴스
		Car myCar=new Car("현대자동차","그랜저","검정",350,0);
		System.out.println("제작회사: "+myCar.company);
		System.out.println("모델명: "+myCar.model);
		System.out.println("색깔: "+myCar.color);
		System.out.println("최고속도: "+myCar.maxSpeed);
		System.out.println("현재속도: "+myCar.speed);
		//필드값 변경
		myCar.speed=60;
		System.out.println(myCar.toString());
		
		//오버로딩테스트
		System.out.println("오버로딩 테스트 시작");
		Car car1=new Car();
		System.out.println("car1.company: "+car1.company);
		System.out.println("car1.model: "+car1.model);
		System.out.println("car1.color: "+car1.color);
		System.out.println("car1.maxSpeed: "+car1.maxSpeed);
		Car car2=new Car("자가용");
		System.out.println("car2.company: "+car2.company);
		System.out.println("car2.model: "+car2.model);
		System.out.println("car2.color: "+car2.color);
		System.out.println("car2.maxSpeed: "+car2.maxSpeed);
		Car car3=new Car("자가용","화이트");
		System.out.println("car3.company: "+car3.company);
		System.out.println("car3.model: "+car3.model);
		System.out.println("car3.color: "+car3.color);
		System.out.println("car3.maxSpeed: "+car3.maxSpeed);
		Car car4=new Car("택시","검정",250);
		System.out.println("car4.company: "+car4.company);
		System.out.println("car4.model: "+car4.model);
		System.out.println("car4.color: "+car4.color);
		System.out.println("car4.maxSpeed: "+car4.maxSpeed);
	}
}
