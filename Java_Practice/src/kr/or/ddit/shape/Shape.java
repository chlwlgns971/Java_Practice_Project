package kr.or.ddit.shape;

public class Shape {
	String color = "black";
	public Shape() {
		System.out.println("Shape "); 
	}
	public void draw() {
		System.out.println("[color = " + this.color + "]");
	}
}