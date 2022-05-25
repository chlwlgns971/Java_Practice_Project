public class DrawShapeEx {
	public static void main(String[] args) {
		Point[] p = new Point[] {new Point(10,10),new Point(20,20),new Point(30,30)};
		Triangle t1 = new Triangle(p);
		t1.draw();
		System.out.println("--------------------------");
		Circle c1 = new Circle();
		c1.draw();
		System.out.println("-----------------------------");
		Circle c2 = new Circle(new Point(100,100), 100);
		c2.draw();
	}
}