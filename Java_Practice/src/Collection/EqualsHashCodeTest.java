package Collection;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1=new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2=new Person();
		p2.setNum(2);
		p2.setName("일지매");
		
		Person p3=new Person();
		p3.setNum(1);
		p3.setName("홍길동");
		
		Person p4=p1;
		
		System.out.println(p1==p3); //false
		System.out.println(p1.equals(p3)); //false였으나 equals메서드를 재 정의해서 true로 나온다.
		
		System.out.println(p1==p4); //true
		System.out.println(p1.equals(p4)); //true
		
		HashSet<Person> testSet=new HashSet<>();
		testSet.add(p1);
		testSet.add(p3);
		System.out.println("set의 크기: "+testSet.size());
		System.out.println("p1: "+p1.hashCode());
		System.out.println("p2: "+p2.hashCode());
		System.out.println("p3: "+p3.hashCode());
		System.out.println("p4: "+p4.hashCode());
		
		/*
		 -equals()메서드-> 두 객체의 내용이 같은지 검사하는 메서드
		 -hashCode()메서드-> 두 객체의 동일성을 검사하는 메서드
		 
		 -HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은 객체의 의미상 동일성을 비교하기 위해서 
		 hashCode()메서드를 호출하여 비교한다. 그러므로 객체가 같은지 여부를 결정하려면 hashCode()메서드를 재정의 해야한다.
		 
		 -hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서 같은 hashcode가 나타날 수 있다.
		 */
	}

}
class Person{
	private int num;
	private String name;
	
	public Person() {
		super();
	}
	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + "]";
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, num);
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
}
