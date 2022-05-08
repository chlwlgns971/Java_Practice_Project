//Operator01
/*1. �������� ����
 * 	-���, ����, ��, ����, ����, ����
 * 	-����, ����, ����
 * 	-�� ������(!->&&->||������ ����)
 */
public class Operator {
	public static void main(String[] args) {
		int a=5;
		int b=5;
		int c=7;
		
		//���� ������
		UnaryOperator up=new UnaryOperator();
		System.out.println("a++ is "+up.postfixIncrement(a));
		System.out.println("++a is "+up.prefixIncrement(a));
		System.out.println("a-- is "+up.postfixDecrement(a));
		System.out.println("--a is "+up.prefixDecrement(a));
		
		//���� ������
		BinaryOperator bo=new BinaryOperator();
		System.out.println("a+b="+bo.add(a, b)); 
		System.out.println("a-b="+bo.minus(a, b)); 
		System.out.println("a*b="+bo.multiply(a, b));
		System.out.println("c/a="+bo.divide(c, a)); 
		System.out.println("c%a="+bo.remain(c, a)); 
		System.out.println("2022%7="+bo.remain(2022, 7));
		
		//���� ������
		RelationalOperator ro=new RelationalOperator();
		System.out.println("boolean a>b="+ro.compare(a, b));
		System.out.println("boolean ('co'=='Co')="+ro.compare("co", "Co"));
		System.out.println("boolean ('co'=='co')="+ro.compare("co", "co"));
		System.out.println("boolean (new String('co')==new String('co'))="
				+ro.compare(new String("co"), new String("co")));//��ü�� ���� �����߱� ������ ���� �ٸ� �ּ��� String�̶� false
		System.out.println("boolean equals(new String('co')==new String('co'))="
				+(ro.compareEquals(new String("co"), new String("co")))); //equals�� ����ϸ� �ּҰ� �ٸ����� �� ��ü�� ���ϱ� ������ true���
		System.out.println("boolean ('c'=='c')="+ro.compare('c', 'c'));// �ƽ�Ű�ڵ�� a>b�� �޼ҵ忡 ���⶧���� false
		
		//��������
		LogicalOperator lo=new LogicalOperator();
		System.out.println("True && True is "+lo.and(true, true));
		System.out.println("False && True is "+lo.and(false, true));
		System.out.println("True || True is "+lo.or(true, true));
		System.out.println("False || True is "+lo.or(false, true));
		System.out.println("True 'NOT' is "+lo.not(true));
		System.out.println("False 'NOT' is "+lo.not(false));
		//�������� �׽�Ʈ(�����Ǻ�)
		int year=1997;
		if(lo.or(lo.and(year%4==0, year%100 !=0),year%400==0)){
			System.out.println(year+"���� �����Դϴ�.");
		}
		else System.out.println(year+"���� ����Դϴ�.");
		
		//���� ������
		System.out.println(a>b ? true:false); //a�� b���� ū�� ���̸� true���, �ƴ϶�� false���
		System.out.println(a==b ? true:false); //a�� b�� ���ٸ� true ���, �ƴ϶�� false���
		
	}
}
class UnaryOperator{//���׿�����=����������
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
class BinaryOperator{//���׿�����
	public int add(int a, int b){ //���ϱ�
		int res=a+b;
		return res;
	}
	public double add(double a, int b){ //�����ε�(���� ���� �̸��� add�޼ҵ尡 ���������� Ÿ���� �ٸ��� ������ ��밡��)
		double res=a+b;
		return res;
	}
	public int minus(int a, int b){ //����
		int res=a-b;
		return res;
	}
	public int divide(int a, int b){ //������ ��
		int res=a/b;
		return res;
	}
	public int remain(int a, int b){ //������ ������
		int res=a%b;
		return res;
	}
	public int multiply(int a, int b){ // ����
		int res=a*b;
		return res;
	}
}
class RelationalOperator{//���迬����
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