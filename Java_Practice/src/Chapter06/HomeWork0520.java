package Chapter06;
import java.util.Scanner;

public class HomeWork0520 {

	public static void main(String[] args) {
		//�⺻�����ڷ� �̸��� �׸�, ����12, ����12�� ���� ���� rect�޼ҵ� ����
		Rect rect1=new Rect();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("��ü �̸��� �Է��ϼ���: ");
		String str=sc.nextLine();
		System.out.println();
		System.out.print("���� ���̸� �Է��ϼ���: ");
		int width=sc.nextInt();
		System.out.println();
		System.out.println("���� ���̸� �Է��ϼ���: ");
		int height=sc.nextInt();
		System.out.println();
		//2. �̸�,����,���θ� �Է¹��� rect�޼ҵ� ����
		Rect rect2=new Rect(str,width,height);
		
		//3. 1,2�� ��ü ������ ���
		System.out.println("1�� ��ü �̸�:"+rect1.name+" ����:"+rect1.getWidth()+
				" ����:"+rect1.getHeight()+" ����:"+rect1.getArea()+" �ѷ�:"+rect1.getCircumference());
		System.out.println("2�� ��ü �̸�:"+rect2.name+" ����: "+rect2.getWidth()+
				" ����:"+rect2.getHeight()+" ����:"+rect2.getArea()+" �ѷ�:"+rect2.getCircumference());
		
		//4. 1�� ��ü���� ���� ������ ���� +2�� ������ ������ �ѷ��� �����Ͽ� ���
		rect1.width+=2;
		System.out.println("1�� ��ü �̸�:"+rect1.name+" ����:"+rect1.getWidth()+
				" ����:"+rect1.getHeight()+" ����:"+rect1.getArea()+" �ѷ�:"+rect1.getCircumference());
	}

}
class Rect{
	String name;
	int width;//����
	private int height; //����
	
	Rect(){
		this.name="�׸�";
		this.width=12;
		this.height=23;
	}
	Rect(String name){
		this.name=name;
	}
	Rect(String name,int width,int height){
		this.name=name;
		this.width=width;
		this.height=height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getArea() {
		return width*height;
	}
	public int getCircumference() {
		return (width+height)*2;
	}
	
}