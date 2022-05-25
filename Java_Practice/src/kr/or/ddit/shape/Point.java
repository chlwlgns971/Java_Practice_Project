package kr.or.ddit.shape;

public class Point {
	int x;
	int y;
	public Point(){
		this(0,0);//public Point(int i, int j) 메서드 호출
		
	}
	public Point(int i, int j) {
		System.out.println("Point클래스의 매개변수가 있는 메서드");
		this.x=i;
		this.y=j;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
