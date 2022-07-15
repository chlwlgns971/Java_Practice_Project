import java.util.Scanner;

public class ForWhile {

	public static void main(String[] args) {
		/*
		 반복횟수가 명확할 경우 for문 사용
		 반복횟수가 명확하지 않을 경우 while 사용
		 */
		
		int a=0;
		//while로 5회 반복
		while(a<5){
			System.out.println((a+1)+"회 반복 중입니다.");
			a++;
		}
		//for문으로 5회 반복
		for (int i=0; i<5; i++){
			int rand=(int)(Math.random()*6+1); 
			System.out.println(i+1+"번째 주사위를 굴립니다.");
			System.out.println(rand+" 나왔습니다.");
		}
		For2 f2=new For2();
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자를 입력하세요: ");
		int num=sc.nextInt();
		System.out.println("1부터 "+num+"까지 더한 결과는 "+f2.hap(num)+"입니다.");
	}

}
class For2{
	public int hap(int a){
		//1부터 입력받은 값까지 더하고 리턴한다.
		int sum=0;
		for (int i=1; i<=a; i++){
			sum+=i;
		}
		return sum;
	}
}