package Chapter11;
/*제네릭(generic)
- 자바에서 제네릭(generic)이란 데이터의 타입(data type)을 
  일반화한다(generalize)는 것을 의미
- 제네릭은 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 
  미리 지정하는 방법
- 컴파일 시에 미리 타입 검사(type check)를 수행하면 다음과 같은 장점
 . 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있음 
 . 반환값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있음
 . 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아짐 
  타입       설명
------------------- 
  <T>        Type
  <E>        Element
  <K>        Key
  <V>        Value
  <N>        Number
  
[1]class 및 interface 선언 

 public class CassName <T> {....}
 public interface InterfaceName <T> {...}
 -> T 타입은 당 블럭 { ... } 안에서 유효
 
 //2개의 제네릭타입 사
 public class ClassName <T, K> { ... }
 public Interface InterfaceName <T, K> { ... }
 
 // HashMap의 경우 아래와 같이 선언되어있을 것이다.
 public class HashMap <K, V> { ... }

[2]제네릭 클래스 사용     
- 객체 생성시 구체적인 타입 명시  

 public class  Employee <T, K> { ... }

 public class EmpExample {
    public static void main(String[] args) {
       Employee<String, Integer> a = 
          new Employee<String, Integer>();
    }
 }  
- 주의해야 할 점
 . 타입 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)
 . int, double, char 같은 primitive type은 올 수 없다
 . primitive Type의 경우 Integer, Double 같은 
   Wrapper Type으로 사용 
 . 사용자가 정의한 클래스도 타입도 사용 가능  
  
 public class  Employee <T, K> { ... }
 
 public class  Management{ ... }

 public class EmpExample {
    public static void main(String[] args) {
       Employee<Management> a = new Employee<Management>();
    }
 } 
 
[3]제네릭 메서드     
- 별도로 메소드에 한정한 제네릭도 사용가능
- 반환타입 이전에 <> 제네릭 타입을 선언 
- 제네릭이 사용되는 메소드를 정적메소드로 두고 싶은 경우 제네릭 클래스와 별도로 
  독립적인 제네릭이 사용되어야 한다=>정적 메서드는 생성 시점이 클래스 객체 생성시점 보다 빨라서  

(사용형식) 
[접근 제어자] <제네릭타입> [반환타입] [메소드명]([제네릭타입] [파라미터]) {
 // 텍스트
 }
 
 ex)
 public <T> T genericMethod(T o) {   // 제네릭 메소드
    ...
 }
 
[5]제한된 Generic(제네릭)과 와일드 카드    
- 특정 범위 내로 좁혀 제네릭 설정 
- extends, super, ? 사용하여 구현됨 
- ? 는 와일드 카드이며, '알 수 없는 타입'이라는 의미 

  extends T : 상한 경계
  ? super T : 하한 경계   
  <?> : 와일드 카드(Wild card) 
  
  ex)
  <K extends T>   // T와 T의 자손 타입만 가능 (K는 들어오는 타입으로 지정 됨)
  <K super T>   // T와 T의 부모(조상) 타입만 가능 (K는 들어오는 타입으로 지정 됨)
  <? extends T>   // T와 T의 자손 타입만 가능 (?는 타입이 지정되지 않는다)
  <? super T>   // T와 T의 부모(조상) 타입만 가능 (?는 타입이 지정되지 않는다)
  <?>      // 모든 타입 가능. <? extends Object>랑 같은 의미
  
  ex)클래스가
     A
     |
     B       D
     |       |
     C       E 
     
  <T extends B>   // B와 C타입만 올 수 있음
  <T extends E>   // E타입만 올 수 있음
  <T extends A>   // A, B, C, D, E 타입이 올 수 있음

  <? extends B>   // B와 C타입만 올 수 있음
  <? extends E>   // E타입만 올 수 있음
  <? extends A>   // A, B, C, D, E 타입이 올 수 있음
    
  <K super B>   // B와 A타입만 올 수 있음
  <K super E>   // E, D, A타입만 올 수 있음
  <K super A>   // A타입만 올 수 있음

  <? super B>   // B와 A타입만 올 수 있음
  <? super E>   // E, D, A타입만 올 수 있음
  <? super A>   // A타입만 올 수 있음
   =>주로 upcasting에 사용 
   
  ex)  
  public class ClassName <E extends Comparable<? super E> { ... }
   =>특정 제네릭에 대한 자기 참조 비교 
   => E 객체는 반드시 Comparable을 구현해야한다는 의미 

  ex)      
    public class SaltClass <E extends Comparable<E>> { ... }
    =>SaltClass의 E는 Comparable이나 Comparable를 상속 받는 하위 클래스 타입이어야 함 
    =>E는 들어오는 타입으로 지정되어야 하므로 Student 타입이어야 한다 
    
 public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Person o) { ... };
 }

 public class Main {
    public static void main(String[] args) {
       SaltClass<Student> a = new SaltClass<Student>();
    }
 }   
 
[6] Comparable과 Comparator 인터페이스 
1] Comparableinterface

- 객체 비교를 위한 인터페이스 
- Comparable 인터페이스는 compareTo() 메서드(매개변수가 하나임)를 통해 
  객체 간의 순서를 비교하는 기능 제공 (자기 자신과 매개변수 객체 비교)
  =>lang package 
 
 예제] 내용과 순번으로 구성된 객체(Node)를 클래스로 구성하고 이들의 객체의 order
    를 비교하여 크기를 구별하는 프로그램을  Comparable interface
    를 이용하여 작성하시오. 

2] Comparator  interface      
- Comparator 인터페이스는 compare(To1, T o2)메서드를 Override
  하여 두매개변수 객체를 비교  
  =>util package      

 예제] 내용과 순번으로 구성된 객체(Node)를 클래스로 구성하고 이들의 객체의 order
    를 비교하여 크기를 구별하는 프로그램을  Comparator interface
    를 이용하여 작성하시오*/

public class GenericEx {

	public static void main(String[] args) {
		GenStudent<String> st1=new GenStudent<String>();
		GenStudent<Integer> st2=new GenStudent<Integer>();
		//st1.set(50); //int형 변수라 대입이 안됨
		st1.set("홍길동");
		System.out.println(st1.toString());
		System.out.println("T Type="+st1.gmethod(st1.get()).getClass().getName());
		st2.set(50);
		System.out.println(st2.toString());
		System.out.println("T Type="+st2.gmethod(st2.get()).getClass().getName());
	}

}
class GenStudent<T>{
	private T name;
	
	public void set(T name) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		this.name=name;
	}
	public T get(){
		return this.name;
	}
	public<T> T gmethod(T p) {
		return p;
	}
	@Override
	public String toString() {
		return "GenStudent [name=" + name + "]";
	}
	
}
