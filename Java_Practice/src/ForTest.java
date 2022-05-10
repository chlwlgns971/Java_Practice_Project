import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("원하는 구구단 숫자를 입력하세요: ");
		int a=sc.nextInt();
		
		for (int i=1; i<=9; i++){
			System.out.println(a+"*"+i+"="+i*a);
		}
		
	}

}