package Chapter06;
/*클래스와 객체
 * -객체지향 프로그램의 가장 핵심적인 프로그램 구성단위
 * -클래스가 인스턴스화 하면 객체가 된다.
 * -배열과 클래스는 힙메모리에 저장된다. ->보는 시각에 따라 배열도 클래스라고 하는 경우도 있다.
 * -클래스는 필드(field or attribute)와 행위(behavior or method)로 구성
 * 
 *  1)클래스
 *  	-설계도 또는 제품생산을 위한 틀에 해당
 *  	-클래스의 사용형식
 *  [접근지정자] class 클래스명{
 * 		변수;->필드
 * 		[접근지정자][리턴타입] 메서드{}
 * }
 * 		-접근지정자: 클래스를 외부에서 접근할 수 있는 범위
 * 			-public: 접근 제한이 없음.(동일 클래스내, 동일패키지내, 다른 패키지의 자식 클래스, 다른 패키지의 모든 클래스에서 사용가능)
 * 			-protected: 동일패키지내의 클래스와 자식클래스에서 접근가능
 * 			-default(접근지정자 생략한경우): 동일 패키지내에서만 접근 가능
 * 			-private: 동일 클래스내에서만 접근 가능->정보 은닉할 때 사용(밖에서 데이터 접근을 못하도록 하는 것. =캡슐화)
 * 		-static: 정적메소드나 정적변수를 선언
 * 			-정적변수나 정적메소드는 프로그램이 loading할 때 기억장소를 배정받고 한번만 초기화됨
 * 			-static 메소드에서 호출하거나 참조하는 변수도 정적변수 또는 정적메소드여야 함.
 * 			-정적메소드 호출을 위해 정적메소드를 가지고 있는 클래스는 객체화하지 않아도 됨.
 * 		-'클래스명': 사용자 정의 단어 이용
 * 			-첫 글자는 영문자나 특수문자 중($,_)사용 ->but 영대문자로 시작하는걸 추천.
 * 			-두 번째 글자는 영문자나 숫자 사용가능
 * 			-각 단어의 첫글자는 대문자로 구성
 * 			-예약어와 같은 형태여서는 안된다.
 * 		-객체화
 * 			-new연산자 사용(힙메모리에 해당 클래스 객체가 공간을 할당받음)
 * 			-객체참조변수를 이용하여 클래스 내부의 메소드나 변수를 참조함.
 * 			(사용형식)
 * 			-클래스명 객체참조변수=new 클래스명([매개변수list]);
 * 			-객체참조변수.멤버변수
 */

public class ClassConcept {
	String name;
	public static void main(String[] args) {
//		Student sd=new Student();
//		sd.getName();
		//Student.getName(); // ->static을 사용해서 이렇게도 표현가능
		
		//StaticMethod("홍길동") ->메인메소드는 static이기 때문에 같은 클래스 내에 있더라도 static메소드여야 사용가능함.(setName메소드에 static을 쓰면 사용가능)
		Animal dog=new Animal();
		dog.kind="강아지";
		dog.setName("멍멍이");
		System.out.println("애완동물 종류: "+dog.kind);
		System.out.println("애완동물 이름: "+dog.getName());
		
		Animal cat=new Animal();
		cat.kind="고양이";
		cat.setName("야옹이");
		System.out.println("애완동물 종류: "+cat.kind);
		System.out.println("애완동물 이름: "+cat.getName());
	}
	public void StaticMethod(String name){
		this.name=name;
	}

}