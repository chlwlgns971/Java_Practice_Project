package kr.or.ddit.shape;

public class Triangle extends Shape{
	Point[] p;
	public Triangle() {
		this(new Point(0,0),new Point(0,0),new Point(0,0));
		System.out.println("Triangle ");
	}
	//Point 3 (Point 3 ) 클래스 개 인스턴스 개 를 받는 매개변수가 있는 생성자
	public Triangle(Point p1, Point p2, Point p3) {
		super();
		System.out.println("Triangle 3 "); 
		this.p = new Point[] {p1,p2,p3};
	}
	//Point []타입의 주소를 받는 생성자
	public Triangle(Point[] p) {
		super();
		System.out.println(" Point[] "); 
		this.p = p;
	}
	@Override
	public void draw() {
		System.out.println("[p1] : "+ this.p[0].toString());
		System.out.println("[p2] : "+ this.p[1].toString());
		System.out.println("[p3] : "+ this.p[2].toString());
	}
}
