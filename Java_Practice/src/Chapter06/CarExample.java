package Chapter06;

/*ctrl+alt+����Ű�Ʒ�->�Ʒ��ٿ� ���� �� �ڵ� ������ �ٿ��ֱ�
 *shift+home->������ ��ü����
 *ctrl+F6= ��Ű���� �ٸ� �ڹ����Ϸ� �̵�
 *ctrl+F3= �޼ҵ� ������ �����ϸ� �ش� �޼ҵ� ��ġ�� �̵�����
 */

public class CarExample {
	public static void main(String[] args) {
		System.out.println("����");
		// myCar: ��ü, Ŭ��������, �ν��Ͻ�
		Car myCar=new Car("�����ڵ���","�׷���","����",350,0);
		System.out.println("����ȸ��: "+myCar.company);
		System.out.println("�𵨸�: "+myCar.model);
		System.out.println("����: "+myCar.color);
		System.out.println("�ְ�ӵ�: "+myCar.maxSpeed);
		System.out.println("����ӵ�: "+myCar.speed);
		//�ʵ尪 ����
		myCar.speed=60;
		System.out.println(myCar.toString());
		
		//�����ε��׽�Ʈ
		System.out.println("�����ε� �׽�Ʈ ����");
		Car car1=new Car();
		System.out.println("car1.company: "+car1.company);
		System.out.println("car1.model: "+car1.model);
		System.out.println("car1.color: "+car1.color);
		System.out.println("car1.maxSpeed: "+car1.maxSpeed);
		Car car2=new Car("�ڰ���");
		System.out.println("car2.company: "+car2.company);
		System.out.println("car2.model: "+car2.model);
		System.out.println("car2.color: "+car2.color);
		System.out.println("car2.maxSpeed: "+car2.maxSpeed);
		Car car3=new Car("�ڰ���","ȭ��Ʈ");
		System.out.println("car3.company: "+car3.company);
		System.out.println("car3.model: "+car3.model);
		System.out.println("car3.color: "+car3.color);
		System.out.println("car3.maxSpeed: "+car3.maxSpeed);
		Car car4=new Car("�ý�","����",250);
		System.out.println("car4.company: "+car4.company);
		System.out.println("car4.model: "+car4.model);
		System.out.println("car4.color: "+car4.color);
		System.out.println("car4.maxSpeed: "+car4.maxSpeed);
	}
}