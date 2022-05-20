package Chapter06;

import java.util.*;
/*
 * Field
 * -��������� �ǹ�
 * -Ŭ���� ����(�޼��� ���� �ƴ�)
 * -�ڵ� �ʱ�ȭ->����ڰ� �ʱ�ȭ���� �ʾƵ� �ʱ�ȭ�� �Ͼ��.(������ 0, �Ǽ��� 0.0, ���ڴ� " ", boolean�� false, �迭�̳� Ŭ����, �������̽��� null)
 * -����: Ŭ������ ���¸� ǥ��
 * 
 * ��������� ����
 * -Ŭ���� ����->��ü �������� ������ �� �ִ�.
 * -Ŭ���� �ܺ�->��ü�� �����ϰ� ������ ��ü���� ������ �̿��Ͽ� ����
 * 
 * �����ε�
 * -���� Ŭ���� ������ ���� �̸��� �޼ҵ带 ����ϴ� ���� �����ε��̶�� �Ѵ�.
 * -����� �������� �����ϱ� ���� ���
 * 
 * �������̵�
 * -��Ӱ��谡 ����Ǿ��ϸ�, �θ�Ŭ�������� ���ǵ� �޼��尡 �ڽ�Ŭ�������� �������ϸ鼭 �ٸ� ���� �� �� �ְ� ����� ���� �������̵��̶�� �Ѵ�.
 * 
 * ������ �޼���(new)
 * -Ŭ������ ȣ���� �� �ʱ�ȭ�ϴ� �������� ���
 * 
 * �޼���
 * -Ŭ������ �����ؾ� �� �����Ͻ� ������ �ڵ�ȭ�� ���
 * -��ȯ Ÿ���� �ִ� �޼���, ��ȯŸ���� ���� �޼���� ������.
 */


/*
 * ����1 ���������� �����ϴ� ��(Circle)Ŭ������ �����Ͻÿ�. ��������� �Ǽ�Ÿ���� ������(radius)�� �Ǽ��� ����� ������(PI=3.1415926)
 * 	1)�⺻ ������ �� �������� �����ϴ� ������
 * 	2)������ ���������� ������ ���Ͽ� ��ȯ�ϴ� �Լ�(getArea)
 * ����2 ����Ŭ����(Cylinder)�� �����Ͻÿ�
 * 	1)���: ����(�Ǽ���), ����1���� ������ CircleŸ���� ��
 * 	2)�޼���: ���Ǹ� ��ȯ�ϴ� �Ǽ��� �޼��� getVolumn()
 */
public class MemberVal01 {

	public static void main(String[] args) {
//		MemberEx01 m1=new MemberEx01();
//		m1.setAge(26, "������", true);
//		System.out.println(m1.toString());
		double r=23.35;
		double height=8.0;
		Circle circle=new Circle(r);
		System.out.println("�������� "+r+"�� ���� ����= "+circle.getArea());
		Cylinder y1=new Cylinder();
		System.out.println("�������� 23.35�̰�, ���̰� 10�� ���� ����= "+y1.getVolumn());
		Cylinder y2=new Cylinder(height,new Circle(r));
		System.out.println("�������� "+r+"�̰�, ���̰� "+height+"�� ���� ����= "+y2.getVolumn());
		
//		Cylinder cl=new Cylinder();
//		cl.setCylinder(height,r);
//		System.out.println("�������� "+r+"�̰�, ���̰� "+height+"�� ���� ����= "+cl.getVolumn());
		
//		����3 ���� ������ �����ϴ� Ŭ������ �����Ͻÿ�(���Ŭ����(Employee))
//		 	1)�������: ���޿�(salary): ������, �����ȣ(emp_id): ���ڿ�, �����(emp_name): ���ڿ�
//		 	2)�޼���: ������(�����ȣ, ������� �Է�), �⺻������, ������ ����ؼ� ��ȯ�ϴ� �޼���
//		 ����4 ���� ��� �������� ó���ϱ� ���� ���
//		 
//		 �� ������ �ڵ��Ͽ� �޷��忡 ������ �� sem-pc�� D:\A_TeachingMaterial\1.BasicJava\Homework�� ������ ��.
		Employee ep=new Employee();
		System.out.println("������ ����� ���ʽ��� ������ ������ "+ep.getYearSalary()+"�Դϴ�.");
		int salary=300;
		String emp_id="20220523";
		String emp_name="�����";
		Employee ep1=new Employee(salary,emp_id,emp_name);
		System.out.println(emp_name+"����� �����ȣ�� "+emp_id+"�̰�, ���ʽ��� ������ ������ "+ep1.getYearSalary()+"�Դϴ�.");
		
		
		//����4
		//Employee nameArray[i]=new Employee();
		Scanner sc=new Scanner(System.in);
		int[] salaryArr={200,300,400,500,350};
		String[] id={"001","002","003","004","005"};
		String[] name={"��","��","��","��","��"};
		for(int i=0; i<id.length; i++){
			Employee epy=new Employee(salaryArr[i],id[i],name[i]);
			System.out.println(name[i]+"����� �����ȣ�� "+id[i]+"�̰�, ���ʽ��� ������ ������ "+epy.getYearSalary()+"�Դϴ�.");
		}
	}

}