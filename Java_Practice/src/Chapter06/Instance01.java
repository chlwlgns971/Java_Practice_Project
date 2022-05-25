package Chapter06;

/*	2022.05.23
<<<<<<< HEAD
 * 인스턴스멤버와 static 멤버
 * 1)인스턴스 멤버
 * 	-클래스에서 선언되는 필드(변수와 상수) 및 메서드
 * 	-생성은 클래스 객체가 생성될 때
 * 	-사용자가 초기화를 시키지 않아도 자동초기화가 된다.
 * 	-this, super: 참조형 변수 제공(참조형 변수는 주소값을 가지고 있는 변수)
 * 	-this: 자신의 클래스 주소를 저장 ->인스턴스 변수와 메서드 내부에서 선언된 지역변수가 같은 단어로 구성되었을 때 메서드 내부에서 인스턴스 변수를 지칭할 때 사용
 * 
 * 2) 정적멤버
 * 	-static 키워드를 사용
 * 	-생성시점이 해당 클래스가 메모리에 loading될 때 생성->초기화도 한번만 수행.
 * 	-JVM메모리 중 메서드 영역에 저장됨
 * 	-정적메서드 내에서 참조하는 변수나 메서드는 반드시 정적이어야 함
 * 	-정적메서드에서 this변수는 사용할 수 없다.
 * 	-정적메서드를 호출할 경우 해당 클래스이름으로도 호출가능
 * 	-static을 사용해서 객체를 생성할 때마다 제품번호를 다르게 하는 등 응용할 수 있지만, 결합도가 높아져서 부작용 발생가능성이 있다.
 * 		->따라서 꼭 필요한 부분만 static을 사용하는 것이 좋다.
 * 
 * 3)final필드
 * 	-변수, 메서드, 클래스에 사용
 * 	-변수에 사용되어 상수화
 * 	-메서드에 사용되면 overriding이 제한됨
 * 	-클래스에 사용되면 하위클래스 생성이 불가(종단 클래스)
 * 	-인스턴스변수에 사용되면 해당 클래스는 재성생이 불가능
 */

public class Instance01 {

	public static void main(String[] args) {
		//this 멤버변수 연습
		Car2 car=new Car2();
		Car2 car2=new Car2();
		car2.setColor("검정");
		car2.setKind("세단");
		car2.setMaxSpeed(300);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		System.out.println();
		
		//static을 사용한 제품번호 증가
		Prod p1=new Prod();
		p1.printInfo();
		Prod p2=new Prod();
		p2.printInfo();
		Prod p3=new Prod();
		p3.printInfo();
		System.out.println();
		
		//final필드 객체생성 연습
		final Company cp1=new Company();
		cp1.setName("(주)다팔아");
		System.out.println("회사명: "+cp1.getName());
		//cp1=new Company(); //cp1을 final로 생성했기때문에 같은 클래스 객체의 재생성이 불가능
		System.out.println();
		
		//final필드 클래스선언 연습
		Shape s1=new Shape();
		System.out.println(s1.getShape());
		Rectangle r1=new Rectangle();
		System.out.println(r1.getShape());
		//Shape 클래스에 final을 붙이면 자식클래스를 가질 수 없기때문에 에러가 난다.
		System.out.println();
		System.out.println("오버라이드 테스트");
		Shape s2=new Rectangle();
		System.out.println("Shape s2=new Rectangle()의 결과는 "+s2.getShape());
	}

}
class Car2{
	private String kind;
	private String color;
	private int maxSpeed;
	
	Car2(){
		this.color="color";
		this.kind="kind";
		this.maxSpeed=0;
	}
	
	public void setKind(String kind){
		this.kind=kind;
	}
	public String getKind(){
		return kind;
	}
	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed=maxSpeed;
	}
	public int getMaxSpeed(){
		return maxSpeed;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getcolor(){
		return color;
	}
	@Override
	public String toString() {
		return "Car2 [kind=" + kind + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]";
	}
	
}
class Prod{ //static연습
	static int prod_id=99;
	
	public Prod(){// 새로운 객체를 생성할 때마다 제품번호를 1씩 증가->but 생성될 때마다 초기화가 일어나서 항상 같은 번호 출력 ->static사용 필요
		prod_id++;
	}
	public void printInfo(){
		System.out.println("제품번호: "+prod_id);
	}
}
class Company{//final 연습
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
/*final*/ class Shape{
	String kind;
	
	Shape(){
		kind="다각형";
	}
	public /*final*/ String getShape(){ //메서드에 final이 붙으면 오버라이딩을 할 수 없다.
		return kind;
	}
	
}
class Rectangle extends Shape{//상속 및 오버라이딩
	Rectangle(){
		kind="사각형"; //부모클래스에서 선언된 변수이기 때문에 자식클래스에선 선언없이 사용가능
	}
	@Override
	public final String getShape(){
		return "다각형의 종류:"+kind;
	}
}