package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 	정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
 	
 	Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때(내부 정렬 기준) 구현하는 인터페이스
 	Comparator은 외부에 별도로 정렬 기준을 구현하고 싶을 때(외부 정렬기준) 구현하는 인터페이스이다.
 	그리고 Comparable에서는 CompareTo() 메서드를 재정의 해야하고, Comparator에서는 compare()메서드를 재정의 해야한다.
 	
 	-String클래스, Wrapper클래스, Date클래스, File클래스에는 내부 정렬 기준이 구현되어 있다.(내부 정렬 기준은 보통 오름차순)
 */

public class ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전: "+list);
		
		//정렬은 Collection.sort()메서드를 이용하여 정렬한다.
		//collection.sort()메서드는 기본적으로 내부 정렬기준을 정렬한다.
		Collections.sort(list);
		System.out.println("정렬후: "+list);
		Collections.shuffle(list); //데이터 섞기
		System.out.println("셔플후: "+list);
		
		//외부정렬 기준을 지정해서 정렬하기
		Collections.sort(list,new Desc());
		System.out.println("내림차순 정렬후: "+list);
		//System.out.println("최지훈".compareTo("이원걸"));
		
		//내부정렬 테스트
		ArrayList<Member> memList=new ArrayList<Member>();
		
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(5,"이순신","010-5555-5555"));
		memList.add(new Member(9,"성춘향","010-9999-9999"));
		memList.add(new Member(3,"강감찬","010-3333-3333"));
		memList.add(new Member(6,"일지매","010-6666-6666"));
		memList.add(new Member(2,"변학도","010-2222-2222"));
		
		System.out.println("정렬전...");
		for(Member mem:memList) {
			System.out.println(mem);
		}
		System.out.println("===============================================");
		
		Collections.sort(memList);
		System.out.println("정렬후...");
		for(Member mem:memList) {
			System.out.println(mem);
		}
		System.out.println("===============================================");
		
		//문제
		//Member의 회원번호(num)의 내림차순으로 정렬하는 외부정렬 기준 클래스를 이용하여 정렬하시오
		//외부정렬 기준을 지정해서 정렬하기
		Collections.sort(memList,new Desc2());
		System.out.println("내림차순 정렬후: "+memList);
		
		/*
		문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다. 이 Student클래스의 생성자에서는 
		학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화한다.
		이 Student객체는 List에 저장하여 관리한다.
		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬기준을 구현하고, 총점의 역순으로 정렬하는데 총점이 같으면 이름의
		오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
		
		단 등수는 학생관리를 처리하는 클래스에서 구하도록 하는데 List에 전체 데이터가 추가된 후에 처리되도록 한다.(클래스명:StudentTest)
		*/
	}

}
//정렬 방식을 정해주는 Class를 만든다.(외부 정렬 기준 클래스)
//Comparator인터페이스를 구현해서 작성해야 한다.
class Desc implements Comparator<String>{
	
	/*
	compare()메서드를 이용해서 정렬하고자 하는 기준을 정한다.
	compare()메서드의 반환값과 의미
		-반환값이 0은 두 값이 같다.
		-반환값이 양수=>앞, 뒤의 순서를 바꾼다.
		-반환값이 음수=>앞, 뒤의 순서를 바꾸지 않는다.
		ex) 오름차순일 경우=> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 구현하면 된다.
	*/
	@Override
	public int compare(String str1, String str2) {
		//내림차순으로 정렬하도록 구현
		/*if(str1.compareTo(str2)>0) {
			return -1;
		}
		else if(str1.compareTo(str2)<0) {
			return 1;
		}
		else return 0;*/
		
		return str1.compareTo(str2)*(-1);
	}
}
//내부정렬 테스트용 회원데이터를 저장할 class 작성하기
//=> Member클래스의 회원이름을 기준으로 오름차순 정렬이 되도록 내부 정렬 기준을 추가하기 -> Comparable인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num;	//회원번호
	private String name;//회원이름
	private String tel;	//전화번호
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	@Override
	public int compareTo(Member mem) {
		//회원이름의 오름차순 정렬 기준 만들기
		return this.getName().compareTo(mem.getName());
	}
	
}
class Desc2 implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		}
		else if(o1<o2) {
			return 1;
		}
		else return 0;
	}
	
}
