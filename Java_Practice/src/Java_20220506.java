import java.util.Scanner;


public class Java_20220506 {

	public static void main(String[] args) {
		Sample sample = new Sample();
		sample.calc(4, 2);
		int res=sample.add(23, 56);
		System.out.println("res="+res);
		
		int res2=sample.add(56, 12);
		System.out.println("res="+res2);
		
		Scanner sc=new Scanner(System.in);
		System.out.print("���ڿ��� �Է����ּ���:");
		String inputText=sc.nextLine();
		System.out.println(inputText);
		
		System.out.print("���ڸ� �Է����ּ���:");
		int a=sc.nextInt();
		int c=a+a++; //3+3
		int b=a+(++a); //4+5
		System.out.println(c);
		System.out.println(b);
	}

}
class Sample{
	public int add(int a, int b) {
		return a+b;
	}
	public void calc(int a, int b) {
		int result=a+b;
		System.out.println(a+"+"+b+"="+result);
	}
}