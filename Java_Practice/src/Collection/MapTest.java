package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 -Map-> key값과 value값을 한 쌍으로 관리하는 객체
 	-key값은 중복을 허용하지 않고 순서가 없다.(Set의 특성을 갖는다.)
 	-value값은 중복을 허용한다.
 */

public class MapTest {

	public static void main(String[] args) {
		//Map객체 생성
		HashMap<String, String> map=new HashMap<>(); 
		
		//자료추가->put(key값, value값)
		map.put("name","홍길동");
		map.put("addr","대전");
		map.put("tel","010-1234=5678");
		
		System.out.println("map: "+map);
	
		//자료수정->데이터를 추가할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map: "+map);
		System.out.println();

		//자료 읽기-> get(key값)
		//		->key값과 짝이 되는 value값을 반환한다.
		//		->해당 key값이 없으면 null을 반환한다.
		System.out.println("이름: "+map.get("name"));
		System.out.println();
		
		//자료 삭제->remove(key값)
		//	->key값이 같은 자료를 찾아서 삭제한다.
		//	->반환값: 삭제된 자료의 value값
//		String temp=map.remove("tel");
//		System.out.println("map: "+map);
//		System.out.println("삭제된 값: "+temp);
//		System.out.println();
		
		//key값이 존재하는지 여부 검사하는 메서드-> containsKey(key값)
		//	->해당 key값이 존재하면 true, 없으면 false반환
		System.out.println("tel키값 존재 여부: "+map.containsKey("tel"));
		System.out.println("name키값 존재 여부: "+map.containsKey("name"));
		System.out.println();
		System.out.println("==========================================");
		
		//Map의 모든 데이터를 차례로 읽어와 사용하는 방법
		//1. Map의 모든 key값을 읽어와서 사용하는 방법
		//방법1)keySet()메서드 이용하기->Map의 모든 key값들을 읽어와 Set형으로 반환한다.
		Set<String> keySet=map.keySet();
		
		//방법1-1) Iterator사용
		Iterator<String> it=keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
			
		}
		System.out.println("==============================================");
		
		//방법1-2)향상된 for문 이용
		for(String key: keySet) {
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println("==============================================");
		
		//방법2) values()메서드 사용하기->value값만 읽어와서 처리한다.
		for(String value: map.values()) {
			System.out.println(value);
		}
		System.out.println("==============================================");
		/* 
		Map에는 Entry라는 내부 class가 만들어져 있다. 이 Entry클래스는 key와 value라는 이름의 멤버변수로 구성되어 있다.
		Map에서는 이 Entry객체들을 Set형식으로 저장하여 관리한다.
		*/
		//방법3) Entry객체 전체를 가져와서 처리한다. entrySet()메서드 사용->모든 Entry객체들을 가져와 Set형식으로 반환한다.
		Set<Map.Entry<String, String>> mapSet=map.entrySet();
		Iterator<Map.Entry<String, String>> entryIt=mapSet.iterator();
		while(entryIt.hasNext()) {
			//1개의 Entry객체 구하기
			Map.Entry<String, String> entry=entryIt.next();
			
			System.out.println("key 값: "+entry.getKey());
			System.out.println("value 값: "+entry.getValue());
		}
		
		//이름을 key값으로 사용하고  Person인스턴스를 value값으로 사용하는 Map객체를 생성하시오
		HashMap<String, Person> hashP=new HashMap<>();
		Person p1=new Person();
		hashP.put("홍길동",p1);
		
		Person p4=new Person();
		p4.setNum(10);
		p4.setName("이순신");
		hashP.put("이순신", p4);
		
		hashP.put("강감찬", new Person());
		hashP.put("이몽룡", new Person(11,"이몽룡"));
		System.out.println("이몽룡: "+hashP.get("이몽룡"));
		
		//강감찬의 정보를 번호는 30, 이름은 강감찬으로 셋팅하시오.
		hashP.get("강감찬").setNum(30);
		hashP.get("강감찬").setName("강감찬");
		System.out.println("강감찬: "+hashP.get("강감찬"));
	}

}


