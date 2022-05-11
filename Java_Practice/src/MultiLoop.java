import java.util.Scanner;

public class MultiLoop {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MultiLoop2 m2=new MultiLoop2();
//		System.out.print("숫자를 입력하세요: ");
//		int num=sc.nextInt();
//		for(int i=1; i<=9; i++){
//			System.out.println(num+"*"+i+"="+num*i);
//		}
		System.out.print("for문 2번 사용하여 구구단출력");
		m2.doubleFor();
		System.out.println("--------------------");
		System.out.println("while문 2번 사용하여 구구단출력");
		m2.doubleWhile();
		//m2.insertnumForLoop(); //입력숫자 구구단 3회 반복
		//m2.doubleForRandom(); // 3번의 큰 루프안에서 랜덤값 5개 생성시키고 합 구하기
		//m2.insertnumWhileLoop(); //입력숫자 구구단 무한반복(q눌러서 종료가능)
		//m2.continueTest(); //1부터 100중에서 짝수 출력(continue 이용)
		m2.continueTest2();
	}

}
class MultiLoop2{ //1
	public void doubleFor(){
		for (int i=1; i<=9; i++){
			for (int j=1; j<=9; j++){
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}
	public void doubleWhile(){
		int i=1;
		while(i<10){
			int j=1;
			while(j<10){
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
		}
	}
	public void insertnumForLoop(){
		Scanner sc=new Scanner(System.in);
		for(int i=1; i<4; i++){
			System.out.println("숫자를 입력하세요: ");
			int num=sc.nextInt();
			for (int j=1; j<10; j++){
				System.out.println(num+"*"+j+"="+num*j);
			}
		}	
	}
	public void doubleForRandom(){ //3
		String str="";
		int hap=0; //선언은 반복문 밖에서 하고 초기화만 반복문 안에서 하는 것이 좋다.(계속 선언되면 메모리 성능에 안좋은 영향을 끼침)
		int rand=0;
		for(int i=0; i<3; i++){
			str="";
			hap=0;
			for(int j=0; j<5; j++){
				rand=(int)(Math.random()*100+1);
				str+=rand+" ";
				hap+=rand;
			}
			System.out.println(i+1+"번째 루프 랜덤값: "+str);
			System.out.println(i+1+"번째 루프 랜덤값의 합: "+hap);
		}
	}
	public void insertnumWhileLoop(){//4,무한루프 while(true) 말고도 for(int i=0; ;i++)같은 조건식 없애도 무한루프 구현가능
		Scanner sc=new Scanner(System.in);
		String str="";
		while(true){
			System.out.print("원하는 구구단 숫자를 입력하세요: ");
			str=sc.nextLine();
			if(str.equals("q")){
				System.out.println("루프를 종료합니다."); 
				break;
			}
			else{
				try {
					int num=Integer.parseInt(str);
					for (int j=1; j<10; j++){
						System.out.println(num+" * "+j+" = "+num*j);
					} 
				}
				catch (Exception e) {
					System.out.println("잘못된 값 입력입니다.");
				}
				
			}
		}
	}
	public void continueTest(){ //continueTest1
		String str1="";
		String str2="";
		for(int i=1; i<=100; i++){
			if (i%2==0) str1+=i+" ";
		}
		System.out.println("짝수: "+str1);
		System.out.println("------------------------------------");
		for(int i=1; i<=100; i++){
			if (i%2!=0) continue;
			str2+=i+" ";
		}
		System.out.println("continue 짝수는 "+str2+"입니다.");
	}
	public void continueTest2(){ //continueTest2
		String str1="";
		String str2="";
		for(int i=1; i<=100; i++){
			if (i%3==0) str1+=i+" ";
		}
		System.out.println("3의 배수: "+str1);
		System.out.println("------------------------------------");
		for(int i=1; i<=100; i++){
			if (i%3!=0) continue;
			str2+=i+" ";
		}
		System.out.println("3의 배수는 "+str2+"입니다.");
	}
	
}