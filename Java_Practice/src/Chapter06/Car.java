package Chapter06;

//�ڵ��� Ŭ����(���赵)
public class Car {
	//�ʵ�=�������=�Ӽ�
	//������
	String company="���";
	//��
	String model;
	String color;
	//�ִ뽺�ǵ�
	int maxSpeed;
	//���� ���ǵ�
	int speed;
	
	//������: ��ü�� ������ �� �ڵ����� ����(�ʱⰪ�� ���� �� ���)
	//�⺻������
	Car(){}
	//������ �����ε�. �Ű����� ���� or ���� or Ÿ���� �޶����
	Car(String model){
		//model: �̰����� �������� ������ �Ķ���͸� ����ִ� �Ű�����(��������: �� ����� ����� �޸𸮿��� �����)
		//�������<=�Ű������� �Ҵ�(����)
//		this.model=model;
//		this.color = "����";
//		this.maxSpeed = 250;
		// this: �������ε� �ٸ� �����ڸ� ȣ��->ù �ٿ����� ���=>�ٸ� ������ ȣ��
		this(model, "����", 250);
	}
	//������ �����ε�
	Car(String model, String color){
		//�Ű������� ���� ��������� �Ҵ�(����)
//		this.model=model;
//		this.color=color;
//		this.maxSpeed = 250;
		this(model, color, 250);
	}
	//������ �����ε�
	Car(String model, String color, int maxSpeed){
		//�Ű������� ���� ��������� �Ҵ�(����)
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color="
				+ color + ", maxSpeed=" + maxSpeed + ", speed=" + speed + "]";
	}
	
}