package Chapter06;

/*	2022.05.23
 * �ν��Ͻ������ static ���
 * 1)�ν��Ͻ� ���
 * 	-Ŭ�������� ����Ǵ� �ʵ�(������ ���) �� �޼���
 * 	-������ Ŭ���� ��ü�� ������ ��
 * 	-����ڰ� �ʱ�ȭ�� ��Ű�� �ʾƵ� �ڵ��ʱ�ȭ�� �ȴ�.
 * 	-this, super: ������ ���� ����(������ ������ �ּҰ��� ������ �ִ� ����)
 * 	-this: �ڽ��� Ŭ���� �ּҸ� ���� ->�ν��Ͻ� ������ �޼��� ���ο��� ����� ���������� ���� �ܾ�� �����Ǿ��� �� �޼��� ���ο��� �ν��Ͻ� ������ ��Ī�� �� ���
 * 
 * 2) �������
 * 	-static Ű���带 ���
 * 	-���������� �ش� Ŭ������ �޸𸮿� loading�� �� ����->�ʱ�ȭ�� �ѹ��� ����.
 * 	-JVM�޸� �� �޼��� ������ �����
 * 	-�����޼��� ������ �����ϴ� ������ �޼���� �ݵ�� �����̾�� ��
 * 	-�����޼��忡�� this������ ����� �� ����.
 * 	-�����޼��带 ȣ���� ��� �ش� Ŭ�����̸����ε� ȣ�Ⱑ��
 * 	-static�� ����ؼ� ��ü�� ������ ������ ��ǰ��ȣ�� �ٸ��� �ϴ� �� ������ �� ������, ���յ��� �������� ���ۿ� �߻����ɼ��� �ִ�.
 * 		->���� �� �ʿ��� �κи� static�� ����ϴ� ���� ����.
 * 
 * 3)final�ʵ�
 * 	-����, �޼���, Ŭ������ ���
 * 	-������ ���Ǿ� ���ȭ
 * 	-�޼��忡 ���Ǹ� overriding�� ���ѵ�
 * 	-Ŭ������ ���Ǹ� ����Ŭ���� ������ �Ұ�(���� Ŭ����)
 * 	-�ν��Ͻ������� ���Ǹ� �ش� Ŭ������ �缺���� �Ұ���
 */

public class Instance01 {

	public static void main(String[] args) {
		//this ������� ����
		Car2 car=new Car2();
		Car2 car2=new Car2();
		car2.setColor("����");
		car2.setKind("����");
		car2.setMaxSpeed(300);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		System.out.println();
		
		//static�� ����� ��ǰ��ȣ ����
		Prod p1=new Prod();
		p1.printInfo();
		Prod p2=new Prod();
		p2.printInfo();
		Prod p3=new Prod();
		p3.printInfo();
		System.out.println();
		
		//final�ʵ� ��ü���� ����
		final Company cp1=new Company();
		cp1.setName("(��)���Ⱦ�");
		System.out.println("ȸ���: "+cp1.getName());
		//cp1=new Company(); //cp1�� final�� �����߱⶧���� ���� Ŭ���� ��ü�� ������� �Ұ���
		System.out.println();
		
		//final�ʵ� Ŭ�������� ����
		Shape s1=new Shape();
		System.out.println(s1.getShape());
		Rectangle r1=new Rectangle();
		System.out.println(r1.getShape());
		//Shape Ŭ������ final�� ���̸� �ڽ�Ŭ������ ���� �� ���⶧���� ������ ����.
		System.out.println();
		System.out.println("�������̵� �׽�Ʈ");
		Shape s2=new Rectangle();
		System.out.println("Shape s2=new Rectangle()�� ����� "+s2.getShape());
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
class Prod{ //static����
	static int prod_id=99;
	
	public Prod(){// ���ο� ��ü�� ������ ������ ��ǰ��ȣ�� 1�� ����->but ������ ������ �ʱ�ȭ�� �Ͼ�� �׻� ���� ��ȣ ��� ->static��� �ʿ�
		prod_id++;
	}
	public void printInfo(){
		System.out.println("��ǰ��ȣ: "+prod_id);
	}
}
class Company{//final ����
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
		kind="�ٰ���";
	}
	public /*final*/ String getShape(){ //�޼��忡 final�� ������ �������̵��� �� �� ����.
		return kind;
	}
	
}
class Rectangle extends Shape{//��� �� �������̵�
	Rectangle(){
		kind="�簢��"; //�θ�Ŭ�������� ����� �����̱� ������ �ڽ�Ŭ�������� ������� ��밡��
	}
	@Override
	public final String getShape(){
		return "�ٰ����� ����:"+kind;
	}
}