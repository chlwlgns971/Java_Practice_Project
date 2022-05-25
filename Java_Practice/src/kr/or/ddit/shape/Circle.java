package kr.or.ddit.shape;


public class Circle extends Shape{
	Point center;//포함관계
	int r;
	public Circle() {
		//Circle(Point center, int r)을 호출하는데
		// Point public Point(int x, int y) 호출하기 전에 클래스의 생성자 중 를 호출하고
		//Circle(Point center, int r) center Point 을 호출하면서 지역변수 에게 를 주소를 넘겨준다
		this(new Point(0,0), 100);
		System.out.println("Circle "); 
	}
	public Circle(Point center, int r) {
		super();
		this.center= center;
		this.r = r;
	}
	// draw() ( ) 조상클래스의 멤버 메서드인 를 오버라이딩 재정의 함
	// . 원을 그리는 대신에 원의 정보를 출력하도록 했다
	// : , 오버라이딩 선언부가 무조건 같고 구현부만 다르게 구현함
	@Override
	public void draw() {
		System.out.println(" : " + this.color); //색깔
		System.out.println(" : ( x :" + this.center.x + ",y : " + this.center.y + ")"); //원점
		System.out.println(" : " + this.r); //반지름
	}
}

