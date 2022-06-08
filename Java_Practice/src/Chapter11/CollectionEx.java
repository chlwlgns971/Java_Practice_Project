package Chapter11;
/*
컬렉션 프레임워크 (Collection Framework)
- 자료구조를 사용해서 객체들을 효율적으로 관리할 수 있도록 인터페이스와 
  구현 클래스를 java.util 패키지에서 제공함
- 프레임워크 : 사용 방법을 정해놓은 라이브러리
- 주요 인터페이스로 List, Set, Map이 있음
  collection                               <=interface  
   List           Set          Map         <=interface
     ArrayList      HashSet      HashMap   <=class       
     Vector         TreeSet      TreeMap
     LinkedList                  Hashtable
                                 Properties
[1] ArrayList
  . ArrayList는 List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 
    선형리스트
  . 일반적인 배열과 같은 순차리스트이며 인덱스로 내부의 객체를 관리
  . ArrayList는 객체들이 추가되어 저장 용량(capacity)을 초과한다면 
    자동으로 부족한 크기만큼 저장 용량(capacity)이 늘어난다 
  . 주요메서드 : add(Object o), add(int index, Object o),
              get(int index), remove(int index), clear(), 
              contains(Object o), isEmpty(), indexOf(Object o),
              size(), asList(), iterator()   
 1) ArrayList 선언 
   ArrayList list = new ArrayList();//타입 미설정 Object로 선언
   ArrayList<Student> members = new ArrayList<Student>();//Student객체만 사용가능
   ArrayList<Integer> num = new ArrayList<Integer>();//타입설정 Integer객체 만 사용가능
   ArrayList<Integer> num2 = new ArrayList<>();//new에서 타입 파라미터 생략가능
   ArrayList<Integer> num3 = new ArrayList<Integer>(10);//초기 용량(capacity)지정
   ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));//생성시 값추가
 
 2) iterator() 메서드 
  . iterator()는 반복을 통해 순회하면서 탐색할 때 사용
  . iterator()를 사용하기 위해선 객체를 먼저 생성해주어야 하며, 다음과 같은 
    메소드를 지원
  . hasNext() : 다음 엘리먼트가 있는지 확인 즉, 현재 위치에서 다음 위치로 
    이동할 수 있는지 판단
  . next() : 다음 엘리먼트를 가져오는 역할
  . remove() : next()로 가져온 엘리먼트를 삭제
    
(사용예) 요일들을 저장할 수있는 ArrayList를 생성하고 이를 조작하는 프로그램 작성


[2] Map
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


public class CollectionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
