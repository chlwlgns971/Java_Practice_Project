import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		while(true){
//			System.out.print("비밀번호를 입력해주세요: ");
//			String str=sc.nextLine();
//			if (str.equals("Computer")) {
//				System.out.println("접근허용되었습니다."); 
//				break;
//			}
//			else System.out.println("비밀번호가 다릅니다."); 
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
			System.out.print("숫자를 입력하세요: ");
			int a=sc.nextInt();
			if (a%2==0) str1+=a+" ";
			else str2+=a+" ";
			i++;
		}
		System.out.println("입력한 짝수: "+str1);
		System.out.println("입력한 홀수: "+str2);
	}
	public void wl3(){
		int i=1;
		int sum1=0; //홀수합
		int sum2=0; //짝수합
		
		while(i<=100){
			if((i%2)!=0) sum1+=i;
			else sum2+=i;
			i++;
		}
		System.out.println("1부터 100까지 홀수들의 합은 "+sum1+"입니다.");
		System.out.println("1부터 100까지 짝수들의 합은 "+sum2+"입니다.");
	}
	public void wl4(){
		Scanner sc=new Scanner(System.in);
		System.out.print("while문 구구단을 출력할 숫자를 입력하세요: ");
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
		System.out.println("발생한 랜덤 숫자: "+str);
		System.out.println("발생한 랜덤 숫자들의 합: "+sum);
	}
	//whileTest7 (2022.05.11)
		public void insertScore(){
			Scanner sc=new Scanner(System.in);
			int count=0;
			int num=0;
			String str1=""; //올바르게 입력한 값
			String str2=""; //입력한 모든 값
			String str3=""; //올바르지 않은 값
			while(true){
				System.out.println("점수를 입력하세요(1~100점사이): ");
				num=sc.nextInt();
				str2+=num+" ";
				if(num>100 || num<1){
					str3+=num+" ";
					System.out.println("정확한 점수가 아닙니다.");
				}
				else{
					str1+=num+" ";
					count++;
					if (count==5) break;
				}
			}
			System.out.println("입력한 모든 점수: "+str2);
			System.out.println("올바르게 입력한 5개의 점수: "+str1);
			System.out.println("올바르지 않은 입력점수: "+str3);
		}
}