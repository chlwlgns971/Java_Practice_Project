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
* ����1 ���������� �����ϴ� ��(Circle)Ŭ������ �����Ͻÿ�. ��������� �Ǽ�Ÿ���� ������(radius)�� �Ǽ��� ����� ������(PI=3.1415926)
* 	1)�⺻ ������ �� �������� �����ϴ� ������
* 	2)������ ���������� ������ ���Ͽ� ��ȯ�ϴ� �Լ�(getArea)
* ����2 ����Ŭ����(Cylinder)�� �����Ͻÿ�
* 	1)���: ����(�Ǽ���), ����1���� ������ CircleŸ���� ��
* 	2)�޼���: ���Ǹ� ��ȯ�ϴ� �Ǽ��� �޼��� getVolumn()
* ����3 ���� ������ �����ϴ� Ŭ������ �����Ͻÿ�(���Ŭ����(Employee))
* 	1)�������: ���޿�(salary): ������, �����ȣ(emp_id): ���ڿ�, �����(emp_name): ���ڿ�
* 	2)�޼���: ������(�����ȣ, ������� �Է�), �⺻������, ������ ����ؼ� ��ȯ�ϴ� �޼���
* ����4 ���� ��� �������� ó���ϱ� ���� ���
* 
* �� ������ �ڵ��Ͽ� �޷��忡 ������ �� sem-pc�� D:\A_TeachingMaterial\1.BasicJava\Homework�� ������ ��.
* ���ϸ�: �̸�.txt
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
//		Circle circle=new Circle(radius); //getVolumn �ۿ��� �����ϸ� Cylinder Ŭ������ ȣ��Ǵ� ������ ����ǰ� radius�� 0�� �ȴ�. ���� ���� �޼ҵ�ȿ��� ����
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
		this.emp_name="������";
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