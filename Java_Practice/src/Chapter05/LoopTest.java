package Chapter05;

public class LoopTest {

	public static void main(String[] args) {
		//����1: ù���� 100�� �� ���������� ������ 2�辿 ������ �� ��� ó������ 100������ �Ѵ� ���� ����ݾ��� ���϶�
		//����2: 1���� 50������ �Ǻ���ġ���� ���� ��� ����Ͻÿ�
		//---------------------------------------------------------------------------------
		//����: 1-2+3-4....-10=? �̿Ͱ��� ��µǰ� ����� ��µǵ��� ���α׷�  
		Quastion qa=new Quastion();
		qa.qa1();
		qa.qa2();
		qa.homework();
		

	}

}
class Quastion{
	public void qa1(){ //�����
		int money=100;
		int sum=0;
		int count=0;
		while(money<1000000){
			sum+=money;
			count++;
			money*=2;
		}
		System.out.println("������� 100������ �Ѿ�� ���� "+(count+1)+"�����Դϴ�.");
		System.out.println(count+"���������� ������� "+sum+"�� �Դϴ�.");
	}
	public void qa2(){ //�Ǻ���ġ����
		int num1=1; 
		int num2=1;
		int num3=0; //�ӽ� ����� ����
		String str="1";
		while(true){
			str+=" "+num2;
			num3=num2;
			num2=num1+num2;
			num1=num3;
			if(num2>50) break;
		}
		System.out.println("1���� 50������ �Ǻ���ġ����: "+str);
	}
	public void homework(){ //2022.05.12
		int a=1;
		int sum=0;
		String str="1";
		for(int i=2; i<=10; i++){
			if(i%2==0){
				sum=a-i;
				a=sum;
				str+="-"+i;
			}
			else{
				sum=a+i;
				a=sum;
				str+="+"+i;
			}
		}
		System.out.println("homework 2022.05.12: "+str+"="+sum);
	}
}