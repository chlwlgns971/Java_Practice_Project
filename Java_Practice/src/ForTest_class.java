import java.util.Scanner;

public class ForTest_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		For4 for4=new For4();
		Scanner sc=new Scanner(System.in);
//		System.out.print("������ ���ڸ� �Է����ּ���: ");
//		int num=sc.nextInt();
//		for4.guguProc(num);
//		for4.minusCount(num);
//		System.out.println("\n");
//		System.out.println(for4.guguProc2(num));
		System.out.println("hap1 �޼ҵ��� ����� "+for4.hap1()+"�Դϴ�.");
		for4.hap2();
	}

}
class For4{
	public void guguProc(int a){
		for (int i=1; i<=9; i++){
			System.out.println(a+"*"+i+"="+i*a);
		}
	}
	public String guguProc2(int a){
		String str="";
		for (int i=1; i<=9; i++){
			str+=a+"*"+i+"="+i*a+"\n";
		}
		return str;
	}
	public void minusCount(int a){
		for (int i=9; i>=1; i--){
			System.out.println(a+"*"+i+"="+i*a);
		}
	}
	//1~10���� ���� ���ؼ� �����ϴ� �޼ҵ�
	public int hap1(){
		int a=0;
		for(int i=10; i>=1; i--){
			a+=i;
		}
		return a;
	}
	
	//10~1���� ���� ���ؼ� ����ϴ� �޼ҵ带 �ۼ�
	public void hap2(){
		int a=0;
		for(int i=10; i>=1; i--){
			a+=i;
		}
		System.out.println("10~1������ ���� "+a+"�Դϴ�.");
	}
}
