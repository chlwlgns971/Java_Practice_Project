package Chapter06;

/*Singleton Class
<<<<<<< HEAD
 * 	-전체 프로그램에서 클래스 객체가 하나만 생성되고 해당 객체가 필요할 때마다 해당 객체의 주소값을 전달
 * 	-생성자 메소드의 접근지정자로 private를 사용하여 외부에서 클래스 객체를 직접 생성하지 못함
 * 	-클래스 내부에서 자신의 타입의 객체를 생성하여 초기화
 * 	-외부에서 호출가능한 getInstance()선언 사용
 * 	-Spring에서 많이 사용
 * 	-Thread에 취약한 면이 있음
 */

public class SingletonEx {

	public static void main(String[] args) {
		//s1은 static으로 선언되었기 때문에 new생성자를 통해 객체생성할 수가 없다.
		//	->따라서 그냥 클래스 이름을 통해 호출이 가능하되, 메서드에도 static을 붙여야 한다.
		//정적 block이용: 인스턴스의 생성 시점이 사용시점이 아니라 클래스 로딩 시점
		Singleton s1=Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2=Singleton.getInstance();
		System.out.println(s2);
		System.out.println();
		
		//인스턴스가 필요한 시점에서 객체 생성
		Singleton01 st1=Singleton01.getInstance();
		System.out.println(st1);
		Singleton01 st2=Singleton01.getInstance();
		System.out.println(st2);
		
		//스레드 처리
		Singleton02 sg1=Singleton02.getInstance();
		System.out.println(st1);
		Singleton02 sg2=Singleton02.getInstance();
		System.out.println(st2);
	}

}
//정적 block이용: 인스턴스의 생성 시점이 사용시점이 아니라 클래스 로딩 시점(잘 사용안함)
class Singleton{
	private static Singleton s1;
	private Singleton(){}
	static{
		try{
			s1=new Singleton();
		}
		catch(Exception e){
			throw new RuntimeException("Create Instance fail"+"msg="+e.getMessage());
		}
	}
	public static Singleton getInstance(){
		return s1;
	}
}
//인스턴스가 필요한 시점에서 객체 생성 (자주사용)
class Singleton01{
	private static Singleton01 s1;
	private Singleton01(){}
	public static Singleton01 getInstance(){
		if(s1==null) s1=new Singleton01();
		return s1;
	}
}
//스레드 처리 포함
class Singleton02{
	private static Singleton02 s1;
	private Singleton02(){}
	public static synchronized Singleton02 getInstance(){
	//스레드에서 동시 접근문제 해결->but 시간이 많이 소요되어 성능저하가 일어남
		if(s1==null) s1=new Singleton02();
		return s1;
	}
}
//스레드 처리 포함+성능개선(이너클래스 이용)
class Singleton03{
	private static Singleton03 s1;
	private Singleton03(){}
	private static class InnerInstance{
		final static Singleton03 s1=new Singleton03();
	}
	public static Singleton03 getInstance(){
		return InnerInstance.s1;
	}
}

