package Chapter11;
import java.util.*;

/*[2] Map
. Collection 인터페이스와는 다른 저장 방식으로 데이터 저장 
. Map 인터페이스를 구현한 Map 컬렉션 클래스들은 키와 값을 
  하나의 쌍으로 저장하는 방식(key-value 방식)을 사용
. 키(key)는 값(value)을 찾기 위한 이름의 역할  
. 데이터의 저장 순서를 유지하지 않음 
. key :  중복을 허용  X 
. value :  중복은 허용 O  

** HashMap<K, V> 클래스
. Map 컬렉션 클래스에서 가장 많이 사용되는 클래스
. key와 value를 묶어 하나의 entry로 저장
. 해시 알고리즘(hash algorithm)을 사용하여 많은 양의 데이터를 
  검색하는데 검색 속도가 매우 빠름 
. 중복된 키로는 값을 저장할 수 없으며, value에 null값도 사용 가능
. HashMap <k,v> 주요 메소드
  - void clear()    : 해당 맵(map)의 모든 매핑(mapping)을 제거함.
  - boolean containsKey(Object key) :   해당 맵이 전달된 키를 
    포함하고 있는지를 확인함.
  - boolean containsValue(Object value)   : 해당 맵이 전달된 
    값에 해당하는 하나 이상의 키를 포함하고 있는지를 확인함.
  - V get(Object key) :    해당 맵에서 전달된 키에 대응하는 값을 
    반환함. 만약 해당 맵이 전달된 키를 포함한 매핑을 포함하고 있지 
    않으면 null을 반환함.
  - boolean isEmpty() : 해당 맵이 비어있는지를 확인함.
  - Set<K> keySet() : 해당 맵에 포함되어 있는 모든 키로 
    만들어진 Set 객체를 반환함.
  - V put(K key, V value) : 해당 맵에 전달된 키에 대응하는 
    값으로 특정 값을 매핑함.
  - V remove(Object key)   : 해당 맵에서 전달된 키에 대응하는 
    매핑을 제거함.
  - boolean remove(Object key, Object value)    : 
    해당 맵에서 특정 값에 대응하는 특정 키의 매핑을 제거함.
  - V replace(K key, V value) : 해당 맵에서 전달된 키에 
    대응하는 값을 특정 값으로 대체함.
  - boolean replace(K key, V oldValue, V newValue) : 
    해당 맵에서 특정 값에 대응하는 전달된 키의 값을 새로운 값으로 대체함.
  - int size() : 해당 맵의 매핑의 총 개수를 반환함.
  
사용예) 정수로된 학번과 문자열 이름을 map에 저장하고 
    특정 학번의 학생이름을 출력 
    전체학생의 정보 출력 */

public class MapCollection {

	public static void main(String[] args) {
		Map<Integer, String> map= new HashMap<>();
		map.put(1000, "황희찬");
		map.put(1001, "손흥민");
		map.put(1002, "황의조");
		map.put(1003, "이강인");
		System.out.println(map.get(1001));
		Set<Integer> keys=map.keySet();
		Iterator<Integer> iter=keys.iterator();
		System.out.println("map의 사이즈: "+map.size());
		
		while(iter.hasNext()) {
			int stID=iter.next().intValue();
			String name=map.get(stID);
			System.out.println(stID+", "+name);
		}
	}

}
