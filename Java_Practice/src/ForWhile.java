import java.util.Scanner;

public class ForWhile {

	public static void main(String[] args) {
		/*
		 �ݺ�Ƚ���� ��Ȯ�� ��� for�� ���
		 �ݺ�Ƚ���� ��Ȯ���� ���� ��� while ���
		 */
		
		int a=0;
		//while�� 5ȸ �ݺ�
		while(a<5){
			System.out.println((a+1)+"ȸ �ݺ� ���Դϴ�.");
			a++;
		}
		//for������ 5ȸ �ݺ�
		for (int i=0; i<5; i++){
			int rand=(int)(Math.random()*6+1); 
			System.out.println(i+1+"��° �ֻ����� �����ϴ�.");
			System.out.println(rand+" ���Խ��ϴ�.");
		}
		For2 f2=new For2();
		Scanner sc=new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���: ");
		int num=sc.nextInt();
		System.out.println("1���� "+num+"���� ���� ����� "+f2.hap(num)+"�Դϴ�.");
	}

}
class For2{
	public int hap(int a){
		//1���� �Է¹��� ������ ���ϰ� �����Ѵ�.
		int sum=0;
		for (int i=1; i<=a; i++){
			sum+=i;
		}
		return sum;
	}
}
