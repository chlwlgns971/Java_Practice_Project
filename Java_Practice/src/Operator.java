//Operator01
/*1. 연산자의 종류
 * 	-산술, 관계, 논리, 대입, 증감, 조건
 * 	-단항, 이항, 삼항
 * 	-논리 연산자(!->&&->||순으로 연산)
 */
public class Operator {
	public static void main(String[] args) {
		int a=5;
		int b=5;
		int c=7;
		
		//단항 연산자
		UnaryOperator up=new UnaryOperator();
		System.out.println("a++ is "+up.postfixIncrement(a));
		System.out.println("++a is "+up.prefixIncrement(a));
		System.out.println("a-- is "+up.postfixDecrement(a));
		System.out.println("--a is "+up.prefixDecrement(a));
		
		//이항 연산자
		BinaryOperator bo=new BinaryOperator();
		System.out.println("a+b="+bo.add(a, b)); 
		System.out.println("a-b="+bo.minus(a, b)); 
		System.out.println("a*b="+bo.multiply(a, b));
		System.out.println("c/a="+bo.divide(c, a)); 
		System.out.println("c%a="+bo.remain(c, a)); 
		System.out.println("2022%7="+bo.remain(2022, 7));
		
		//관계 연산자
		RelationalOperator ro=new RelationalOperator();
		System.out.println("boolean a>b="+ro.compare(a, b));
		System.out.println("boolean ('co'=='Co')="+ro.compare("co", "Co"));
		System.out.println("boolean ('co'=='co')="+ro.compare("co", "co"));
		System.out.println("boolean (new String('co')==new String('co'))="
				+ro.compare(new String("co"), new String("co")));//객체를 새로 생성했기 때문에 서로 다른 주소의 String이라서 false
		System.out.println("boolean equals(new String('co')==new String('co'))="
				+(ro.compareEquals(new String("co"), new String("co")))); //equals를 사용하면 주소가 다르더라도 값 자체를 비교하기 때문에 true출력
		System.out.println("boolean ('c'=='c')="+ro.compare('c', 'c'));// 아스키코드로 a>b비교 메소드에 들어가기때문에 false
		
		//논리연산자
		LogicalOperator lo=new LogicalOperator();
		System.out.println("True && True is "+lo.and(true, true));
		System.out.println("False && True is "+lo.and(false, true));
		System.out.println("True || True is "+lo.or(true, true));
		System.out.println("False || True is "+lo.or(false, true));
		System.out.println("True 'NOT' is "+lo.not(true));
		System.out.println("False 'NOT' is "+lo.not(false));
		//논리연산자 테스트(윤년판별)
		int year=1997;
		if(lo.or(lo.and(year%4==0, year%100 !=0),year%400==0)){
			System.out.println(year+"년은 윤년입니다.");
		}
		else System.out.println(year+"년은 평년입니다.");
		
		//삼항 연산자
		System.out.println(a>b ? true:false); //a가 b보다 큰게 참이면 true출력, 아니라면 false출력
		System.out.println(a==b ? true:false); //a와 b가 같다면 true 출력, 아니라면 false출력
		
	}
}
class UnaryOperator{//단항연산자=증감연산자
	public int prefixIncrement(int a){
		int res=++a;
		return res;
	}
	public int postfixIncrement(int a){
		int res=a++;
		return res;
	}
	public int prefixDecrement(int a){
		int res=--a;
		return res;
	}
	public int postfixDecrement(int a){
		int res=a--;
		return res;
	}
	
}
class BinaryOperator{//이항연산자
	public int add(int a, int b){ //더하기
		int res=a+b;
		return res;
	}
	public double add(double a, int b){ //오버로딩(위에 같은 이름의 add메소드가 존재하지만 타입이 다르기 때문에 사용가능)
		double res=a+b;
		return res;
	}
	public int minus(int a, int b){ //빼기
		int res=a-b;
		return res;
	}
	public int divide(int a, int b){ //나눗셈 
		int res=a/b;
		return res;
	}
	public int remain(int a, int b){ //나눗셈 나머지
		int res=a%b;
		return res;
	}
	public int multiply(int a, int b){ // 곱셈
		int res=a*b;
		return res;
	}
}
class RelationalOperator{//관계연산자
	public boolean compare(int a,int b){
		boolean res=a>b;
		return res;
	}
	public boolean compare(String a,String b){
		boolean res=(a==b);
		return res;
	}
	public boolean compareEquals(String a,String b){
		boolean res=a.equals(b);
		return res;
	}
}
class LogicalOperator{
	public boolean and(boolean a, boolean b){
		boolean res=a&&b;
		return res;
	}
	public boolean or(boolean a, boolean b){
		boolean res=a||b;
		return res;
	}
	public boolean not(boolean a){
		return (!a);
	}
}