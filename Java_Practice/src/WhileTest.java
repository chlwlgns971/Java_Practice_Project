import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		while(true){
//			System.out.print("��й�ȣ�� �Է����ּ���: ");
//			String str=sc.nextLine();
//			if (str.equals("Computer")) {
//				System.out.println("�������Ǿ����ϴ�."); 
//				break;
//			}
//			else System.out.println("��й�ȣ�� �ٸ��ϴ�."); 
//		}
		LoopWhile lw=new LoopWhile();
		//lw.wl();
		//lw.wl2();
		//lw.wl3();
		//lw.wl4();
		//lw.wl5();
		lw.insertScore();
	}

}
class LoopWhile{
	public void wl(){
		System.out.println("While----");
		int i=1;
		while(i<=10){
			System.out.println(i);
			i++;
		}
	}
	public void wl2(){
		Scanner sc=new Scanner(System.in);
		int i=1;
		String str1="";
		String str2="";
		while(i<=5){
			System.out.print("���ڸ� �Է��ϼ���: ");
			int a=sc.nextInt();
			if (a%2==0) str1+=a+" ";
			else str2+=a+" ";
			i++;
		}
		System.out.println("�Է��� ¦��: "+str1);
		System.out.println("�Է��� Ȧ��: "+str2);
	}
	public void wl3(){
		int i=1;
		int sum1=0; //Ȧ����
		int sum2=0; //¦����
		
		while(i<=100){
			if((i%2)!=0) sum1+=i;
			else sum2+=i;
			i++;
		}
		System.out.println("1���� 100���� Ȧ������ ���� "+sum1+"�Դϴ�.");
		System.out.println("1���� 100���� ¦������ ���� "+sum2+"�Դϴ�.");
	}
	public void wl4(){
		Scanner sc=new Scanner(System.in);
		System.out.print("while�� �������� ����� ���ڸ� �Է��ϼ���: ");
		int num=sc.nextInt();
		int i=1;
		while(i<10){
			System.out.println(num+"*"+i+"="+num*i);
			i++;
		}
		
	}
	public void wl5(){
		int sum=0;
		int i=0;
		String str="";
		while(i<5){
			int rand=(int)(Math.random()*100+1);
			str+=rand+" ";
			sum+=rand;
			i++;
		}
		System.out.println("�߻��� ���� ����: "+str);
		System.out.println("�߻��� ���� ���ڵ��� ��: "+sum);
	}
	//whileTest7 (2022.05.11)
		public void insertScore(){
			Scanner sc=new Scanner(System.in);
			int count=0;
			int num=0;
			String str1=""; //�ùٸ��� �Է��� ��
			String str2=""; //�Է��� ��� ��
			String str3=""; //�ùٸ��� ���� ��
			while(true){
				System.out.println("������ �Է��ϼ���(1~100������): ");
				num=sc.nextInt();
				str2+=num+" ";
				if(num>100 || num<1){
					str3+=num+" ";
					System.out.println("��Ȯ�� ������ �ƴմϴ�.");
				}
				else{
					str1+=num+" ";
					count++;
					if (count==5) break;
				}
			}
			System.out.println("�Է��� ��� ����: "+str2);
			System.out.println("�ùٸ��� �Է��� 5���� ����: "+str1);
			System.out.println("�ùٸ��� ���� �Է�����: "+str3);
		}
}