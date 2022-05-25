package Chapter06;

//자동차 클래스(설계도)
public class Car {
	//필드=멤버변수=속성
	//제조사
	String company="기아";
	//모델
	String model;
	String color;
	//최대스피드
	int maxSpeed;
	//현재 스피드
	int speed;
	
	//생성자: 객체가 생성될 때 자동으로 실행(초기값을 세팅 시 사용)
	//기본생성자
	Car(){}
	//생성자 오버로딩. 매개변수 순서 or 갯수 or 타입이 달라야함
	Car(String model){
		//model: 이곳으로 던져지는 문자형 파라미터를 담아주는 매개변수(지역변수: 이 블록을 벗어나면 메모리에서 사라짐)
		//멤버변수<=매개변수를 할당(대입)
//		this.model=model;
//		this.color = "은색";
//		this.maxSpeed = 250;
		// this: 생성자인데 다른 생성자를 호출->첫 줄에서만 허용=>다른 생성자 호출
		this(model, "은색", 250);
	}
	//생성자 오버로딩
	Car(String model, String color){
		//매개변수의 값을 멤버변수에 할당(대입)
//		this.model=model;
//		this.color=color;
//		this.maxSpeed = 250;
		this(model, color, 250);
	}
	//생성자 오버로딩
	Car(String model, String color, int maxSpeed){
		//매개변수의 값을 멤버변수에 할당(대입)
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color="
				+ color + ", maxSpeed=" + maxSpeed + ", speed=" + speed + "]";
	}
	
}