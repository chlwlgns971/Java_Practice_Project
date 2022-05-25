package Chapter06;

public class MemberEx01 {
	private int age;
	private String name;
	private boolean gender=false;
	
	public void setAge(int age, String name, boolean gender){
		this.age=age;
		this.name=name;
		this.gender=gender;
	}

	@Override
	public String toString() {
		return "MemberEx01 [age=" + age + ", name=" + name + ", gender="
				+ gender + "]";
	}
}
/*
* 문제1 다음조건을 만족하는 원(Circle)클래스를 구성하시오. 멤버변수는 실수타입의 반지름(radius)와 실수형 상수인 원주율(PI=3.1415926)
* 	1)기본 생성자 및 반지름을 정의하는 생성자
* 	2)현재의 반지름으로 면적을 구하여 반환하는 함수(getArea)
* 문제2 원통클래스(Cylinder)를 구성하시오
* 	1)멤버: 높이(실수형), 문제1에서 구성한 Circle타입의 원
* 	2)메서드: 부피를 반환하는 실수형 메서드 getVolumn()
* 문제3 다음 조건을 만족하는 클래스를 생성하시오(사원클래스(Employee))
* 	1)멤버변수: 월급여(salary): 정수형, 사원번호(emp_id): 문자열, 사원명(emp_name): 문자열
* 	2)메서드: 생성자(사원번호, 사원명을 입력), 기본생성자, 연봉을 계산해서 반환하는 메서드
* 문제4 위의 사원 여러명을 처리하기 위한 방법
* 
* 위 문제를 코딩하여 메로장에 복사한 후 sem-pc의 D:\A_TeachingMaterial\1.BasicJava\Homework에 전송할 것.
* 파일명: 이름.txt
*/
class Circle{
	public double radius;
	private final double PI=3.1415926;
	public Circle(double radius){
		this.radius=radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getArea(){
		double circleArea=radius*radius*PI;
		return circleArea;
	}
}
class Cylinder{
	private double height;
	private Circle c1;
	public Cylinder(){
		this(10,new Circle(23.35));
	}
	public Cylinder(double height, Circle c1){
		this.height=height;
		this.c1=c1;
	}
	public double getVolumn(){
		double cylinder=c1.getArea()*height;
		return cylinder;
	}
}
//class Cylinder{
//	private double height;
//	private double radius;
//	public void setCylinder(double height, double radius){
//		this.height=height;
//		this.radius=radius;
//	}
//	public double getVolumn(){
//		Circle circle=new Circle(radius); //getVolumn 밖에서 선언하면 Cylinder 클래스가 호출되는 시점에 선언되고 radius가 0이 된다. 따라서 내부 메소드안에서 선언
//		double cylinder=circle.getArea()*height;
//		return cylinder;
//	}
//}
class Employee{
	int salary;
	String emp_id;
	String emp_name;
	public Employee(){
		this.salary=250;
		this.emp_id="20220520";
		this.emp_name="최지훈";
	}
	public Employee(int salary, String emp_id, String emp_name){
		this.salary=salary;
		this.emp_id=emp_id;
		this.emp_name=emp_name;
	}
	public int getYearSalary(){
		return (salary*12)+(salary*5);
	}
}