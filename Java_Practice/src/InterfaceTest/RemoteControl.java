package InterfaceTest;

//인터페이스: 객체의 사용 방법을 정의한 타입
//인터페이스 이름 규칙: 클래스 이름 작성 규칙과 동일

public interface RemoteControl {
	//인터페이스는 생성자가 없다. ->인터페이스는 객체로 생성할 수 없으므로
	//인터페이스에서 정의한 멤버변수는 초기값이 항상 존재하며 상수이다.(항상 같은 수, 변하지 않음)
	//*****Spring mvc에선 필드(전역변수)를 사용하지 않는다.
	public int MAX_VOLUME=10; //public static final이 생략되어 있는 형태
	public int MIN_VOLUME=0;
	
	//추상메소드
		//중괄호가 없음
		//abstract는 생략가능
	public abstract void turnOn();
	public void turnOff();
	//스프링MVC에서 많이 쓰는 리턴타입
	//int: inser/update/delete
	//List<객체타입>: 목록 or List<Map<String,Object>
	//객체타입: 상세페이지 or Map<String,Object>
	public void setVolume(int volume);
}
