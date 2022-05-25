package Chapter05;

public class LoopTest {

	public static void main(String[] args) {
		//문제1: 첫날에 100원 그 다음날부터 전날의 2배씩 저축을 할 경우 처음으로 100만원이 넘는 날과 저축금액을 구하라
		//문제2: 1부터 50사이의 피보나치수열 값을 모두 출력하시오
		//---------------------------------------------------------------------------------
		//숙제: 1-2+3-4....-10=? 이와같이 출력되고 결과도 출력되도록 프로그램  
		Quastion qa=new Quastion();
		qa.qa1();
		qa.qa2();
		qa.homework();
		

	}

}
class Quastion{
	public void qa1(){ //저축액
		int money=100;
		int sum=0;
		int count=0;
		while(money<1000000){
			sum+=money;
			count++;
			money*=2;
		}
		System.out.println("저축액이 100만원이 넘어가는 날은 "+(count+1)+"일차입니다.");
		System.out.println(count+"일차까지의 저축액은 "+sum+"원 입니다.");
	}
	public void qa2(){ //피보나치수열
		int num1=1; 
		int num2=1;
		int num3=0; //임시 저장용 변수
		String str="1";
		while(true){
			str+=" "+num2;
			num3=num2;
			num2=num1+num2;
			num1=num3;
			if(num2>50) break;
		}
		System.out.println("1부터 50사이의 피보나치수열: "+str);
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