import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("���ϴ� ������ ���ڸ� �Է��ϼ���: ");
		int a=sc.nextInt();
		
		for (int i=1; i<=9; i++){
			System.out.println(a+"*"+i+"="+i*a);
		}
		
	}

}