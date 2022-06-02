package Chapter11;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/*[1]Object class
- java.lang 패키지는 자바에서 가장 기본적인 동작을 수행하는 클래스들의 집합
- java.lang 패키지의 클래스들은 import 문을 사용하지 않아도 
  클래스 이름만으로 바로 사용할 수 있
- java.lang 패키지 중에서도 가장 많이 사용되는 클래스
- Object 클래스는 모든 자바 클래스의 최고 조상 클래스
- 자바의 모든 클래스는 Object 클래스의 모든 메소드를 사용할 수 있음
- Object 클래스는 필드 없 총 11개의 메소드만으로 구성
  clone(),equals(),finalize(), Class<T>getClass(),hashCode(),
  notify(),notifyAll(),toString(),wait(),wait(long timeout),
  wait(long timeout, int nanos) 
1) toString() 메서드
 . toString() 메소드는 해당 인스턴스에 대한 정보를 문자열로 반환
 . 반환되는 문자열은 클래스 이름, '@'(구분자), 16진수 
   해시 코드(hash code:인스턴스의 주소)로 구성 
 . equals() 메소드는 기본적으로 각 API 클래스마다 
   자체적으로 오버라이딩을 통해 재정의 
 . 출력문에서 인스턴스변수를 기술하면 toString()가 자동 호  
    
예제1] 학번, 이름 필드를 갖는 학생클래스를 설계하고 각 학생의 정보를 
      출력하는 toString()메서드 작성    
      
2) clone() 메서드
 . 인스턴스를 복제하여, 새로운 인스턴스를 생성해 반환
 . 필드의 값만을 복사하므로, 필드의 값이 배열이나 인스턴스면 제대로 복제할 수 없음 
   -> 해당 클래스에서 clone() 메소드를 오버라이딩
 . clone() 메소드는 데이터를 보호하기 위하여 Cloneable 인터페이스를 구현한 
   클래스의 인스턴스만이 사용할 수 있음  
   
예제2] 자동차 모델과 소유자 이름을 보관 할 수 있는 Car class를 생성하고 
     생성된 Car 객체를 복사할 수 있도록  clone()를 재정의 하시오  
3) equals()메서드 
 . 기본 동작은 '==' 연산 결과 반환
 . override 목적: 물리적으로 다른 메모리에 위치하는 객체여도 논리적으로 
   동일함을 구현하기 위해 사용 
   -> 논리적 동일함'은 물리적으로 다른 위치에 있지만 같은 id의 회원 객체, 
      같은 id의 주문 객체와 같이 도메인을 구분할 수 있는 고유한 값 등에 
      의해 동일한 것을 의미   
      
4) hashCode()메서드 
 . JVM이 부여한 코드값으로 인스턴스가 저장된 가상머신의 주소를 10진수로 반환
 . override 목적: 두 개의 서로 다른 메모리에 위치한 객체가 동일성을 갖기 
   위함 -> 자바에서의 동일성은 equals()의 반환값이 true, 
   hashCode() 반환값이 동일함을 의미    
   
[2]System class
- 자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 JVM 위에서 실행
- 운영체제의 모든 기능을 자바 코드로 직접 접근하기 곤란 
- System클래스를 이용하여 운영체제의 일부 기능 이용 가능 
1) exit()메서드 
 . 현재 실행하고 있는 프로세스를 강제 종료시키는 역활
 . 종료 상태값(정상종료 : 0, 비정상 종료 : 0 이외의 값 사용)

2) garbage collection()메서드 
 . 자바는 개발자가 메모리를 직접 코드로 관리하지 않고 
   JVM이 자동으로 관리
 . JVM은 메모리가 부족할 떄와 CPU가 한가할 때에 쓰레기 수집기를 실행시켜 
   사용하지 않은 객체를 자동으로 제거
 . gc()는 쓰레기 수집기 실행을 요청(직접 실행할 수 없음)   

3) currentTimeMillis()메서드 
 . 1970년 1월 1일 자정부터 현재까지의 시간을 밀리초로 반환
 
4) arraycopy()메서드 
 . 배열을 복사
 (사용형식)
 arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
  -> src와 dest은 복사될 배열의 변수이고, 
     srcPos와 destPos는 복사가 시작될 위치이고, 
     length는 복사될 배열의 크기 
     
[3]Class class
- 자바의 모든 클래스와 인터페이스는 컴파일 후 class 파일로 생성
- class파일에는 멤버변수, 메서드, 생성자 등 객체의 정보가 포함
- 이 class파일에서 객체에 정보를 가져올 때 사용되는 클래스
1) Class 객체 얻기(getClass(), forName()) 
 . 최상위 클래스인 Object의 getClass()메소드를 이용해서 Class 객체를 얻거나 
   Class객체의 forName()를 이용하여 정보 취득 가능 
     
[4]String class
- Char 배열로 생성된 불변 객체 값(private final char value[];)
- 스트링 클래스 선언 방법
 . 리터럴
 . new 를 사용한 선언   
- 리터럴로 선언된 String 클래스는 선언시 객체가 
  String constant pool 에 저장
- new 는 Heap 영역에 저장 
- 주요 메서드
  length(), isEmpty(),charAt(int index), getBytes():byte[]로 리턴
  indexOf(String str),substring(int beginindex),
  subString(int beginIndex, int endIndex), 
  replace(CharSequence target, CharSequence replacement), 
  toUpperCase(), toLowerCase(), trim, valueOd(int i), 
  valueOf(Double d)
  
[4]Wrapper class
- 기본 타입의 데이터를 객체로 취급해야 하는 경우 사용 
- Byte, Short, Integer, Long, Float, Double, Character, Boolean
- java.lang 패키지에 포함
1) 박싱(Boxing)과 언박싱(UnBoxing)
  . 래퍼 클래스(Wrapper class)는 산술 연산을 위해 정의된 클래스가 아님
    => 인스턴스에 저장된 값을 변경할 수 없
  . 값을 참조하기 위해 새로운 인스턴스를 생성하고, 생성된 인스턴스의 값만을 참조
  . 기본 타입의 데이터를 래퍼 클래스의 인스턴스로 변환하는 과정=> 박싱(Boxing)
  . 래퍼 클래스의 인스턴스에 저장된 값을 다시 기본 타입의 
    데이터로 꺼내는 과정 => 언박싱(UnBoxing)
    
2) 문자열 변환 : valueOf()
   String a=String.valueOf(10); 
   String b=String.valueOf(true);    
   
3) 객체를 기본형으로 변환 
   객체명.기본형이름Value()
   
   Integer a=new Integer(30);
   int i=a.intValue();   
   
4) 문자열을 기본형으로 변환
   래퍼크래스.parse기본타입(문자열)
   
  short s=Short.parseShort("10");   
  double d=Double.parseDouble("29.56");*/

public class ObjectClass {

	public static void main(String[] args) {
		//cloneTest
		CloneTest cl1=new CloneTest();
		cl1.setModelName("소나타");
		cl1.setOwner("홍길동");
		
		//EqualTest
		User user01=new User(1000,"홍정기");
		User user02=new User(1000,"홍정기");
		System.out.println(user01==user02);
		System.out.println(user01.equals(user02));
		
		//toStringTest
		Student s1=new Student(1234,"홍길동");
		System.out.println(s1);
		System.out.println(s1.toString());
		int[] num=new int[10];
		System.out.println(num);
		System.out.println(num.toString());
		
		//currentTimeMillis()
		long start=System.currentTimeMillis();
		long end=System.currentTimeMillis();
		try {
			System.out.println("start time: "+System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("erroe");
			System.out.println(e.getMessage());
		}
		
	}

}
class User{
	private int id;
	private String name;
	
	public User(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			return this.getId()==((User)obj).getId();
		}
		else return false;
	}
	 
}
class Student{
	private int studNo;
	private String studName;
	public Student(){}
	   
	public Student(int studNo, String studName){
		this.studNo=studNo;
		this.studName=studName;
   }
	public int getStudNo() {
		return studNo;
	}
	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}

	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", studName=" + studName + "]";
	}
	
}
class CloneTest implements Cloneable {
   private String modelName;
   private ArrayList<String> owner=new ArrayList<String>();
   //자동형변환 방지를 위해서 owner라고 이름 붙은 ArrayList에는 들어갈 수 있는 dataType을
   //String Type. 문자열로 한정한 것. 그 외는 저장 될 수 없음. 
   
   public String getModelName() {
      return modelName;
   }
   public void setModelName(String modelName) {
      this.modelName = modelName;
   }
   public ArrayList<String> getOwner() {
      return owner;
   }
   public void setOwner(String name) {
      this.owner.add(name);
      //이렇게 살짝 바꿔줘야함, 그러면 배열로 저장됨...
   }
   
   @Override
   public Object clone(){
      try{
         CloneTest cloneCar=(CloneTest)super.clone();
         //super에서 clone 호출하면 object type으로 변한다고
         //내가 생성하고자 하는 Car 타입으로 down casting 함
         cloneCar.owner=(ArrayList)owner.clone();
         return cloneCar;
      }
      catch(CloneNotSupportedException e) {
    	  e.printStackTrace();
    	  return e;
      }
   }
   
   
}